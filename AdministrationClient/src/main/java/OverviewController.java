import Panels.IPanel;
import Panels.PanelFactory;
import SitaApi.*;
import Validation.Validator;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import java.net.URLConnection;
import java.time.LocalDate;

public class OverviewController implements IController{

    // COMMUNICATION WITH TEAM TAB
    @FXML private JFXTextField cTFTitel;
    @FXML private JFXTextArea cTAInhoud;
    @FXML private JFXListView<Team> cLVTeams;
    @FXML private JFXSlider radiusSlider;

    // SOURCES TAB
    @FXML private ScrollPane scrollPane;
    @FXML private AnchorPane totalContent;
    @FXML private VBox contentHolderR1;
    @FXML private VBox contentHolderR2;
    @FXML private VBox contentHolderR3;
    @FXML private VBox selectedSources;

    @FXML private Menu menuBack;
    @FXML private DatePicker endDate;
    @FXML private DatePicker startDate;
    @FXML private TextField tfTextFilter;
    @FXML private CheckBox cbAcceptedFilter;

    // INBOX TAB
    @FXML private JFXListView<Message> lvMessages;
    @FXML private Label lbAfzender;
    @FXML private Label lbTitel;
    @FXML private JFXTextArea taBericht;
    @FXML private ScrollPane scrollPaneInbox;


    // FIELDS
    private final int SPACING = 10;
    private ApiManager manager = ApiManager.getInstance();
    private SitaApiSoap port = manager.getSitaPort();
    private String token = manager.getSitaToken();
    private Team selectedTeam;
    private Map<Media, IPanel> mediaObjects = new HashMap<>();
    private List<IPanel> selectedMedia = new ArrayList<>();
    private ObservableList<Message> observableMessages = FXCollections.observableArrayList();

    public void initialize(URL location, ResourceBundle resources) {
        contentHolderR1.setSpacing(SPACING);
        contentHolderR2.setSpacing(SPACING);
        contentHolderR3.setSpacing(SPACING);

        startDate.setValue(LocalDate.now());
        endDate.setValue(LocalDate.now());
        selectedSources.setSpacing(SPACING);

        Validator validator = new Validator();
        validator.setTextBoxStyles(cTFTitel, "Titel", "Het bericht moet een titel hebben",new RequiredFieldValidator(),false);
        validator.setTextAreaStyles(cTAInhoud, "Inhoud", "Het bericht moet wel inhoud hebben", new RequiredFieldValidator());
    }

    /**
     * Send a message to a selected team.
     * The message can contain 0, 1 or more media objects.
     */
    public void sendMessageToTeam(){
        boolean succes = true;
        if(!cTAInhoud.validate()) succes = false;
        if(!cTFTitel.validate()) succes = false;
        if(!succes) return;

        if(selectedTeam == null) {
            // TODO: this is a hot fix. Create a red label.
            MessageBox.showException("Er is een fout opgetreden!", "Selecteer een team om je bericht naar te versturen.", "", new Exception(""));
            return;
        }

        try{
            if(selectedSources.getChildren().size() > 0){
                ArrayOfInt media = new ArrayOfInt();
                for(IPanel panel : selectedMedia){
                    media.getInt().add(panel.getId());
                    panel.setSelectedValue(false); // Deselect the sources after sending the message.
                }
                port.sendMessageWithMedia(token, selectedTeam.getId(), cTAInhoud.getText(), cTFTitel.getText(), media);
            }
            else{
                port.sendMessage(token, selectedTeam.getId(), cTAInhoud.getText(), cTFTitel.getText());
            }
        }
        catch(Exception e){
            e.printStackTrace();
            MessageBox.showException("Er is een fout opgetreden!", "Raadpleeg een administrator indien de fout zich blijft voordoen.", "", e);
        }
        finally {
            // Clear User interface
            cTFTitel.setText("");
            cTAInhoud.setText("");
            cLVTeams.getSelectionModel().clearSelection();
            selectedTeam = null;
            selectedMedia = new ArrayList<>(); // Empty the list with selected IPanels.
            reloadSelectedSources(); // Reload the selected sources after sending the message.
        }
    }

    /**
     * Add a panel with a image to the panel
     * @param title the title of the panel
     * @param image the image of the panel
     */
    private IPanel addPanel(String title, Image image, int id, XMLGregorianCalendar date) {
        VBox nextBox = getNextPanel();
        IPanel panel = PanelFactory.getPanel(PanelFactory.Type.image, title, image, nextBox, id, date);
        Platform.runLater(() -> {
            assert panel != null;
            nextBox.getChildren().add(panel.getParentNode());
        });
        return panel;
    }

