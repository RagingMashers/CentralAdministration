import SitaApi.Team;
import javafx.scene.control.ListCell;

/**
 * Created by Mike on 20-4-2016.
 */
public class TeamCell extends ListCell<Team> {
    @Override
    protected void updateItem(Team team, boolean isblank) {
        super.updateItem(team, isblank);
        if (team != null) {
            setText(team.getId() + " " + team.getType());
        }
        else {
            setText("");
        }
    }
}

