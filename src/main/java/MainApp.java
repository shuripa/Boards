import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import startmenu.ItemAction;
import startmenu.LayoutSceneCreater;
import startmenu.StartMenuItem;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <b><i>{@code MainApp}</b></i> Стартовый класс
 */

public class MainApp extends Application {

    private static final Logger logger = Logger.getLogger("MainApp");

    public static void main(String[] args) {
        setLogger();
        logger.log(Level.CONFIG, "Start project");
        launch(args);
        logger.log(Level.CONFIG, "End project");
    }

    private static void setLogger() {
        if (System.getProperty("java.util.logging.config.class") == null
        && System.getProperty("java.util.logging.config.file") == null){
            try{
                logger.setLevel(Level.FINE);
                final int LOG_ROTATION_COUNT = 3;
                FileHandler txtLog = new FileHandler("logging/MainApp.log", 0, LOG_ROTATION_COUNT);
                Formatter txtFormatter = new LogFormatter();
                txtLog.setFormatter(txtFormatter);
                logger.addHandler(txtLog);
            } catch (IOException e) {
                logger.log(Level.CONFIG, "Can't create log file MainApp.log", e);
            }
        }
    }

    @Override
    public void start(Stage primaryStage) {
        TilePane startMenu = startMenu(primaryStage);
        logger.log(Level.CONFIG, "Creating menuScene");
        Scene scene1 = new Scene(startMenu, 800, 600);
        scene1.getStylesheets().add(MainApp.class.getResource("style.css").toExternalForm());
        primaryStage.setScene(scene1);
        primaryStage.setTitle("MainApp");
        logger.log(Level.CONFIG, "Showing stage");
        primaryStage.show();
    }

    private TilePane startMenu(Stage stage){
        logger.log(Level.CONFIG, "Creating pane to menuScene");
        TilePane result = new TilePane();
        result.getStylesheets().add("style.css");
//        TODO: lc8 и далее отображает тот же лейаут что и lb9
        ItemAction sceneB9 = new LayoutSceneCreater(stage);
        StartMenuItem lb9 = new StartMenuItem(sceneB9, 190, 75 , 5, 5, "CHO B9");
        StartMenuItem lc8 = new StartMenuItem(sceneB9, 190, 75 , 5, 5, "CHO C8");
        StartMenuItem pre = new StartMenuItem(sceneB9, 190, 75 , 5, 5, "PreProd");
        StartMenuItem prs = new StartMenuItem(sceneB9, 190, 75 , 5, 5, "Porche");
        result.getChildren().addAll(lb9, lc8, prs, pre);
        return result;
    }

}