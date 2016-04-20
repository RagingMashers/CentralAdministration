import Panels.IPanel;
import Panels.PanelFactory;
import SitaApi.ArrayOfTeam;
import SitaApi.SitaApiSoap;
import SitaApi.Team;
import SitaApi.Media;
import SitaApi.MediaAccepted;
import SitaApi.SitaApiSoap;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import sun.misc.IOUtils;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.net.URLConnection;
import java.time.LocalDate;
import java.util.*;

public class OverviewController implements IController{

    // COMMUNICATION WITH TEAM TAB
    @FXML
    private JFXTextField cTFTitel;
    @FXML
    private JFXTextArea cTAInhoud;
    @FXML
    private JFXListView<Team> cLVTeams;

    // SOURCES TAB
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private AnchorPane totalContent;
    @FXML private VBox contentHolderR1;
    @FXML private VBox contentHolderR2;
    @FXML private VBox contentHolderR3;
    @FXML private VBox selectedSources;

    @FXML private Menu menuBack;
    @FXML private DatePicker endDate;
    @FXML private DatePicker startDate;
    @FXML private TextField tfTextFilter;
    @FXML private CheckBox cbAcceptedFilter;

    private Map<Media, Object> mediaObjects = new HashMap<>();

    // FIELDS
    private LinkedList<IPanel> panels = new LinkedList<>();


    private final int SPACING = 10;
    ApiManager manager = ApiManager.getInstance();
    SitaApiSoap port = manager.getSitaPort();
    String token = manager.getSitaToken();
    Team selectedTeam;

    /**
     * Author Frank Hartman
     * Send a message to a selected team
     */
    public void sendMessageToTeam(){
        try {
            port.sendMessage(token, selectedTeam.getId(), cTAInhoud.getText());
            cTFTitel.setText("");
            cTAInhoud.setText("Beste hulpverlener,");
            cLVTeams.getSelectionModel().clearSelection();
            selectedTeam = null;
        }
        catch(Exception ex)
        {
            MessageBox.showException("Er is een fout opgetreden!", "Neem contact op met de administrator", "", ex);
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
        contentHolderR1.setSpacing(SPACING);
        contentHolderR2.setSpacing(SPACING);
        contentHolderR3.setSpacing(SPACING);

        startDate.setValue(LocalDate.now());
        endDate.setValue(LocalDate.now());
        selectedSources.setSpacing(SPACING);
    }

    /**
     * Add a panel with a image to the panel
     * @param title the title of the panel
     * @param image the image of the panel
     */
    private void addPanel(String title, Image image) {
        VBox nextBox = getNextPanel();
        IPanel panel = PanelFactory.getPanel(PanelFactory.Type.image, title, image, nextBox);
        panels.add(panel);
        getNextPanel().getChildren().add(panel.getParentNode());
    }

    /**
     * Add a panel with text to the panel
     * @param title the title of the panel
     * @param text the text of the panel
     */
    private void addPanel(String title, String text) {
        VBox nextBox = getNextPanel();
        IPanel panel = PanelFactory.getPanel(PanelFactory.Type.text, title, text, nextBox);
        panels.add(panel);
        getNextPanel().getChildren().add(panel.getParentNode());
    }

    /**
     * Load or reload all of the panels on the screen
     */
    void loadPanels() {
        contentHolderR1.getChildren().clear();
        contentHolderR2.getChildren().clear();
        contentHolderR3.getChildren().clear();

        ListIterator<IPanel> listIterator = panels.listIterator();
        while (listIterator.hasNext()) {
            getNextPanel().getChildren().add(listIterator.next().getParentNode());
        }
    }

    /**
     * Get the next vbox
     * @return The vbox
     */
    private VBox getNextPanel() {
        int row1Count = contentHolderR1.getChildren().toArray().length;
        VBox selectedVBox;
        if (contentHolderR2.getChildren().toArray().length < row1Count)
            selectedVBox = contentHolderR2;
        else if (contentHolderR3.getChildren().toArray().length < row1Count)
            selectedVBox = contentHolderR3;
        else
            selectedVBox = contentHolderR1;

        return selectedVBox;
    }

    private void postLoadSources(){
        ApiManager api = ApiManager.getInstance();
        SitaApiSoap port = api.getSitaPort();
        String token = api.getSitaToken();

        List<Object> sources = port.getMedia(token, 1, 10).getAnyType();

        for (Object source :
                sources) {
            if(!(source instanceof Media)){
                System.out.println("Error " + source + " is not of type Media");
                continue;
            }
            Media m = (Media)source;

            String url = "http://localhost:15012/MediaDownload.ashx?id="+m.getId();

            System.out.println("Getting image :\""+url+"\"");
            if(m.getMimeType().startsWith("image")){//its an image!
                Image img = new Image(url);
                mediaObjects.put(m, img);
                Platform.runLater(()->addPanel(m.getSource(),img));
            }else{
                String result = httpGetString(url);
                mediaObjects.put(m, result);
                Platform.runLater(()->addPanel(m.getSource(),result));
            }
            System.out.println("Got :\""+url+"\"");
        }
    }

    private String httpGetString(String urlt) {
        try {
            URL url = new URL(urlt);
            URLConnection con = url.openConnection();
            InputStream in = con.getInputStream();
            String encoding = con.getContentEncoding();
            encoding = encoding == null ? "UTF-8" : encoding;

            java.util.Scanner s = new java.util.Scanner(in,encoding).useDelimiter("\\A");
            String body = s.hasNext() ? s.next() : "";

            System.out.println(body);
            return body;
        }catch (IOException ex){
            System.out.println(ex);
            return "ERROR";
        }
    }


    @Override
    public void startController() {
        // Get all teams near the incicent (radius, long and lat are hardcoded right now)
        ArrayOfTeam soapTeams = port.getTeamsNearIncident(token, 60.78600, 45.78000, 10);
        List<Team> teams = soapTeams.getTeam();
        ObservableList<Team> observableTeams = FXCollections.observableArrayList(teams);
        cLVTeams.setItems(observableTeams);

        cLVTeams.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Team>() {
            @Override
            public void changed(ObservableValue<? extends Team> observable, Team oldValue, Team newValue) {
                selectedTeam = newValue;
            }
        });


        // Clear the vboxes
        contentHolderR1.getChildren().clear();
        contentHolderR2.getChildren().clear();
        contentHolderR3.getChildren().clear();

        Thread thread = new Thread(()->postLoadSources());
        thread.start();
    }

