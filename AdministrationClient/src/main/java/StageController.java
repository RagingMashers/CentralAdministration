import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

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

    /**
     * Show a popup of the screen for the user
     * @param alertType The type of the pop up
     * @param title The title of the pop up
     * @param headerText The header of the pop up
     * @param contentText The content of the pop up
     */
    public static void showPopUp(Alert.AlertType alertType, String title, String headerText, String contentText) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);

        alert.showAndWait();
    }

    /**
     * Show a exception in a pop up
     * @param title The title of the exception
     * @param headerText The header text of the exception
     * @param contentText The contect of the exception
     * @param ex The exception itself
     */
    public static void showException(String title, String headerText, String contentText, Exception ex) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);


        // Create expandable Exception.
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String exceptionText = sw.toString();

        Label label = new Label("The exception stacktrace was:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        // Set expandable Exception into the dialog pane.
        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
    }
}
