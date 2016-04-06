import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements IController{
    @FXML
    JFXButton btnWijzigen;
    @FXML
    JFXButton btnBeheersen;
    @FXML
    JFXListView<String> lvIncidenten;

    public void loadOverview() {
        IncidentHolder.setIncident(lvIncidenten.getSelectionModel().getSelectedItem());
        StageController.loadStage(View.overviewScene, IncidentHolder.getIncident());
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

        lvIncidenten.getItems().add("Bosbrand in Arnhem");
        lvIncidenten.getItems().add("Giftige gassen in Eindhoven");


    }

    @Override
    public void startController() {

    }

    @Override
    public void backToMenu() {

    }
}
