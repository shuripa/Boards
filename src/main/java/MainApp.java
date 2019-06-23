import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;


public class
MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

//        //TODO: lc8 отображает тот же лейаут что и lb9
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
//    TODO: Из Leyout-а сделан синглтон. Когда лейаутов будет много такой номер не пройдет.
//          Нужно будет делать тдельный класс, например APP из которого делать синглтон и который
//          будет содержать все лейауты
}
