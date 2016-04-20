import SitaApi.Incident;
import SitaApi.SitaApi;
import SitaApi.Toxication;
import SitaApi.Incident;
import SitaApi.Toxication;
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
import javafx.scene.control.ListCell;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import SitaApi.SitaApiSoap;

/**
 * Created by frank on 30/03/2016.
 */
public class IncidentController implements IController{
    private SitaApiSoap sitaApi;
    private String sitaToken;

    // MELDING TAB
    @FXML
    private JFXTextField mTFSlachtoffers,mTFTitle,mTFRadius,mTFCoordinaatY,mTFCoordinaatX,mTFGewonden;
    @FXML
    private JFXSlider mSGevaarNiveau;
    @FXML
    private JFXListView<String> mLVBeschikbareTeams,mLVGeselecteerdeTeams;
    @FXML
    private JFXListView<Toxication> mLVGiftigeStoffen,mLVGiftigeStoffenTotaal;
    @FXML
    private JFXButton btnIncident;

    /**
     * Author Frank Hartman & Matthijs van der Boon
     * Create an incident
     */
    public void createIncident(){
        if (IncidentHolder.getIncident().equals(""))
        {
            if(!isInputValid()){
                MessageBox.showPopUp(Alert.AlertType.ERROR,"Kan incident niet aanmaken","Er zijn nog incorrect ingevulde velden", "");
                return;
            }
            if(!sitaApi.addIncident(sitaToken,Integer.valueOf(mTFSlachtoffers.getText()),Integer.valueOf(mTFGewonden.getText()),Double.valueOf(mTFCoordinaatX.getText()),Double.valueOf(mTFCoordinaatY.getText()),(int)mSGevaarNiveau.getValue(),Integer.valueOf(mTFRadius.getText()),mTFTitle.getText())){
                MessageBox.showPopUp(Alert.AlertType.ERROR,"Kan incident niet aanmaken","Er is iets mis gegaan met het aanmaken", "");
                return;//todo get stronger error description
            }
            //todo add teams and toxications

            MessageBox.showPopUp(Alert.AlertType.INFORMATION, "Incident aanmaken voltooid", "Het incident is aangemaakt", "");
            //Should add some code that calls the method that adds the incident data.
        }
        else {
            int id = IncidentHolder.getIncident().getId();
            if(!isInputValid()){
                MessageBox.showPopUp(Alert.AlertType.ERROR,"Kan incident niet aanmaken","Er zijn nog incorrect ingevulde velden", "");
                return;
            }
            if(!sitaApi.editIncident(sitaToken,id,Integer.valueOf(mTFSlachtoffers.getText()),Integer.valueOf(mTFGewonden.getText()),Double.valueOf(mTFCoordinaatX.getText()),Double.valueOf(mTFCoordinaatY.getText()),Integer.valueOf(mTFRadius.getText()),(int)mSGevaarNiveau.getValue(),mTFTitle.getText())){
                MessageBox.showPopUp(Alert.AlertType.ERROR,"Kan incident niet aanmaken","Er is iets mis gegaan met het aanmaken", "");
                return;//todo get stronger error description
            }
            //todo add teams and toxications
            MessageBox.showPopUp(Alert.AlertType.INFORMATION, "Incident wijzigen voltooid", "Het incident is gewijzigd", "");
            //Should add some code that calls the method that changes the incident data.
        }
    }

    private boolean isInputValid(){
        return mTFSlachtoffers.validate() && mTFTitle.validate() && mTFRadius.validate() && mTFCoordinaatX.validate() && mTFCoordinaatY.validate() && mTFGewonden.validate();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sitaApi = ApiManager.getInstance().getSitaPort();
        sitaToken = ApiManager.getInstance().getSitaToken();
        addValidatorsToControls();
        setupListClickEvents();

        List<Toxication> toxications = sitaApi.getToxications(sitaToken).getToxication();

        mLVGiftigeStoffen.setCellFactory(p -> new ToxicationCell());
        mLVGiftigeStoffenTotaal.setCellFactory(p -> new ToxicationCell());

        mLVGiftigeStoffen.getItems().addAll(toxications);

        //mLVGiftigeStoffen.getItems().add("dodelijke stof");
        //mLVGiftigeStoffen.getItems().add("minder dodelijke stof");
        //mLVGiftigeStoffen.getItems().add("lucht");
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

    private <T> void addListenerToList(JFXListView<T> listFrom, JFXListView<T> listTo){
        listFrom.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<T>() {
                    @Override
                    public void changed(ObservableValue<? extends T> ov,
                                        T oldValue, T newValue) {
                        if(!listTo.getItems().contains(newValue)) {
                            listTo.getItems().add(newValue);
                        }
                    }
                });
        listTo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<T>() {
            @Override
            public void changed(ObservableValue<? extends T> observable, T oldValue, final T newValue) {

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
        if (IncidentHolder.getIncident() == null || IncidentHolder.getIncident().equals("")) {
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
        mTFTitle.setText(incident.getDescription());
        mTFSlachtoffers.setText("" + incident.getAmountVictims());
        mTFCoordinaatX.setText("" + incident.getLongitude());
        mTFCoordinaatY.setText("" + incident.getLatitude());
        mSGevaarNiveau.setValue(incident.getDangerlevel());
        mTFRadius.setText("" + incident.getRadius());

        for(Toxication toxic : incident.getToxicElements().getToxication()){
            if(!mLVGiftigeStoffen.getItems().contains(toxic)) {
                mLVGiftigeStoffen.getItems().add(toxic);
            }
        }

        for(Toxication toxic : sitaApi.getToxications("").getToxication()){
            if(!mLVGiftigeStoffen.getItems().contains(toxic)) {
                mLVGiftigeStoffenTotaal.getItems().add(toxic);
            }
        }
    }
}
