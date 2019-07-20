package graphics.leyout.components;

import javafx.scene.Group;
import graphics.cards.Infoable;
import graphics.leyout.views.ShapeNode;
import graphics.leyout.views.ShapePushcart;

public class GroupPushcart extends Group implements Infoable {
    WorkPlace workPlace;
    ShapePushcart pushcart;
    ShapeNode nEnt;
    ShapeNode nExt;
    public GroupPushcart(int x, int y, double a){
        workPlace = new WorkPlace();
//        pushcart = new ShapePushcart();
//        nEnt = new ShapeNode(this);
//        nExt = new ShapeNode(this);

        paint();
//        getChildren().addAll(workPlace.view(), pushcart, nEnt, nExt);

        relocate(x,y);
        setRotate(a);
    }

    private void paint() {
//        workPlace.setXY(5, 0);
        pushcart.relocate(0, 20);
        nEnt.relocate(0, 2);
        nExt.relocate(24, 2);
    }

}
