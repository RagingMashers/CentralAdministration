import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by frank on 30/03/2016.
 */
public class FilterController implements IController {
    @Override
    public void startController() {

    }

    @Override
    public void backToMenu() {
        StageController.loadStage(View.mainScene, "main");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
