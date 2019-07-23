package graphics.cards.views;

import inout.EmployesCsvLoader;
import inout.SkillCsvLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import graphics.leyout.components.Employer;
import graphics.cards.controllers.EmployerCardController;
import graphics.cards.controllers.PaneComponentController;

import java.io.IOException;
import java.util.HashMap;

public class EmployerGroupPane extends TitledPane {                                     // Создание панели

    public EmployerGroupPane() {

        EmployesCsvLoader ecl = null;                                                   // Загрузка работников
        SkillCsvLoader scl = null;                                                      // Загрузка скилов

        HashMap<Integer, Employer> hm = new HashMap<>();

        try {
            ecl = EmployesCsvLoader.getInstance();
            hm = ecl.getArrEmp();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            scl = new SkillCsvLoader(ecl.getArrEmp());
        } catch (IOException e) {
            e.printStackTrace();
        }

        VBox vBox = new VBox();
        vBox.setSpacing(2.0);

        for (HashMap.Entry<Integer, Employer> entry : hm.entrySet()) {                      // Создание набора карточек
            PaneComponentController emc = new EmployerCardController(entry.getValue());
            vBox.getChildren().add(emc.view());
        }

        ScrollPane scrollPane = new ScrollPane(vBox);
        this.setContent(scrollPane);
        this.setText("Employers");
    }

}
