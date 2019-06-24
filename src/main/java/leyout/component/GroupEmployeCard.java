package leyout.component;

import leyout.controllers.EmployerController;
import leyout.views.ShapeEmployeCard;
import inout.EmployesCsvLoader;
import inout.SkillCsvLoader;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import leyout.Infoable;
import model.Employer;

import java.io.IOException;
import java.util.HashMap;

public class GroupEmployeCard extends Group implements Infoable {

    private VBox vBox;
    private ShapeEmployeCard emc;
    private Employer em;
    private ScrollPane scrollPane;


    public GroupEmployeCard(){
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
            emc = new ShapeEmployeCard("" + entry.getKey(), ""+ entry.getValue().getName(), 200);
            vBox.getChildren().add(emc);
            new EmployerController(em, emc);
        }


        vBox.setSpacing(2.0);
        scrollPane = new ScrollPane(vBox);
//        scrollPane.setContent(vBox);
    }

    @Override
    public void showInfo() {

    }
    public ScrollPane getBox() {
        return scrollPane;
    }

}
