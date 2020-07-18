package graphics.leyout.components;

import graphics.GraphicsElement;
import graphics.leyout.controllers.LeyoutCompositController;
import model.Condition;

import java.io.IOException;
import java.util.ArrayList;

public abstract class LeyoutComponent {

//    TODO: оставлен для совместимости - удалить
    private ArrayList<LeyoutComponent> leafs;
    private ArrayList<GraphicsElement> controllerObservers;
    private ArrayList<LeyoutComponent> componentObservers;
    private ArrayList<LeyoutCompositController> recreateControllers;
    private LeyoutComponent parent;
    private ArrayList<Condition> conditions;
    private int posCount;

    private boolean active;


//    private ArrayList <Node> nodes;         //Элементы управления

//    public ShapeNode nEnt;                     //Точка входа
//    public ShapeNode nExt;                     //Точка выхода

    public LeyoutComponent() {
        this.parent = null;
        this.controllerObservers = new ArrayList<>();
        this.componentObservers = new ArrayList<>();
        this.leafs = new ArrayList<>();
        this.conditions = new ArrayList<>();
        this.recreateControllers = new ArrayList<>();              //Для компонентов которые пересоздаются
//        nodes = new ArrayList<>();
    }

    public void setParent(LeyoutComponent parent){
        this.parent = parent;
    }

    public LeyoutComponent parent(){
        return this.parent;
    }


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public void addControllerObserver(GraphicsElement observer){
        this.controllerObservers.add(observer);
    }

    public void delControllerObsetver(GraphicsElement observer){
        this.controllerObservers.remove(observer);
    }

    public void addComponentObserver(LeyoutComponent observer){
        this.componentObservers.add(observer);
    }

    public void delComponentObsetver (LeyoutComponent observer){
        this.componentObservers.remove(observer);
    }

    public ArrayList<GraphicsElement> getObservers () {
        return controllerObservers;
    }

    /** Leafs */

    public int leafsLenght() {
        return leafs.size();
    }

    public void addLeaf(LeyoutComponent leaf) {
        if (!leafs.contains(leaf)) {
            leafs.add(leaf);
        }
    }

    public void addLeafs(LeyoutComponent ... leafs){
        for (LeyoutComponent l: leafs) {
            addLeaf(l);
        }
    }

    public void delLeaf(LeyoutComponent leaf){
        if (leafs.contains(leaf)){
            leafs.remove(leaf);
        }
    }

    public LeyoutComponent getLeaf (int i){
        return leafs.get(i);
    }

//    Удалить
    public void addCondition (Condition condition){
        conditions.add(condition);
    }
//    Удалить
    public ArrayList<Condition> getConditions (){
        return conditions;
    }


    public void update() {
        for (LeyoutComponent lc: leafs){
            lc.update();
        }
        for (LeyoutComponent lc:componentObservers) {
            lc.update();
        }
        for (GraphicsElement gc: controllerObservers) {
            gc.update();
        }
    }

    protected void recreateControllers() throws IOException {
//        После пересоздания компонента нужно также пересоздать контроллер
//        recreateControllers - cпециальный массив для контроллера композита который умеет пересоздаваться.
//        Запускает процедуру create() в контроллере
        for (LeyoutCompositController controller: recreateControllers) {
            controller.create();
        }
    }

    public void addRecreateObservers(LeyoutCompositController controller){
        recreateControllers.add(controller);
    }

    @Override
    public abstract String toString();

}
