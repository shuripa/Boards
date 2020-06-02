package startmenu;

import graphics.Layout;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import panes.RightPanel;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LayoutSceneCreater implements ItemAction {
    Stage stage;

    @Override
    public String toString() {
        return "Action is LayoutSceneCreater{}";
    }

    public LayoutSceneCreater(Stage stage){
        this.stage = stage;
    }

        // Создание компонентов новой сцены

    @Override
    public void action() {
        stage.setScene(createScene());
        stage.setMaximized(true);
    }

    private Scene createScene(){
        return  new Scene(rootPane(), stage.getMaxWidth(), stage.getMaxHeight());
    }

    private BorderPane rootPane(){
        BorderPane result = new BorderPane();
        ScrollPane leyoutPane = new ScrollPane(layout());
        result.setCenter(leyoutPane);
        result.setRight(rightPanel());
        return result;
    }

    private Accordion rightPanel(){
        return RightPanel.getInstance();
    }

    private Layout layout(){
        Logger.getLogger("MainApp").log(Level.CONFIG, "Loading single layout");
        Layout result = Layout.getInstace();
        result.show();
        return result;
    }

}
