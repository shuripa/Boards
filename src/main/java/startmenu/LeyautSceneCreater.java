package startmenu;

import graphics.Layout;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import panes.RightPanel;

import java.io.IOException;

public class LeyautSceneCreater implements ItemAction {
    Stage stage;

    public LeyautSceneCreater(Stage stage){
        this.stage = stage;
    }

        // Создание компонентов новой сцены

    private Layout layout(){
        Layout result = null;
        try {
            result = Layout.getInstace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            result.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Accordion rightPanel(){
        Accordion result = null;
        try {
            result = RightPanel.getInstance();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private BorderPane rootPane(){
        BorderPane result = new BorderPane();
        result.setRight(rightPanel());
        result.setCenter(layout());
        return result;
    }

    private Scene createScene(){
        return  new Scene(rootPane(), stage.getMaxWidth(), stage.getMaxHeight());
    }

    @Override
    public void action() {
        stage.setScene(createScene());
        stage.setMaximized(true);
    }

}
