import inout.PlanCsvLoader;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import leyout.groups.GroupEmployeCard;
import leyout.Layout;
import leyout.LeyoutComponentWiev;
import panes.TablePlan;

import java.io.IOException;


public class StartMenuItem extends LeyoutComponentWiev {
    public StartMenuItem(Stage stage, int w, int h, int x, int y, String text){


//        bp.setRight(tabpane);
//        this.getStylesheets().add("style.css");
        Rectangle rb = new Rectangle(w, h);
        addActiveElement(rb);
//        rb.setStroke(Color.rgb(82, 79, 161, 0.5));
//        rb.setStrokeWidth(0.5);
//        rb.setId("ent");
//        rb.setStrokeWidth(0.1);

        //td
        Text td = new Text(text);
        td.setFont(new javafx.scene.text.Font(32));
//        td.setId("blanktxt");
        td.setX(x + 35);
        td.setY(y + 50);

        addActiveElement(td);

        rb.setOnMouseClicked(event -> {
            rb.setId("ent");
            updateBounds();

//            Корневая панель
            BorderPane bp = new BorderPane();

//            Лейаут
            Layout layout = Layout.getInstace();

//            Робочі
            TilePane tpemp = new TilePane();
            for (int i = 0; i < 20; i++) {
                Circle c = new Circle(20, 20, 20);
                c.setFill(Color.LIGHTBLUE);
                c.setStroke(Color.DARKGRAY);
                tpemp.getChildren().add(c);
            }

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
            TitledPane tablePane = new TitledPane("Plan", tabpane);

//            Загрузка работников
//            Загрузка скилов
//            Карточка работника
            GroupEmployeCard gec = new GroupEmployeCard();
            TitledPane gecPane = new TitledPane("Employes", gec.getBox());
//            Редактор лейаута. Иконки объектов лейаута
            VBox editorBox = new VBox();
            TitledPane editPane = new TitledPane("Editor", editorBox);
//
//            Набор свойств
            Label l1 = new Label("X");
            Label l2 = new Label("Y");
            Label l3 = new Label("A");
            TextField t1 = new TextField("600");
            TextField t2 = new TextField("0");
            TextField t3 = new TextField("180");
            HBox h1 =new HBox(l1, t1);
            HBox h2 =new HBox(l2, t2);
            HBox h3 =new HBox(l3, t3);
            VBox propertyBox = new VBox();
            propertyBox.getChildren().addAll(h1, h2, h3);
            TitledPane propertyPane = new TitledPane("Property", propertyBox);
//            Материалы на сетке
            VBox materialBox = new VBox();
            TitledPane materialPane = new TitledPane("Material", materialBox);
//            Правая панель лейаута
            Accordion accordion = new Accordion();
            accordion.getPanes().addAll(tablePane, gecPane, materialPane, editPane, propertyPane);
//            HBox hb = new HBox(tabpane, gec.getBox());
//            bp.setRight(hb);
            bp.setRight(accordion);

//            HBox hb2 = new HBox(tabpane, tpemp);
//            hb2.setSpacing(1);
//            bp.setRight(hb2);

            bp.setCenter(layout);

//            Полноекранный режим
//            stage.setFullScreen(true);

//            stage.setOnShowing(e ->{
//                tabpane.setPrefWidth(stage.getWidth());
//                tabpane.setPrefHeight(stage.getHeight());
//            });

            Scene scene = new Scene(bp, stage.getMaxWidth(), stage.getMaxHeight());
            stage.setScene(scene);
//            stage.setFullScreen(true);  // Полноекранный режим
            stage.setMaximized(true);

        });

//        rb.setOnMouseEntered(event -> {
//            rb.setId("sel");
//            td.setId("seltxt");
//        });
//
//        rb.setOnMouseExited(event -> {
//            rb.setId("blank");
//            td.setId("blanktxt");
//        });

//        rb.setId("blank");
        rb.setStrokeWidth(0.5);
        rb.relocate(x,y);

//        this.getChildren().addAll(rb, td);
    }

    @Override
    protected void setEventTonExt(MouseButton button) {

    }

    @Override
    protected void getElements() {

    }

    @Override
    protected void emplacement(int size) {

    }

    @Override
    protected void paint() {

    }

    @Override
    public void setSize(int size) {

    }

    @Override
    public void reset() {

    }

    @Override
    public void showInfo() {

    }
}
