import SitaApi.Incident;
import SitaApi.Message;
import javafx.scene.control.ListCell;

/**
 * Created by Mike er on 8-6-2016.
 */
public class MessageCell extends ListCell<Message> {
    @Override
    protected void updateItem(Message message, boolean isblank) {
        super.updateItem(message, isblank);
        if (message != null) {
            setText(message.getTitle());
        }
        else {
            setText("");
        }
    }
}
