package leyout.groups.test;

import leyout.controllers.CanbanController;
import leyout.controllers.GridController;
import leyout.groups.GroupLine;
import leyout.Infoable;
import leyout.wievs.ShapeConnection;
import leyout.wievs.ShapeNode;
import javafx.scene.Group;
import javafx.scene.input.MouseButton;

public abstract class LeyoutGroupWiev extends Group implements Infoable {
    GroupBoardController controller;
    ShapeNode nEnt;                     //Точка старта (входа)
    ShapeNode nExt;                     //Точка выхода

    int size;
    int x;
    int y;
    double a;


    public LeyoutGroupWiev(GroupBoardController controller, int size, int x, int y, double a) {
        this.controller = controller;
        this.size = size;
        this.x = x;
        this.y = y;
        this.a = a;
        getElements();
        emplacement(size);
        createNodes();
        this.getStylesheets().add("style.css");
        relocate();
    }

    public GroupBoardController getController() {
        return controller;
    }

    public void createNodes(){
        //node start
        nEnt = new ShapeNode(this);
        nEnt.relocate(0, 16);
        nEnt.setOnMouseClicked(mouseEvent -> {
            MouseButton button = mouseEvent.getButton();
            if (button == MouseButton.PRIMARY) {
                CanbanController cc = CanbanController.getInstance();
                for (String s : ((GridController)controller.getGridController()).getMaterial()) {
                    for (ShapeNode ext : cc.getExt(s)) {
                        new ShapeConnection(nEnt.getX(), nEnt.getY(), ext.getX(), ext.getY());
                        ext.getOwner().showInfo();
                    }

                }
            } else{
                GroupLine.getInstance().rem();
                System.out.println("MouseLeft");
            }
        });

        //node end
        nExt = new ShapeNode(this);
        nExt.relocate(size - 5, 16);
        this.getChildren().addAll(nEnt, nExt);
    }

    public void relocate(){                             //Перемещение группы
        this.relocate(x, y);
        this.setRotate(a);
    }

    public abstract void getElements();                 //Добавление элементов

    public abstract void emplacement (int size);        //Расположение элементов

}
