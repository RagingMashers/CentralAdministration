import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by frank on 30/03/2016.
 */
public class IncidentController implements IController{
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
    @FXML
    private JFXListView<String> mLVGiftigeStoffenTotaal;

    /**
     * Author Frank Hartman
     * Create a incident
     */
    public void createIncident(){

        String titel = mTFTitle.getText();
        ArrayList<String> toxics = new ArrayList<String>();
        toxics.addAll(mLVGiftigeStoffenTotaal.getItems());

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupGiftigeStoffenSelection();
    }

    /**
     * Author Frank Hartman
     * Setup the controls of the listview that are holding the toxics
     */
    private void setupGiftigeStoffenSelection() {
        mLVGiftigeStoffen.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> ov,
                                        String oldValue, String newValue) {
                        if(!mLVGiftigeStoffenTotaal.getItems().contains(newValue)) {
                            mLVGiftigeStoffenTotaal.getItems().add(newValue);
                        }
                    }
                });
        mLVGiftigeStoffenTotaal.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, final String newValue) {

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        mLVGiftigeStoffenTotaal.getSelectionModel().clearSelection();
                        mLVGiftigeStoffenTotaal.getItems().remove(newValue);
                    }
                });

            }
        });
    }

    @Override
    public void startController() {
        if (IncidentHolder.getIncident().equals(null))
            MessageBox.showPopUp(Alert.AlertType.INFORMATION, "Incident aanmaken", "Je gaat nu een incident aanmaken", "");
        else {
            MessageBox.showPopUp(Alert.AlertType.INFORMATION, "Incident wijzigen", "Je gaat nu een incident wijzigen", "");
        }
    }

    @Override
    public void backToMenu() {
        StageController.loadStage(View.mainScene, "main");
    }
}
