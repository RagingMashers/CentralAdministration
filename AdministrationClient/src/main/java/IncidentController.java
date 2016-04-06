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


        if (IncidentHolder.getIncident().equals(""))
            MessageBox.showPopUp(Alert.AlertType.INFORMATION, "Incident aanmaken voltooid", "Het incident is aangemaakt", "");
            //Should add some code that calls the method that adds the incident data.
        else {
            MessageBox.showPopUp(Alert.AlertType.INFORMATION, "Incident wijzigen voltooid", "Het incident is gewijzigd", "");
            //Should add some code that calls the method that changes the incident data.
        }


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
        if (IncidentHolder.getIncident().equals(""))
            MessageBox.showPopUp(Alert.AlertType.INFORMATION, "Incident aanmaken", "Je gaat nu een incident aanmaken", "");
        else {
            MessageBox.showPopUp(Alert.AlertType.INFORMATION, "Incident wijzigen", "Je gaat nu een incident wijzigen", "");
            fillInputFields(IncidentHolder.getIncident());
        }
    }

    @Override
    public void backToMenu() {
        StageController.loadStage(View.mainScene, "main");
    }

    /**
     * Method for filling in the fields of an incident.
     * This will give the user feedback about the current status of the incident.
     * @param incident The values of this incident will be displayed.
     */
    private void fillInputFields(String incident){
        //Needs to be updated to pass the actual values.
        mTFTitle.setText(incident);
        mTFSlachtoffers.setText("10");
        mTFCoordinaatX.setText("20");
        mTFCoordinaatY.setText("16");
        mSGevaarNiveau.setValue(5);
        mTFRadius.setText("10500");

//        mTFTitle.setText(incident.description);
//        mTFSlachtoffers.setText(incident.victims;
//        mTFCoordinaatX.setText(incident.longitude);
//        mTFCoordinaatX.setText(incident.latitude);
//        mSGevaarNiveau.setValue(incident.dangerLevel);
//        mTFRadius.setText(incident.radius);

//        for(Toxication toxic : incident.getToxications){
//            if(!mLVGiftigeStoffen.getItems().contains(toxic)) {
//                mLVGiftigeStoffen.getItems().add(toxic);
//            }
//        }

//        for(Toxication toxic : allToxications){
//            if(!mLVGiftigeStoffen.getItems().contains(toxic) && mLVGiftigeStoffenTotaal) {
//                mLVGiftigeStoffenTotaal.getItems().add(toxic);
//            }
//        }
    }
}