    @Override
    public void backToMenu() {
        StageController.loadStage(View.mainScene, "main");
    }

    public void reloadSelectedSources(Event event) {
        ListIterator<IPanel> listIterator = panels.listIterator();
        while (listIterator.hasNext()) {
            IPanel panel = listIterator.next();
            try {
                if (panel.isSelected())
                    selectedSources.getChildren().add(panel.getParentNode());
                else
                    getNextPanel().getChildren().add(panel.getParentNode());

            }catch (IllegalArgumentException ex) {

            }

        }
    }

    /**
     * Method for applying a filter to the media.
     */
    public void changeFilter(){
        contentHolderR1.getChildren().clear();
        contentHolderR2.getChildren().clear();
        contentHolderR3.getChildren().clear();

        for(Media m : mediaObjects.keySet())
        {
            if(m.getDate().toGregorianCalendar().toZonedDateTime().toLocalDate().compareTo(startDate.getValue()) >= 0 &&
                    m.getDate().toGregorianCalendar().toZonedDateTime().toLocalDate().compareTo(endDate.getValue()) <= 0 &&
                    m.getSource().contains(tfTextFilter.getText())) {
                if ((cbAcceptedFilter.isSelected() && m.getAccepted() == MediaAccepted.YES) || !cbAcceptedFilter.isSelected()) {
                    if (m.getMimeType().startsWith("image")) {//its an image!
                        Platform.runLater(() -> addPanel(m.getSource(), (Image)mediaObjects.get(m)));
                    } else {
                        Platform.runLater(() -> addPanel(m.getSource(), (String)mediaObjects.get(m)));
                    }
                }
            }
        }
    }
}
