import SitaApi.Incident;
import SitaApi.SitaApiSoap;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements IController{
    @FXML
    JFXButton btnWijzigen;
    @FXML
    JFXButton btnBeheersen;
    @FXML
    JFXListView<Incident> lvIncidenten;

    public void loadOverview() {
        IncidentHolder.setIncident(lvIncidenten.getSelectionModel().getSelectedItem());
        StageController.loadStage(View.overviewScene, IncidentHolder.getIncident().getDescription());
    }

    public void loadIncidentWijzigen() {
        IncidentHolder.setIncident(lvIncidenten.getSelectionModel().getSelectedItem());
        StageController.loadStage(View.incident, "Incident wijzigen");
    }

    public void loadIncidentAanmaken() {
        IncidentHolder.clearIncident();
        StageController.loadStage(View.incident, "Incident aanmaken");
    }

    public void loadFilter() {
        StageController.loadStage(View.filter, "Bronnen filteren");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        lvIncidenten.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                boolean visible = newValue.equals("");
                System.out.println(visible);
                btnWijzigen.setDisable(visible);
                btnBeheersen.setDisable(visible);
            }
        });


    }

    @Override
    public void startController() {
        loadIncidents();
    }

    private void loadIncidents() {
        lvIncidenten.getItems().clear();

        SitaApiSoap siteApi = ApiManager.getInstance().getSitaPort();
        String siteToken = ApiManager.getInstance().getSitaToken();

        final List<Incident> incident = siteApi.getIncidents(siteToken, 0, 10).getIncident();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                lvIncidenten.getItems().setAll(incident);
            }
        });
    }

    @Override
    public void backToMenu() {

    }
}
