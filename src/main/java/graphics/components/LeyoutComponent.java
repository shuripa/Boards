package graphics.components;

import graphics.controllers.LeyoutComponentController;

import java.util.ArrayList;

public abstract class LeyoutComponent {

//    TODO: оставлен для совместимости - удалить
    private ArrayList<LeyoutComponentController> observers;

    private ArrayList<LeyoutComponent> leafs;
    private int posCount;
    private LeyoutComponent parent;

//    private ArrayList <Node> nodes;         //Элементы управления
//    public ShapeNode nEnt;                     //Точка входа
//    public ShapeNode nExt;                     //Точка выхода



    public LeyoutComponent() {
        parent = null;
        observers = new ArrayList<>();
        leafs = new ArrayList<>();
//        nodes = new ArrayList<>();
    }

    public void setParent(LeyoutComponent parent){
        this.parent = parent;
    }

    public LeyoutComponent getParent(){
        return this.parent;
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

    public ArrayList<LeyoutComponentController> getObservers () {
        return observers;
    }

    public void update(){
        for (LeyoutComponentController lcc: observers) {
            lcc.updateViewData();
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

    public void addLeafs(LeyoutComponent ... leafs){
        for (LeyoutComponent l: leafs) {
            addLeaf(l);
        }
    }

    public LeyoutComponent getLeaf (int i){
        return leafs.get(i);
    }

}
