import SitaApi.Incident;
import javafx.scene.control.ListCell;

/**
 * Created by Mike on 20-4-2016.
 */
public class IncidentCell extends ListCell<Incident> {
    @Override
    protected void updateItem(Incident incident, boolean isblank) {
        super.updateItem(incident, isblank);
        if (incident != null) {
            setText(incident.getId() + " " + incident.getDescription());
        }
        else {
            setText("");
        }
    }
}
