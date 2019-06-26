package panes;

import inout.PlanCsvLoader;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.FlowPane;

import java.io.IOException;

public class PlanPane extends TitledPane {

    public PlanPane() {
        //            Загрузка плана + создание таблицы плана
        TablePlan plan = null;
        try {
            plan = new TablePlan(new PlanCsvLoader());
        } catch (IOException e) {
            e.printStackTrace();
        }

        FlowPane tabpane = new FlowPane();
        tabpane.getChildren().add(plan.getTable());
        tabpane.setPrefWidth(210);

        this.setText("Plan");
        this.setContent(tabpane);
    }
}
