package leyout.component;

import leyout.controllers.HumanController;
import leyout.views.*;
import javafx.scene.Group;
import leyout.Infoable;

public class GroupBlank extends Group implements Infoable {
    HumanController h1;
    ShapeBlank bs1;
    ShapeBoardInd bis1;
    ShapeGrid sg;
    ShapeNode nEnt;
    ShapeNode nExt;

    public GroupBlank(String id, String dsc, int size, int x, int y, double a, int ind) {
        //a - угол
        //ind - индикатор
        //id - номер доски
        //dsc - описание
//        Робітник
        h1 = new HumanController();
//        h1.relocate(size/2-10, 7);
        h1.relocate(size/2-10, 0);
//        Робоче місце
        bs1 = new ShapeBlank(id, dsc, size);
        bs1.relocate(5, 17);
//        Індикатор
        bis1 = new ShapeBoardInd(ind);
        bis1.relocate(0, -1);
//        Сітка
        sg = new ShapeGrid(size);
        sg.relocate(0, 38);
//        Узли
//        node start
        nEnt = new ShapeNode(this);
        nEnt.relocate(2, 8);
        nEnt.setOnMouseClicked(mouseEvent -> {
            for (ShapeNode sn :nEnt.getArNodes()) {
                ShapeConnection sc = new ShapeConnection(nEnt.getX(), nEnt.getY(), sn.getX(), sn.getY());
                getChildren().add(sc);
            }
        });

//        node end
        nExt = new ShapeNode(this);
        nExt.relocate(size-7, 8);

//
        this.getChildren().addAll(bis1, bs1, h1.getWievAsSuper(), sg, nEnt, nExt);
        this.relocate(x, y);
        this.setRotate(a);

    }

    @Override
    public void showInfo() {

    }
}
