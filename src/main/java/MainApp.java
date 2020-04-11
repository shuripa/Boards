import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import startmenu.StartMenu;


public class MainApp extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {


        TilePane startMenu = new StartMenu(primaryStage);

        Scene scene1 = new Scene(startMenu, 800, 600);
        scene1.getStylesheets().add(MainApp.class.getResource("style.css").toExternalForm());
//        Scene scene2 = new Scene(ly, 800, 600);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("MainApp");
//        scene1.setFill(Color.TRANSPARENT);
//        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }

//    TODO: MVC для Employera
//    TODO: Leyout created as singlton. When leyouts been many this method don't aproach.
}
