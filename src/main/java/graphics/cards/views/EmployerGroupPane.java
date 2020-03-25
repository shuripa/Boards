package graphics.cards.views;

import graphics.cards.controllers.EmployerCardController;
import graphics.cards.controllers.PaneComponentController;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import model.Employee;
import sets.SetEmployees;

public class EmployerGroupPane extends TitledPane {                                     // Создание панели

    public EmployerGroupPane() {

        SetEmployees ems = SetEmployees.getInstance();
        VBox vBox = new VBox();
        vBox.setSpacing(2.0);

        for (Employee e: ems.getEmployees()) {                              // Создание набора карточек
            PaneComponentController emc = new EmployerCardController(e);
            vBox.getChildren().add(emc.view());
        }

        ScrollPane scrollPane = new ScrollPane(vBox);
        this.setContent(scrollPane);
        this.setText("Employers");
    }

}
