import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by frank on 16/03/2016.
 *
 */

enum View{mainScene, overviewScene};


public class StageController {
    private static StageController singleton = new StageController();
    private static Parent main;
    private static Parent overview;
    private static Stage primaryStage;


    /**
     * Author Frank Hartman
     * The stagecontroller can be used to switch between stages
     */
    private StageController() {
        try {
            // Loading all of the fxml files
            main = FXMLLoader.load(getClass().getResource("Main.fxml"));
            overview = FXMLLoader.load(getClass().getResource("Overview.fxml"));
        }

        catch (IOException e) {
            System.out.println(e);
        }

    }

    /**
     * Author Frank Hartman
     * Get the instance of this class
     * @return the singleton of this class
     */
    public static StageController getInstance() {
        return singleton;
    }

    /**
     * Author Frank Hartman
     * Set the primary stage that will be used to load the views
     * @param stage
     */
    public static void setStage(Stage stage) {
        primaryStage = stage;
    }


    /**
     * Author Frank Hartman
     * Load a new stage
     * @param view the view that the stage should be getting
     * @param title The title of the stage
     */
    public static void loadStage(View view, String title) {
        Parent root = null;

        if (primaryStage == null)
            throw new NullPointerException();

        // Decide which view should be loaded
        switch (view) {
            case mainScene:
                root = main;
                break;
            case overviewScene:
                root = overview;
                break;

            default:
                break;
        }

        if (root == null)
            throw new NullPointerException();


        // Change the stage settings
        primaryStage.setTitle(title);
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
