import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * Created by frank on 18/05/2016.
 */
public class TaskPane extends Pane {

    private final int tasksHeight = 40;
    private final JFXComboBox comboBox = new JFXComboBox();

    public TaskPane(StappenPlanController controller){
        // Create the buttons
        Button plus = createButton(450, tasksHeight, 30, "+");
        Button min = createButton(490, tasksHeight, 30, "-");

        TaskPane task = this;
        plus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.insertTask(task);
            }
        });

        min.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.removeTask(task);
            }
        });

        comboBox.setPrefWidth(400);
        comboBox.setPrefHeight(tasksHeight);

        setPrefHeight(-1.0);
        setPrefWidth(-1.0);

        getChildren().add(comboBox);
        getChildren().add(plus);
        getChildren().add(min);
    }

    private Button createButton(int layX, int prefHeight, int prefWidth, String text) {
        Button button = new Button();
        button.setLayoutX(layX);
        button.setPrefHeight(prefHeight);
        button.setPrefWidth(prefWidth);
        button.setText(text);
        return button;
    }
}
