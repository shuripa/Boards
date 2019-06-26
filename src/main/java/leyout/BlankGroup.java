package leyout;

import leyout.views.ShapeConnection;
import leyout.views.ShapeNode;
import javafx.scene.Group;

public class BlankGroup extends Group implements Infoable{
    protected ShapeNode nEnt;
    protected ShapeNode nExt;

    public BlankGroup(double X, double Y, double size){
        nEnt = new ShapeNode(this);
        nEnt.relocate(X + 4, Y + 12);
        nEnt.setOnMouseClicked(mouseEvent -> {
            for (ShapeNode sn :nEnt.getArNodes()) {
                ShapeConnection sc = new ShapeConnection(nEnt.getX(), nEnt.getY(), sn.getX(), sn.getY());
                getChildren().add(sc);
            }
        });

        nExt = new ShapeNode(this);
        nExt.relocate(X + size - 10, Y + 12);
        getChildren().addAll(nEnt, nExt);
    }

}
