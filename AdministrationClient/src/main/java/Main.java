

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        StageController.setStage(primaryStage);
        StageController.loadStage(View.mainScene, "Administratie");

        MessageBox.showPopUp(Alert.AlertType.INFORMATION, "Welkom", "Deze versie van het centraal administratie systeem is nog in ontwikkeling", "Raging Mashers");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
