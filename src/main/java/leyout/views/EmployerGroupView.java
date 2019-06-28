package leyout.views;

import inout.EmployesCsvLoader;
import inout.SkillCsvLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import leyout.components.Employer;

import java.io.IOException;
import java.util.HashMap;

public class EmployerGroupView extends PaneComponentView {

    private ScrollPane scrollPane;
    private VBox vBox;
    private ShapeEmployeCard emc;
    private Employer em;


    public EmployerGroupView(){
        //            Загрузка работников
        //            Загрузка скилов

        EmployesCsvLoader ecl = null;
        SkillCsvLoader scl = null;

        HashMap<Integer, Employer> hm = new HashMap<>();


        try {
            ecl = new EmployesCsvLoader();
            hm = ecl.getArrEmp();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            scl = new SkillCsvLoader(ecl.getArrEmp());
        } catch (IOException e) {
            e.printStackTrace();
        }

        vBox = new VBox();
        for (HashMap.Entry<Integer, Employer> entry : hm.entrySet()) {
//                TODO: Так и не понятно - ID Должен быть String или Integer
            em = entry.getValue();
//            emc = new ShapeEmployeCard("" + entry.getKey(), ""+ entry.getValue().getName(), 200);
//            vBox.getChildren().add(emc);
//            new EmployerCardController(em, emc);
        }


        vBox.setSpacing(2.0);
        scrollPane = new ScrollPane(vBox);
//        scrollPane.setContent(vBox);
    }


    public ScrollPane getBox() {
        return scrollPane;
    }

}
