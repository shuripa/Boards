package graphics.leyout.components;


import graphics.leyout.controllers.WorkPlaceController;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import graphics.cards.Infoable;
import graphics.leyout.controllers.BoardController;
import graphics.leyout.controllers.CompositBoardController;
import graphics.leyout.controllers.GridController;
import graphics.leyout.views.ShapeBoardInd;
import graphics.leyout.views.ShapeNode;
import model.Order;

import java.util.ArrayList;

// Класс на удаление использовать CompositBoard
// Зависимости
// - BoardsController
// - EmployerCardController
// - GridMaterialLoader
// - Leyout
// - NodeMemory
// - ShapeConvier

public class GroupBoard extends Group implements Infoable {
    CompositBoardController controller;
    Rectangle selRect;
    //TODO: Сделать полноценное условие
    String condition;     //Условие
    ShapeNode nEnt;       //Точка старта (входа)
    ShapeNode nExt;       //Точка выхода
    SimpleIntegerProperty x;
    SimpleIntegerProperty y;
    SimpleDoubleProperty a;
    WorkPlaceController hc;
    BoardController bc;
    ShapeBoardInd sbi;
    GridController gc;

//    TODO: Класс нуждается в чистке
    public GroupBoard(int id, String dsc, int size, int x, int y, double a, int ind) {
        //id - номер доски
        //dsc - описание
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
        this.a = new SimpleDoubleProperty(a);       //a - угол
//        hc = new WorkPlaceController();
//        bc = new BoardController(id, dsc, size);
        sbi = new ShapeBoardInd(ind);              //ind - индикатор
//        gc = new GridController(size);
        hc.view().relocate(size/2-10, 7);
        bc.view().relocate(0, 25);
        sbi.relocate(size-5, 7);


        //Selected rectangle

        this.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.isControlDown()) {
                if (selRect == null) {
                    Bounds bounds = this.localToScreen(this.getBoundsInLocal());           //Границы текущего элемента
                    selRect = new Rectangle(0, 0, bounds.getWidth(), bounds.getHeight());
                    selRect.setStyle("-fx-fill: RGBA(255,255,255,.3); -fx-stroke: RGBA(82,79,161,0.4); -fx-stroke-width: 0.5");
                }
                if (!this.getChildren().contains(selRect)) {
                    this.getChildren().add(selRect);
                } else {
                    this.getChildren().remove(selRect);
                }
            } else {

            }
        });


        System.out.println("" + id + " " + dsc + " " + this.x.get() + " " + this.y.get());

//        sg = new GridView(size);


        //node start
//        nEnt = new ShapeNode(this);
//        nEnt.relocate(0, 16);
//        nEnt.setOnMouseClicked(mouseEvent -> {
//            MouseButton button = mouseEvent.getButton();
//            if (button == MouseButton.PRIMARY) {
//                CanbanController cc = CanbanController.getInstance();
//                for (String s : gc.getMaterial()) {
//                    for (ShapeNode ext : cc.getExt(s)) {
//                        new ShapeConnection(nEnt.getX(), nEnt.getY(), ext.getX(), ext.getY());
//                        ext.getOwner().showInfo();
//                    }
//
//                }
//            } else{
//                GroupLine.getInstance().rem();
//                System.out.println("MouseLeft");
//            }
//        });
//
//        node end
//        nExt = new ShapeNode(this);
//        nExt.relocate(size - 5, 16);

//        this.getChildren().addAll(sbi, bc.view(), hc.view(), gc.view(), nEnt, nExt);
//        this.relocate(x, y);
//        this.setRotate(a);

    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public ShapeNode getEnt() {
        return nEnt;
    }

    public ShapeNode getExt() {
        return nExt;
    }

//    public void setLoginning(int EmployerId){
//        hc.setLogining(EmployerId);
//    }

    public ArrayList<Order> getOrd() {
        return sbi.getOrd();
    }

    public void setOrd(ArrayList<Order> ord) {
        sbi.setOrd(ord);
    }


//    TODO либо лишнее либо надо реализовать.
    public void select() {
//        bs1.select();
    }

    public void unselect() {
//        bs1.unseltct();
    }

    public String getDescription(){
//        return bs1.getDescription();
        return ((Board)bc.component()).getTitle();

    }

    public ArrayList<String> getMaterial() {
        return gc.getMaterial();
    }

    public void setMaterial(ArrayList<String> material) {
////        sg.setMaterials(material);
//        gc.setMaterial(material);
////        TODO: создаются узлы которые переполняют память
////        for (String m: material) {
////            nEnt.addNode(new ShapeNode(this));
////        }
    }



}
