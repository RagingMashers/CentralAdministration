import Panels.IPanel;
import Panels.PanelFactory;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.Event;
import javafx.fxml.FXML;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Menu;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.Date;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.ResourceBundle;

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
    @FXML private VBox selectedSources;

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
        selectedSources.setSpacing(SPACING);



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
        // Clear the vboxes
        contentHolderR1.getChildren().clear();
        contentHolderR2.getChildren().clear();
        contentHolderR3.getChildren().clear();

        // Clear list with panels
        panels.clear();

        // Load dummy images
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
}
