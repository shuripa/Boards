package startmenu;

import graphics.Layout;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import panes.RightPanel;

public class LeyautSceneCreater implements ItemAction {
    Stage stage;

    public LeyautSceneCreater(Stage stage){
        this.stage = stage;
    }

        // Создание компонентов новой сцены

    private Layout layout(){
        Layout result = Layout.getInstace();
        result.show();
        return result;
    }

    private Accordion rightPanel(){
        return RightPanel.getInstance();
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
