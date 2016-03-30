import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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

        contentHolderR1.setPrefHeight(totalContent.getPrefHeight());
        contentHolderR2.setPrefHeight(totalContent.getPrefHeight());
        contentHolderR3.setPrefHeight(totalContent.getPrefHeight());

        contentHolderR1.setSpacing(spacing);
        contentHolderR2.setSpacing(spacing);
        contentHolderR3.setSpacing(spacing);



        AddPanel("Label 1");
        AddPanel("Label 2");
        AddPanel("Label 3");
        AddPanel("Label 4");
        AddPanel("Label 5");
        AddPanel("Label 6");
        AddPanel("Label 7");
        AddPanel("Label 8");
        AddPanel("Label 9");
        AddPanel("Label 10");
        AddPanel("Label 11");
        AddPanel("Label 12");


    }

    void AddPanel(String title) {
        int row1Count = contentHolderR1.getChildren().toArray().length;
        VBox selectedVBox;
        if (contentHolderR2.getChildren().toArray().length < row1Count)
            selectedVBox = contentHolderR2;
        else if (contentHolderR3.getChildren().toArray().length < row1Count)
            selectedVBox = contentHolderR3;
        else
            selectedVBox = contentHolderR1;


        Pane pane = new Pane();
        pane.setPrefWidth(scrollPane.getWidth());
        Random random = new Random();
        pane.setPrefHeight(random.nextInt(300));

        pane.setStyle("-fx-background-color: coral");

        pane.getChildren().add(new Label(title));
        selectedVBox.getChildren().add(pane);
    }


    @Override
    public void startController() {
        System.out.println(scrollPane.getHmax());
        System.out.println(scrollPane.getHeight());
        System.out.println(scrollPane.getMaxHeight());
        System.out.println(scrollPane.getPrefHeight());
    }
}
