import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javassist.bytecode.stackmap.TypeData;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by frank on 16/03/2016.
 * All of the views that are available for loading
 */

enum View{mainScene, overviewScene, incident, filter}


public class StageController {
    private static final Logger log = Logger.getLogger(TypeData.ClassName.class.getName());
    private static StageController singleton = new StageController();
    private static Scene main;
    private static Scene overview;
    private static Scene incident;
    private static Scene filter;

    private static MainController mainController;
    private static OverviewController overviewController;
    private static IncidentController incidentController;
    private static FilterController filterController;
    private static Stage primaryStage;


    /**
     * Author Frank Hartman
     * The stagecontroller can be used to switch between stages
     */
    private StageController() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Main.fxml"));
            // Load main
            main = new Scene((Parent)fxmlLoader.load());
            mainController = fxmlLoader.getController();

            // Load overview
            fxmlLoader = new FXMLLoader(getClass().getResource("Overview.fxml"));
            overview = new Scene((Parent)fxmlLoader.load());
            overviewController = fxmlLoader.getController();

            // Load incident
            fxmlLoader = new FXMLLoader(getClass().getResource("Incident.fxml"));
            incident = new Scene((Parent)fxmlLoader.load());
            incidentController = fxmlLoader.getController();

            // Load filter
            fxmlLoader = new FXMLLoader(getClass().getResource("Filter.fxml"));
            filter = new Scene((Parent)fxmlLoader.load());
            filterController = fxmlLoader.getController();

            log.log(Level.INFO, "Loaded all of the FXML files into the StageController");

        }

        catch (IOException e) {
            log.log(Level.WARNING, e.toString());
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
     * @param stage the stage that will be set to the primary stage
     */
    public static void setStage(Stage stage) {
        primaryStage = stage;
        log.log(Level.INFO, "The primary stage has been set to: {0}", stage);
    }


    /**
     * Author Frank Hartman
     * Load a new stage
     * @param view the view that the stage should be getting
     * @param title The title of the stage
     */
    public static void loadStage(View view, String title) {
        Scene root = null;

        if (primaryStage == null)
            throw new NullPointerException();

        // Decide which view should be loaded
        switch (view) {
            case mainScene:
                root = main;
                mainController.startController();
                break;
            case overviewScene:
                root = overview;
                overviewController.startController();
                break;
            case incident:
                root = incident;
                incidentController.startController();
                break;
            case filter:
                root = filter;
                filterController.startController();
            default:
                break;
        }

        if (root == null) {
            log.log(Level.WARNING, "The View was not recognised");
        }

        // Change the stage settings
        primaryStage.setTitle(title);
        primaryStage.setScene(root);
        primaryStage.setResizable(false);
        primaryStage.show();

        log.log(Level.INFO, "Done loading: {0}", view);
    }



}
