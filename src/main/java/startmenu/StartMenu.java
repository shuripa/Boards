package startmenu;

import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class StartMenu extends TilePane {

    public StartMenu(Stage stage){
        this.getStylesheets().add("style.css");
//        TODO: lc8 и далее отображает тот же лейаут что и lb9
        ItemAction sceneB9 = new LeyautSceneCreater(stage);
        StartMenuItem lb9 = new StartMenuItem(sceneB9, 190, 75 , 5, 5, "CHO B9");
        StartMenuItem lc8 = new StartMenuItem(sceneB9, 190, 75 , 5, 5, "CHO C8");
        StartMenuItem pre = new StartMenuItem(sceneB9, 190, 75 , 5, 5, "PreProd");
        StartMenuItem prs = new StartMenuItem(sceneB9, 190, 75 , 5, 5, "Porche");
        this.getChildren().addAll(lb9, lc8, prs, pre);
    }
}
