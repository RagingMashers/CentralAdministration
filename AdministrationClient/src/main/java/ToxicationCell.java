import SitaApi.Toxication;
import javafx.scene.control.ListCell;

/**
 * Created by Rick on 20-4-2016.
 */
public class ToxicationCell extends ListCell<Toxication> {

    @Override
    protected void updateItem(Toxication item, boolean empty) {
        super.updateItem(item, empty);
        if(empty || item == null){
            return;
        }
        setText(item.getName());
    }
}
