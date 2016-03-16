import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class OverviewController implements Initializable {
    // Creating incident
    @FXML
    private JFXTextField mTFSlachtoffers;
    @FXML
    private JFXTextField mTFTitle;
    @FXML
    private JFXTextField mTFRadius;
    @FXML
    private JFXSlider mSGevaarNiveau;
    @FXML
    private JFXTextField mTFCoordinaatY;
    @FXML
    private JFXTextField mTFCoordinaatX;
    @FXML
    private JFXListView mLVGiftigeStoffen;


    // Communicate with team
    @FXML
    private JFXTextField cTFTitel;
    @FXML
    private JFXTextArea cTAInhoud;
    @FXML
    private JFXListView cLVTeams;

    // Sources

    public void createIncident() {
        StageController.showException("Niet ondersteund", "Neem contact op met de administrator", "", new UnsupportedOperationException());
    }

    public void sendMessageToTeam(){
        StageController.showException("Niet ondersteund", "Neem contact op met de administrator", "", new UnsupportedOperationException());
    }

    public void initialize(URL location, ResourceBundle resources) {
        // Dummy data for the listview
        mLVGiftigeStoffen.getItems().add("Aluminum");
        mLVGiftigeStoffen.getItems().add("Chronium");
        mLVGiftigeStoffen.getItems().add("CO2");
        mLVGiftigeStoffen.getItems().add("Benzene");
        mLVGiftigeStoffen.getItems().add("DDT");
        mLVGiftigeStoffen.getItems().add("DDE");

        cLVTeams.getItems().add("Alpha");
        cLVTeams.getItems().add("Beta");
        cLVTeams.getItems().add("Politie 1");
        cLVTeams.getItems().add("Brandweer 4");


    }
}
