package leyout.groups;

import leyout.controllers.HumanController;
import leyout.wievs.ShapeNode;
import leyout.wievs.ShapePushcart;
import javafx.scene.Group;
import leyout.Infoable;

public class GroupPushcart extends Group implements Infoable {
    HumanController human;
    ShapePushcart pushcart;
    ShapeNode nEnt;
    ShapeNode nExt;
    public GroupPushcart(int x, int y, double a){
        human = new HumanController();
        pushcart = new ShapePushcart();
        nEnt = new ShapeNode(this);
        nExt = new ShapeNode(this);

        paint();
        getChildren().addAll(human.getWievAsSuper(), pushcart, nEnt, nExt);

        relocate(x,y);
        setRotate(a);
    }

    private void paint() {
        human.relocate(5, 0);
        pushcart.relocate(0, 20);
        nEnt.relocate(0, 2);
        nExt.relocate(24, 2);
    }

    @Override
    public void showInfo() {

    }
}
