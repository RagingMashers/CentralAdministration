import SitaApi.Incident;
import Validation.Validator;
import Validation.Validators.IntegerValidator;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import com.jfoenix.validation.base.ValidatorBase;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
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
    private JFXTextField mTFSlachtoffers,mTFTitle,mTFRadius,mTFCoordinaatY,mTFCoordinaatX,mTFGewonden;
    @FXML
    private JFXSlider mSGevaarNiveau;
    @FXML
    private JFXListView<String> mLVGiftigeStoffen,mLVGiftigeStoffenTotaal,mLVBeschikbareTeams,mLVGeselecteerdeTeams;
    @FXML
    private JFXButton btnIncident;


    /**
     * Author Frank Hartman & Matthijs van der Boon
     * Create an incident
     */
    public void createIncident(){
        if (IncidentHolder.getIncident().equals(""))
        {
            MessageBox.showPopUp(Alert.AlertType.INFORMATION, "Incident aanmaken voltooid", "Het incident is aangemaakt", "");
            //Should add some code that calls the method that adds the incident data.
        }
        else {
            MessageBox.showPopUp(Alert.AlertType.INFORMATION, "Incident wijzigen voltooid", "Het incident is gewijzigd", "");
            //Should add some code that calls the method that changes the incident data.
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addValidatorsToControls();
        setupListClickEvents();
        mLVGiftigeStoffen.getItems().add("dodelijke stof");
        mLVGiftigeStoffen.getItems().add("minder dodelijke stof");
        mLVGiftigeStoffen.getItems().add("lucht");
        mLVBeschikbareTeams.getItems().add("Team 1");
        mLVBeschikbareTeams.getItems().add("Team 2");
        mLVBeschikbareTeams.getItems().add("Team 3");
    }

    /**
     * Author Frank Hartman
     * Setup the controls of the listview that are holding the toxics
     */
    private void setupListClickEvents() {
        addListenerToList(mLVGiftigeStoffen,mLVGiftigeStoffenTotaal);
        addListenerToList(mLVBeschikbareTeams,mLVGeselecteerdeTeams);
    }

    private void addValidatorsToControls(){
        setTextBoxStyles(mTFTitle,"Titel", "Dit veld mag niet leeg zijn",new RequiredFieldValidator());
        setTextBoxStyles(mTFSlachtoffers,"Hoeveelheid slachtoffers", "Dit moet een getal zijn",new IntegerValidator());
        setTextBoxStyles(mTFGewonden,"Hoeveelheid gewonden", "Dit moet een getal zijn",new IntegerValidator());
        setTextBoxStyles(mTFCoordinaatX,"X Coördinaat", "Dit moet een getal zijn",new RequiredFieldValidator());
        setTextBoxStyles(mTFCoordinaatY,"Y Coördinaat", "Dit moet een getal zijn",new RequiredFieldValidator());
        setTextBoxStyles(mTFRadius, "Radius", "Dit moet een getal zijn",new IntegerValidator());
    }

    private void setTextBoxStyles(JFXTextField jfxTextField, String fieldName, String errorText, ValidatorBase validatorBase){
        Validator validator = new Validator();
        jfxTextField.setStyle("-fx-label-float:true;");
        jfxTextField.setPromptText(fieldName);
        jfxTextField.getValidators().add(validator.validatorForTextbox(errorText,validatorBase));
        jfxTextField.focusedProperty().addListener((o,oldVal,newVal)->{
            if(!newVal)jfxTextField.validate();
        });
    }

    public void btnIncident_Click(ActionEvent actionEvent) {
        if(mTFTitle.validate()&& mTFGewonden.validate()&& mTFSlachtoffers.validate()&&
        mTFCoordinaatX.validate()&& mTFCoordinaatY.validate()&& mTFRadius.validate())
            createIncident();
    }

    private void addListenerToList(JFXListView<String> listFrom, JFXListView<String> listTo){
        listFrom.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> ov,
                                        String oldValue, String newValue) {
                        if(!listTo.getItems().contains(newValue)) {
                            listTo.getItems().add(newValue);
                        }
                    }
                });
        listTo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, final String newValue) {

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        listTo.getSelectionModel().clearSelection();
                        listTo.getItems().remove(newValue);
                    }
                });

            }
        });
    }

    @Override
    public void startController() {
        if (IncidentHolder.getIncident().equals("")) {
            MessageBox.showPopUp(Alert.AlertType.INFORMATION, "Incident aanmaken", "Je gaat nu een incident aanmaken", "");
            btnIncident.setText("Meld incident");
        }
        else {
            MessageBox.showPopUp(Alert.AlertType.INFORMATION, "Incident wijzigen", "Je gaat nu een incident wijzigen", "");
            btnIncident.setText("Wijzig incident");
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
    private void fillInputFields(Incident incident){
        //Needs to be updated to pass the actual values.
        mTFTitle.setText(incident.getDescription());
        mTFSlachtoffers.setText("10");
        mTFCoordinaatX.setText("20");
        mTFCoordinaatY.setText("16");
        mSGevaarNiveau.setValue(5);
        mTFRadius.setText("105");

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
