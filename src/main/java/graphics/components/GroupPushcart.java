package graphics.components;

import javafx.scene.Group;
import graphics.Infoable;
import graphics.views.ShapeNode;
import graphics.views.ShapePushcart;

public class GroupPushcart extends Group implements Infoable {
    Human human;
    ShapePushcart pushcart;
    ShapeNode nEnt;
    ShapeNode nExt;
    public GroupPushcart(int x, int y, double a){
        human = new Human();
//        pushcart = new ShapePushcart();
//        nEnt = new ShapeNode(this);
//        nExt = new ShapeNode(this);

        paint();
//        getChildren().addAll(human.view(), pushcart, nEnt, nExt);

        relocate(x,y);
        setRotate(a);
    }

    private void paint() {
//        human.setXY(5, 0);
        pushcart.relocate(0, 20);
        nEnt.relocate(0, 2);
        nExt.relocate(24, 2);
    }

}
