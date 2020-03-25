import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class StartMenu extends TilePane {
    public StartMenu(Stage primaryStage){
        this.getStylesheets().add("style.css");
        StartMenuItem lb9 = new StartMenuItem(primaryStage, 190, 75 , 5, 5, "CHO B9");
        lb9.setId("txt0");
        //TODO: lc8 отображает тот же лейаут что и lb9
        StartMenuItem lc8 = new StartMenuItem(primaryStage, 190, 75 , 5, 5, "CHO C8");
        StartMenuItem pre = new StartMenuItem(primaryStage, 190, 75 , 5, 5, "PreProd");
        StartMenuItem prs = new StartMenuItem(primaryStage, 190, 75 , 5, 5, "Porche");
        this.getChildren().addAll(lb9, lc8, prs, pre);
    }
}
