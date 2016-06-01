

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        StageController.setStage(primaryStage);
        StageController.loadStage(View.mainScene, "Administratie");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
