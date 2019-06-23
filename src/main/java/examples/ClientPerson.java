package examples;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

import static javafx.collections.FXCollections.observableArrayList;

public class ClientPerson extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Bosses and Employees: Chapter 4 Working with Tables");
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 500, 250, Color.WHITE);
//        create a grid pane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(5));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        root.setCenter(gridPane);

//        candidates Label
//        Label candidatesLbl = new Label("Boss");
        Text candidatesLbl = new Text("Boss");
        GridPane.setHalignment(candidatesLbl, HPos.CENTER);
        gridPane.add(candidatesLbl, 0 , 0);
//        list of bosses
        ObservableList<Person> bosses = getPeople();
//        ListView<Person> leaderListView = new ListView<>(leaders);
        final ListView<Person> leaderListView = new ListView<Person>(bosses);
//        final ListView<Person> leaderListView = new ListView<>(leaders);
        leaderListView.setPrefWidth(150);
        leaderListView.setPrefHeight(150);
        leaderListView.setMaxWidth(Double.MAX_VALUE);
//        display first and last firstName with tooltip using alias
        leaderListView.setCellFactory(new Callback<ListView<Person>, ListCell<Person>>() {
            @Override
            public ListCell<Person> call(ListView<Person> param) {
                Label leadLbl = new Label();
                Tooltip tooltip = new Tooltip();
                ListCell<Person> cell = new ListCell<Person>(){
                    @Override
                    public void updateItem (Person item, boolean empty){
                        super.updateItem(item, empty);
                        if (item != null){
                            leadLbl.setText(item.getAliasName());
                            setText(item.getFirstName()+ " " + item.getLastName());
                            tooltip.setText(item.getAliasName());
                            setTooltip(tooltip);
                        }
                    }
                };//ListCell
                return cell;
            }
        });//setCellFactory
        gridPane.add(leaderListView, 0, 1);

        Label emplLbl = new Label("Employees");
        gridPane.add(emplLbl, 2, 0);
        GridPane.setHalignment(emplLbl, HPos.CENTER);

        final TableView<Person> employeeTableView = new TableView<>();
        employeeTableView.setPrefWidth(300);

        final ObservableList<Person> teamMembers = observableArrayList();
        employeeTableView.setPrefWidth(300);

        TableColumn<Person, String> aliasNameCol = new TableColumn<>("Alias");
        aliasNameCol.setEditable(true);
        aliasNameCol.setCellValueFactory(new PropertyValueFactory<>("aliasName"));
        aliasNameCol.setPrefWidth(employeeTableView.getPrefWidth()/3);

        TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        firstNameCol.setPrefWidth(employeeTableView.getPrefWidth()/3);

        TableColumn<Person, String> lastNameColl = new TableColumn<>("Last Name");
        lastNameColl.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lastNameColl.setPrefWidth(employeeTableView.getPrefWidth()/3);

        employeeTableView.getColumns().setAll(aliasNameCol, firstNameCol, lastNameColl);
        gridPane.add(employeeTableView, 2 , 1);

//        selection listening
        leaderListView.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends Person> observable, Person oldvalue, Person newValue) -> {
                    if (observable != null && observable.getValue() != null){
                        teamMembers.clear();
                        teamMembers.addAll(observable.getValue().emploeesProperty());
                    }
        });

        stage.setScene(scene);
        stage.show();
    }

    private ObservableList<Person> getPeople(){
//        ObservableList<Person> people = FXCollections.<Person>observableArrayList();
        ObservableList<Person> people = FXCollections.<Person>observableArrayList();
        Person docX = new Person("Person X", "Charles", "Xavier");
        docX.emploeesProperty().add(new Person("Wolverine", "James", "Howlett"));
        docX.emploeesProperty().add(new Person("Cyclops", "Scott", "Summers"));
        docX.emploeesProperty().add(new Person("Storm", "Ororo", "Munroe"));
        Person magneto = new Person("Magneto", "Max", "Eisenhardt");
        magneto.emploeesProperty().add(new Person("Smale", "Vladimir", "Klepik"));
        Person biker = new Person("Mountain Biker", "Jonathan", "Gennick");
        biker.emploeesProperty().add(new Person("Real", "Taras", "XXX"));
        people.addAll(docX, magneto, biker);
        return people;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
