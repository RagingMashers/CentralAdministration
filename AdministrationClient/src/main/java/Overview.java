

import javafx.application.Application;
import javafx.stage.Stage;

public class Overview extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        StageController.getInstance().loadStage(View.mainScene, "Overview");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
