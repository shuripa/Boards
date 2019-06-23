package panes;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class Propertyes {

    private TableView table;
    private static Propertyes instance;
    private ArrayList<String> arrTitle;
    private ArrayList<String> arrValue;
    private VBox vBox;

    private Propertyes(){
        arrTitle = new ArrayList<>();
        arrValue = new ArrayList<>();
        table = new TableView();
//        TableColumn<table, String> prTitle = new TableColumn("Свойства");
        TableColumn prValue = new TableColumn("Значения");
//        table.getColumns().addAll(prTitle, prValue);
        table.setPrefWidth(215);
        table.setPrefHeight(700);
        vBox = new VBox();
    }

    public static Propertyes getInstance() {
        if (instance == null) instance = new Propertyes();
        return instance;
    }

    public void addProperty(String title, String value){
        arrTitle.add(title);
        arrValue.add(value);
    }

    public VBox getTable(){
        vBox.getChildren().add(table);
        return vBox;
    }
}
