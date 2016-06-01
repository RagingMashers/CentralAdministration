import SitaApi.ActionPlan;
import SitaApi.Task;
import SitaApi.SitaApiSoap;
import com.jfoenix.controls.JFXComboBox;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * Created by frank on 18/05/2016.
 */
public class StappenPlanController implements IController {
    @FXML
    public VBox VboxStappenPlan;
    @FXML
    public JFXComboBox CBStappenPlannen;
    @FXML
    public TextField tfNewTask;
    @FXML
    public TextField tfNewActionPlan;

    private ObservableList<Node> tasksPanes = FXCollections.observableArrayList();
    private HashMap<Node, ComboBox> taskWithBoxes = new HashMap<>();
    private ObservableList<Task> tasks = FXCollections.observableArrayList();
    private ObservableList<ActionPlan> actionplans = FXCollections.observableArrayList();

    @Override
    public void startController() {
        SitaApiSoap siteApi = ApiManager.getInstance().getSitaPort();
        String siteToken = ApiManager.getInstance().getSitaToken();

        CBStappenPlannen.getItems().clear();
        actionplans.addAll(siteApi.getActionPlans(siteToken).getActionPlan());
        tasks.addAll(siteApi.getTasks(siteToken).getTask());
        CBStappenPlannen.getItems().addAll(actionplans);
    }

    @Override
    public void backToMenu() {
        StageController.loadStage(View.mainScene, "main");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Bindings.bindContentBidirectional(tasksPanes, VboxStappenPlan.getChildren());

        tasksPanes.add(createTask());
    }

    /**
     * Remove a task from the actionplan
     * @param task the task that will be removed
     */
    public void removeTask(TaskPane task) {
        try {
            // Make sure there is always at least one task
            tasksPanes.get(1);
            tasksPanes.remove(task);
        }
        catch (Exception e) {
            System.out.println("Index out of range");
        }
    }

    /**
     * Insert a task on a certain position
     * @param task create the new task after this task
     */
    public void insertTask(TaskPane task) {
        int i = tasks.indexOf(task);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                tasksPanes.add(i + 1, createTask());
            }
        });

    }

    /**
     * Reload the comboboxes of all the tasks
     */
    private void reloadTasks() {
        for (ComboBox c: taskWithBoxes.values()
             ) {
            c.getItems().clear();

            c.getItems().add("banaantjes");
        }
    }

    /**
     * Reload the combobox of a specific task
     * @param task The task that will be reloaded
     */
    private void reloadTask(TaskPane task) {
        ComboBox comboBox = task.getComboxBox();
        comboBox.getItems().clear();

        comboBox.getItems().add("appeltjes");
    }

    /**
     * Create a new task
     * @return the new created task
     */
    private TaskPane createTask() {
        TaskPane task = new TaskPane(this);
        taskWithBoxes.put(task, task.getComboxBox());

        reloadTask(task);
        return task;
    }


    public void onClickCreateTask() {
        tfNewTask.clear();
        System.out.println("Creating a task");
    }

    public void onClickCreateActionplan() {
        tfNewActionPlan.clear();
        System.out.println("Creating a actionplan");
    }


    public void ActionPlanSelected(){
        System.out.println("wtf");
        for(Task task : tasks){
            System.out.println(task.getDescription());
            insertTask(new TaskPane(this));
        }

    }
}



