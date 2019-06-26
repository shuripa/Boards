import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import leyout.Layout;
import leyout.views.LeyoutComponentView;
import panes.RightPanel;


public class StartMenuItem extends LeyoutComponentView {
    TitledPane propertyPane;

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


//            Лейаут
            Layout layout = Layout.getInstace();

////            Правая панель лейаута
            Accordion rightPanel = RightPanel.getInstance();

//            Корневая панель
            BorderPane rootPane = new BorderPane();
            rootPane.setRight(rightPanel);
            rootPane.setCenter(layout);

//            Полноекранный режим
//            stage.setFullScreen(true);

//            stage.setOnShowing(e ->{
//                tabpane.setPrefWidth(stage.getWidth());
//                tabpane.setPrefHeight(stage.getHeight());
//            });

            Scene scene = new Scene(rootPane, stage.getMaxWidth(), stage.getMaxHeight());
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

    public void setPropertyPane(TitledPane propertyPane) {
        this.propertyPane = propertyPane;
    }

    @Override
    protected void setEventTonExt(MouseButton button) {

    }

    @Override
    public void paint() {

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
