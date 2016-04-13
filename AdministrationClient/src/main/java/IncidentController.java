import Validation.Validator;
import Validation.Validators.IntegerValidator;
import Validation.Validators.RequiredIntegerValidator;
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
    private JFXButton btnIncident,btnAddToxin,btnRemoveToxin,btnAddTeam,btnRemoveTeam;


    /**
     * Author Frank Hartman & Matthijs van der Boon
     * Create an incident
     */
    public void createIncident(){
        MessageBox.showPopUp(Alert.AlertType.INFORMATION, "Incident aanmaken voltooid", "Het incident is aangemaakt", "");
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

    @Override
    public void startController() {
        if (IncidentHolder.getIncident().equals(null))
            MessageBox.showPopUp(Alert.AlertType.INFORMATION, "Incident aanmaken", "Je gaat nu een incident aanmaken", "");
        else {
            MessageBox.showPopUp(Alert.AlertType.INFORMATION, "Incident wijzigen", "Je gaat nu een incident wijzigen", "");
        }
    }

    private void addValidatorsToControls(){
        setTextBoxStyles(mTFTitle,"Titel", "Dit veld mag niet leeg zijn",new RequiredFieldValidator());
        setTextBoxStyles(mTFSlachtoffers,"Hoeveelheid slachtoffers", "Dit moet een getal zijn",new IntegerValidator());
        setTextBoxStyles(mTFGewonden,"Hoeveelheid gewonden", "Dit moet een getal zijn",new IntegerValidator());
        setTextBoxStyles(mTFCoordinaatX,"X Coördinaat", "Dit moet een getal zijn",new RequiredIntegerValidator());
        setTextBoxStyles(mTFCoordinaatY,"Y Coördinaat", "Dit moet een getal zijn",new RequiredIntegerValidator());
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

    public void btnAddToxin_Click(ActionEvent actionEvent){
        System.out.println("btnAddToxin_Click");
    }

    public void btnRemoveToxin_Click(ActionEvent actionEvent){
        System.out.println("btnRemoveToxin_Click");
    }

    public void btnAddTeam_Click(ActionEvent actionEvent){
        System.out.println("btnAddTeam_Click");
    }

    public void btnRemoveTeam_Click(ActionEvent actionEvent){
        System.out.println("btnRemoveTeam_Click");
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
}
