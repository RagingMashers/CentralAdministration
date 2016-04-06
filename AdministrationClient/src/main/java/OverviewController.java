import Panels.IPanel;
import Panels.PanelFactory;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.Random;
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

    @FXML private Menu menuBack;

    // FIELDS


    private int spacing = 10;

    /**
     * Author Frank Hartman
     * Send a message to a selected team
     */
    public void sendMessageToTeam(){
        MessageBox.showException("Niet ondersteund", "Neem contact op met de administrator", "", new UnsupportedOperationException());
    }

    public void initialize(URL location, ResourceBundle resources) {
        cLVTeams.getItems().add("Alpha");
        cLVTeams.getItems().add("Beta");
        cLVTeams.getItems().add("Politie 1");
        cLVTeams.getItems().add("Brandweer 4");

        // Setting the panel settings
        contentHolderR1.setPrefHeight(totalContent.getPrefHeight());
        contentHolderR2.setPrefHeight(totalContent.getPrefHeight());
        contentHolderR3.setPrefHeight(totalContent.getPrefHeight());

        contentHolderR1.setSpacing(spacing);
        contentHolderR2.setSpacing(spacing);
        contentHolderR3.setSpacing(spacing);

        Image image = new Image(String.valueOf(getClass().getClassLoader().getResource("muppets.jpg")));

        // Dummy data for the panels
        AddPanel("Label 1", image);
        AddPanel("Label 2", image);
        AddPanel("Label 3", image);
        AddPanel("Label 1", image);
        AddPanel("Label 2", image);
        AddPanel("Label 3", image);
        AddPanel("Label 1", image);
        AddPanel("Label 2", image);
        AddPanel("Label 3", image);




    }

    void AddPanel(String title, Image image) {
        int row1Count = contentHolderR1.getChildren().toArray().length;
        VBox selectedVBox;
        if (contentHolderR2.getChildren().toArray().length < row1Count)
            selectedVBox = contentHolderR2;
        else if (contentHolderR3.getChildren().toArray().length < row1Count)
            selectedVBox = contentHolderR3;
        else
            selectedVBox = contentHolderR1;

        IPanel panel = PanelFactory.getPanel(PanelFactory.Type.image, title, image, selectedVBox);
        selectedVBox.getChildren().add(panel.getParentNode());
    }


    @Override
    public void startController() {
        System.out.println(scrollPane.getHmax());
        System.out.println(scrollPane.getHeight());
        System.out.println(scrollPane.getMaxHeight());
        System.out.println(scrollPane.getPrefHeight());
    }

    @Override
    public void backToMenu() {
        StageController.loadStage(View.mainScene, "main");
    }
}
