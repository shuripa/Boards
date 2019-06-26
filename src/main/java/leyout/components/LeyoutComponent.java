package leyout.components;

import leyout.controllers.LeyoutComponentController;

import java.util.ArrayList;

public abstract class LeyoutComponent {

//    TODO: оставлен для совместимости - удалить
    private ArrayList<LeyoutComponentController> observers;

    private ArrayList<LeyoutComponent> leafs;
    private int posCount;

//    private ArrayList <Node> nodes;         //Элементы управления
//    public ShapeNode nEnt;                     //Точка входа
//    public ShapeNode nExt;                     //Точка выхода



    public LeyoutComponent() {
        observers = new ArrayList<>();
        leafs = new ArrayList<>();
//        nodes = new ArrayList<>();
    }


//    private void createNodes() {
//        //node start
//        nEnt = new ShapeNode(this);
//        nEnt.relocate(0, 16);
//        nEnt.setOnMouseClicked(mouseEvent -> {
//            MouseButton button = mouseEvent.getButton();
//            setEventTonExt(button);
//        });
//
//        //node end
//        nExt = new ShapeNode(this);
//        nExt.relocate(controller.getS() - 5, 16);
//        this.getChildren().addAll(nEnt, nExt);
//
//    }

//    public void addNode (Node node){
//        this.nodes.add(node);
//        this.getChildren().add(node);
//    }

    public void addObserver(LeyoutComponentController observer){
        this.observers.add(observer);
    }

    public void delObsetver (LeyoutComponent observer){
        this.observers.remove(observer);
    }

    public void update(){
        for (LeyoutComponentController lcc: observers) {
            lcc.update();
        }
    }


    @Override
    public abstract String toString();


    /** Leafs */

    public int leafsLenght() {
        return leafs.size();
    }

    public void addLeaf(LeyoutComponent leaf) {
        leafs.add(leaf);
    }

    public LeyoutComponent getLeaf (int i){
        return leafs.get(i);
    }

}
