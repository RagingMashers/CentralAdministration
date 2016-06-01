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

import java.util.*;

import java.net.URL;

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
    private HashMap<TaskPane, ComboBox> taskWithBoxes = new HashMap<>();
    private ObservableList<Task> tasks = FXCollections.observableArrayList();
    private List<ActionPlan> actionplans;

    @Override
    public void startController() {
        SitaApiSoap siteApi = ApiManager.getInstance().getSitaPort();
        String siteToken = ApiManager.getInstance().getSitaToken();

        CBStappenPlannen.getItems().clear();

        actionplans = new LinkedList<>();
        actionplans.addAll(siteApi.getActionPlans(siteToken).getActionPlan());
        tasks.addAll(siteApi.getTasks(siteToken).getTask());
        CBStappenPlannen.getItems().addAll(actionplans);

        TaskPane newTaskPane = new TaskPane(this);
        ComboBox comboBox = newTaskPane.getComboxBox();
        comboBox.getItems().addAll(tasks);

        tasksPanes.add(0, newTaskPane);
        taskWithBoxes.put(newTaskPane, newTaskPane.getComboxBox());
    }

    @Override
    public void backToMenu() {
        StageController.loadStage(View.mainScene, "main");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Bindings.bindContentBidirectional(tasksPanes, VboxStappenPlan.getChildren());
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
        int i = tasksPanes.indexOf(task);

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
        for (TaskPane pane: taskWithBoxes.keySet()) {
            reloadTask(pane);
        }
    }

    /**
     * Reload the combobox of a specific task
     * @param task The task that will be reloaded
     */
    private void reloadTask(TaskPane task) {
        ComboBox comboBox = task.getComboxBox();
        Task currentTask = (Task)comboBox.getValue();
        comboBox.getItems().clear();

        comboBox.getItems().clear();
        comboBox.getItems().addAll(tasks);
        comboBox.setValue(currentTask);
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
        if(!tfNewTask.getText().isEmpty()) {
            SitaApiSoap siteApi = ApiManager.getInstance().getSitaPort();
            String siteToken = ApiManager.getInstance().getSitaToken();

            siteApi.addTask(siteToken, tfNewTask.getText());
            tfNewTask.clear();
            System.out.println("Creating a task");

            tasks.clear();
            tasks.addAll(siteApi.getTasks(siteToken).getTask());

            reloadTasks();
        }
    }

    public void onClickCreateActionplan() {
        if(!tfNewActionPlan.getText().isEmpty()) {
            SitaApiSoap siteApi = ApiManager.getInstance().getSitaPort();
            String siteToken = ApiManager.getInstance().getSitaToken();

            siteApi.addActionPlan(siteToken, tfNewActionPlan.getText(), null);
            tfNewActionPlan.clear();
            System.out.println("Creating a actionplan");
            actionplans.clear();
            actionplans.addAll(siteApi.getActionPlans(siteToken).getActionPlan());
            CBStappenPlannen.getItems().clear();
            CBStappenPlannen.getItems().addAll(actionplans);
            CBStappenPlannen.setValue(actionplans.get(actionplans.size() - 1));
            CBStappenPlannen.getItems().sorted();
        }
    }


    public void ActionPlanSelected(){
        List<Task> actionPlanTasks = ((ActionPlan)CBStappenPlannen.getValue()).getTasks(). getTask();
        if(!actionPlanTasks.isEmpty()){
            tasksPanes.clear();
            int count = 0;
            for(Task task : actionPlanTasks){
                TaskPane newTaskPane = new TaskPane(this);
                ComboBox comboBox = newTaskPane.getComboxBox();
                comboBox.getItems().addAll(tasks);
                comboBox.setValue(task);

                tasksPanes.add(count, newTaskPane);
                taskWithBoxes.put(newTaskPane, newTaskPane.getComboxBox());
                count++;
            }
        }

    }
}



