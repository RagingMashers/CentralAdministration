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
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by frank on 18/05/2016.
 */
public class StappenPlanController implements IController {
    @FXML
    public VBox VboxStappenPlan;
    @FXML
    public JFXComboBox CBStappenPlannen;

    private ObservableList<Node> taskPanes = FXCollections.observableArrayList();
    private ObservableList<ActionPlan> actionplans = FXCollections.observableArrayList();
    private ObservableList<Task> tasks  = FXCollections.observableArrayList();

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
        Bindings.bindContentBidirectional(taskPanes, VboxStappenPlan.getChildren());
        addTask();
    }

    public void removeTask(TaskPane task) {
        try {
            // Make sure there is always at least one task
            taskPanes.get(1);
            taskPanes.remove(task);
        }
        catch (Exception e) {
            System.out.println("Index out of range");
        }

    }

    public void insertTask(TaskPane task) {
        int i = taskPanes.indexOf(task);
        TaskPane newTask = new TaskPane(this);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                taskPanes.add(i + 1, newTask);
            }
        });

    }

    private void addTask() {
        TaskPane task = new TaskPane(this);
        taskPanes.add(task);
    }


    public void ActionPlanSelected(){
        System.out.println("wtf");
        for(Task task : tasks){
            System.out.println(task.getDescription());
            insertTask(new TaskPane(this));
        }

    }
}