    /**
     * Add a panel with text to the panel
     * @param title the title of the panel
     * @param text the text of the panel
     */
    private IPanel addPanel(String title, String text, int id, XMLGregorianCalendar date) {
        VBox nextBox = getNextPanel();
        IPanel panel = PanelFactory.getPanel(PanelFactory.Type.text, title, text, nextBox, id, date);
        Platform.runLater(() -> {
            assert panel != null;
            nextBox.getChildren().add(panel.getParentNode());
        });
        return panel;
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
                IPanel panel = addPanel(m.getSource(), img, m.getId(), m.getDate());
                mediaObjects.put(m, panel);

            }else{
                String result = httpGetString(url);
                IPanel panel = addPanel(m.getSource(), result, m.getId(), m.getDate());
                mediaObjects.put(m, panel);
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

            return body;
        }catch (IOException ex){
            System.out.println(ex.toString());
            return "ERROR";
        }
    }

    private void getTeams(){
        cLVTeams.getItems().clear();
        // Get the selected incident.
        Incident selectedIncident = IncidentHolder.getIncident();

        // Get all teams near the incicent.
        ArrayOfTeam soapTeams = port.getTeamsNearIncident(token, selectedIncident.getLongitude(), selectedIncident.getLatitude(), (int)radiusSlider.getValue());
        List<Team> teams = soapTeams.getTeam();
        ObservableList<Team> observableTeams = FXCollections.observableArrayList(teams);
        cLVTeams.setItems(observableTeams);
    }

    public void getMessages(){
        lvMessages.getItems().clear();

        // Get the selected incident.
        Incident selectedIncident = IncidentHolder.getIncident();

        // Get all messages that belong to this incident.
        ArrayOfMessage soapMessages = port.getMessagesOfIncident(selectedIncident.getId(), DirectionType.E);
        List<Message> messages = soapMessages.getMessage();
        observableMessages.addAll(0, messages);
    }

    @Override
    public void startController() {
        // COMMUNICATION WITH TEAM TAB
        getTeams();
        cLVTeams.setCellFactory(p -> new TeamCell());
        cLVTeams.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedTeam = newValue;
        });
        radiusSlider.valueChangingProperty().addListener((observable, oldValue, newValue) -> {
            getTeams();
        });
        radiusSlider.setOnMouseClicked(event -> getTeams());

        // INBOX TAB
        lvMessages.setItems(observableMessages);
        lvMessages.setCellFactory(p -> new MessageCell());
        lvMessages.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                lbAfzender.setText(String.valueOf("TEAM ID: " + newValue.getTeam()));
                lbTitel.setText(newValue.getTitle());
                taBericht.setText(newValue.getDescription());
            }
        });
        this.getMessages();

        clearPanelHolders();
        Thread thread = new Thread(this::postLoadSources);
        thread.start();
    }

    @Override
    public void backToMenu() {
        StageController.loadStage(View.mainScene, "main");
    }

    /**
     * Clear all of the vboxes that contains sources
     */
    private void clearPanelHolders() {
        // Clear the vboxes
        Platform.runLater(() -> {
            contentHolderR1.getChildren().clear();
            contentHolderR2.getChildren().clear();
            contentHolderR3.getChildren().clear();
        });
    }

    /**
     * Reload all of the selected resources
     * Called when the user switches tabs
     */
    public void reloadSelectedSources() {

        clearPanelHolders();

        Platform.runLater(() -> {
            for (IPanel panel : mediaObjects.values()) {
                try {
                    if (panel.isSelected()) {
                        if(!selectedMedia.contains(panel)) {
                            selectedMedia.add(panel);
                            selectedSources.getChildren().add(panel.getParentNode());
                        }
                    }
                    else if (!getNextPanel().getChildren().contains(panel))
                        getNextPanel().getChildren().add(panel.getParentNode());

                }catch (IllegalArgumentException ex) {
                    System.out.println(ex.toString());
                }
            }
        });
    }

    /**
     * Method for applying a filter to the media.
     */
    public void changeFilter(){
        clearPanelHolders();

        Platform.runLater(() -> {
            for(Media m : mediaObjects.keySet())
            {
                if(m.getDate().toGregorianCalendar().toZonedDateTime().toLocalDate().compareTo(startDate.getValue()) >= 0 &&
                        m.getDate().toGregorianCalendar().toZonedDateTime().toLocalDate().compareTo(endDate.getValue()) <= 0 &&
                        m.getSource().contains(tfTextFilter.getText())) {
                    if (!cbAcceptedFilter.isSelected() || m.getAccepted() == MediaAccepted.YES) {
                        getNextPanel().getChildren().add(mediaObjects.get(m).getParentNode());
                    }
                }
            }
        });

    }
}

