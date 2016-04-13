import Panels.IPanel;
import Panels.PanelFactory;
import SitaApi.ArrayOfTeam;
import SitaApi.SitaApiSoap;
import SitaApi.Team;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Menu;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
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

    @FXML private Menu menuBack;
    @FXML private DatePicker endDate;
    @FXML private DatePicker startDate;

    // FIELDS
    private LinkedList<IPanel> panels = new LinkedList<IPanel>();
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

        Image image = new Image(String.valueOf(getClass().getClassLoader().getResource("Images/muppets.jpg")));
        Image image2 = new Image(String.valueOf(getClass().getClassLoader().getResource("Images/bosbrand.jpg")));
        Image image3 = new Image(String.valueOf(getClass().getClassLoader().getResource("Images/bosbrand2.jpg")));
        Image image4 = new Image(String.valueOf(getClass().getClassLoader().getResource("Images/gijzeling.jpg")));
        Image image5 = new Image(String.valueOf(getClass().getClassLoader().getResource("Images/gijzeling2.jpg")));
        Image image6 = new Image(String.valueOf(getClass().getClassLoader().getResource("Images/gijzeling3.jpg")));
        Image image7 = new Image(String.valueOf(getClass().getClassLoader().getResource("Images/belgium.jpg")));

        // Dummy data for the panels
        addPanel("Muppets nemen eindhoven over", image);
        addPanel("bosbrand", image2);
        addPanel("Bosbrand", image3);
        addPanel("Suspendisse", "Suspendisse faucibus sem eget ligula fringilla, et malesuada leo ornare.");
        addPanel("Gijzeling", image4);
        addPanel("Gijzeling", image5);
        addPanel("gijzeling", image6);
        addPanel("Belgium", image7);
        addPanel("Label 1", "Donec laoreet et nisl volutpat fermentum. Maecenas convallis lectus sit amet felis feugiat dignissim. Phasellus vulputate, neque in cursus sollicitudin, lorem mauris condimentum turpis, sit amet viverra lacus dolor in neque. Phasellus laoreet venenatis neque, in pulvinar nisi rhoncus nec. Nam congue cursus libero. ");


        loadPanels();
    }

    @Override
    public void backToMenu() {
        StageController.loadStage(View.mainScene, "main");
    }
}
