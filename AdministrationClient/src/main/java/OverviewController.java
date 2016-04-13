import Panels.IPanel;
import Panels.PanelFactory;
import SitaApi.Media;
import SitaApi.SitaApiSoap;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.application.Platform;
import javafx.fxml.FXML;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Menu;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import sun.misc.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class OverviewController implements IController{

    // COMMUNICATION WITH TEAM TAB
    @FXML
    private JFXTextField cTFTitel;
    @FXML
    private JFXTextArea cTAInhoud;
    @FXML
    private JFXListView<String> cLVTeams;

    // SOURCES TAB
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private AnchorPane totalContent;
    @FXML private VBox contentHolderR1;
    @FXML private VBox contentHolderR2;
    @FXML private VBox contentHolderR3;

    @FXML private Menu menuBack;
    @FXML private DatePicker endDate;
    @FXML private DatePicker startDate;

    // FIELDS
    private LinkedList<IPanel> panels = new LinkedList<IPanel>();


    private final int SPACING = 10;

    /**
     * Author Frank Hartman
     * Send a message to a selected team
     */
    public void sendMessageToTeam(){
        MessageBox.showException("Niet ondersteund", "Neem contact op met de administrator", "", new UnsupportedOperationException());
    }

    public void initialize(URL location, ResourceBundle resources) {
        // Dummy data
        cLVTeams.getItems().add("Alpha");
        cLVTeams.getItems().add("Beta");
        cLVTeams.getItems().add("Politie 1");
        cLVTeams.getItems().add("Brandweer 4");

        contentHolderR1.setSpacing(SPACING);
        contentHolderR2.setSpacing(SPACING);
        contentHolderR3.setSpacing(SPACING);



    }

    /**
     * Add a panel with a image to the panel
     * @param title the title of the panel
     * @param image the image of the panel
     */
    void addPanel(String title, Image image) {
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
    void addPanel(String title, String text) {
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
    VBox getNextPanel() {
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
                Platform.runLater(()->addPanel(m.getSource(),img));
            }else{
                String result = httpGetString(url);
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
}
