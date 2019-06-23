package panes;

import inout.PlanCsvLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class TablePlan {
    TableView<PlanElement> table;

    public TableView<PlanElement> getTable() {
        return table;
    }

    public TablePlan(PlanCsvLoader planCsvLoader){

        //        План
        ArrayList<PlanElement> arrPlan = new ArrayList<>();
        arrPlan = planCsvLoader.getArrPlan();

        ObservableList<PlanElement> elements = FXCollections.observableArrayList(
//            new PlanElement("MFC1", 10, 15.0),
//            new PlanElement("MFC2", 10, 15.0),
//            new PlanElement("MFC3", 10, 15.0),
//            new PlanElement("MFC4", 10, 15.0)
              arrPlan
        );

        TableView<PlanElement> tab = new TableView<PlanElement>(elements);
        table = new TableView<>(elements);
        table.setPrefWidth(215);
        table.setPrefHeight(700);

        //Столбец названия модуля
        TableColumn<PlanElement, String> modulCol = new TableColumn<>("Модуль");
        //Определяем фабрику для столбца с привязкой к свойству modul
        modulCol.setCellValueFactory(new PropertyValueFactory<>("modul"));
        //Добавляем столбец к таблице
        table.getColumns().add(modulCol);

        //Столбец количеств
        TableColumn<PlanElement, Integer> countCol = new TableColumn<>("К-ть");
        countCol.setCellValueFactory(new PropertyValueFactory<>("count"));
        table.getColumns().add(countCol);
        //Столбец еталонного времени
        TableColumn<PlanElement, Double> timeCol = new TableColumn<>("ЕтЧас");
        timeCol.setCellValueFactory(new PropertyValueFactory<PlanElement, Double>("ettime"));
        table.getColumns().add(timeCol);

//        for (PlanElement e: elements) {
//            System.out.println(e);
//        }


        for (int i = 0; (i < arrPlan.size()); i++) {
            Rectangle r = new Rectangle(100, 15);
//                r.setFill(Color.LIGHTBLUE);
//                r.setStroke(Color.DARKGRAY);
            Text m = new Text(arrPlan.get(i).getModul());
            m.setFont(new Font(9));
            m.setFill(Color.LIGHTBLUE);
            m.setStroke(Color.DARKGRAY);
            Text c = new Text("" + arrPlan.get(i).getCount());
            c.setFont(new Font(9));
            c.setFill(Color.LIGHTBLUE);
            c.setStroke(Color.DARKGRAY);
            Text t = new Text("" + arrPlan.get(i).getEttime());
            t.setFont(new Font(9));
            t.setFill(Color.LIGHTBLUE);
            t.setStroke(Color.DARKGRAY);

            HBox hb = new HBox();
            hb.setSpacing(5);
            hb.getChildren().addAll(m,c,t);

            //                tpplan.getChildren().addAll(r, t);
//            getChildren().addAll(table);
        }
    }

}
