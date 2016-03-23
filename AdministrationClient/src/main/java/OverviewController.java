import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;

import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OverviewController implements Initializable {

    // MELDING TAB
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
    private JFXListView<String> mLVGiftigeStoffen;


    // COMMUNICATION WITH TEAM TAB
    @FXML
    private JFXTextField cTFTitel;
    @FXML
    private JFXTextArea cTAInhoud;
    @FXML
    private JFXListView<String> cLVTeams;

    // SOURCES TAB



    // FIELDS
    private ArrayList<String> selectedLogsList = new ArrayList<String>();

    /**
     * Author Frank Hartman
     * Create a incident
     */
    public void createIncident() {

        String titel = mTFTitle.getText();
        int x, y, gevaar, radius, slachtoffers;

        if (titel.length() <= 3) {
            MessageBox.showPopUp(Alert.AlertType.ERROR, "Te weinig karakters", "Het aantal karakters van de titel moet meer dan 3 zijn", "");
            return;
        }


        try {
            slachtoffers = Integer.parseInt(mTFSlachtoffers.getText());
        }
        catch (Exception e) {
            MessageBox.showPopUp(Alert.AlertType.ERROR, "Verkeerd formaat", "Het aantal slachtoffers moet in cijfers beschreven worden", "");
            return;
        }

        try {
            x = Integer.parseInt(mTFCoordinaatX.getText());
            y = Integer.parseInt(mTFCoordinaatY.getText());
        }

        catch (Exception e) {
            MessageBox.showPopUp(Alert.AlertType.ERROR, "Verkeerd formaat", "Coordinaten moeten in cijfers beschreven worden", "");
            return;
        }
        gevaar = (int)mSGevaarNiveau.getValue();

        try {
            radius = Integer.parseInt(mTFRadius.getText());
        }

        catch (Exception e) {
            MessageBox.showPopUp(Alert.AlertType.ERROR, "Verkeerd formaat", "Radius moet in cijfers beschreven worden", "");
            return;
        }

        MessageBox.showPopUp(Alert.AlertType.INFORMATION, "Incident aanmaken voltooid", "Het incident is aangemaakt", "");

    }

    /**
     * Author Frank Hartman
     * Send a message to a selected team
     */
    public void sendMessageToTeam(){
        MessageBox.showException("Niet ondersteund", "Neem contact op met de administrator", "", new UnsupportedOperationException());
    }

    public void initialize(URL location, ResourceBundle resources) {
        // Dummy data for the listviews
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


        mLVGiftigeStoffen.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> ov,
                                        String old_val, String new_val) {

                        if(selectedLogsList.contains(new_val)) {
                            selectedLogsList.remove(new_val);
                        } else {
                            selectedLogsList.add(new_val);
                        }

                        System.out.println(selectedLogsList);
                    }
                });



    }
}
