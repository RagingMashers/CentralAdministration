import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;

import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
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


    // FIELDS




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
    }


    @Override
    public void startController() {

    }
}
