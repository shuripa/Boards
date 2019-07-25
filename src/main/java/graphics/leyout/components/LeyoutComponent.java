package graphics.leyout.components;

import graphics.GraphicsController;
import model.Condition;
import model.Employer;

import java.util.ArrayList;

public abstract class LeyoutComponent {

//    TODO: оставлен для совместимости - удалить
    private ArrayList<LeyoutComponent> leafs;
    private ArrayList<GraphicsController> controllerObservers;
    private ArrayList<LeyoutComponent> componentObservers;
    private LeyoutComponent parent;
    private ArrayList<Condition> conditions;
    private int posCount;

    private String title;
    private String id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    private ArrayList <Node> nodes;         //Элементы управления
//    public ShapeNode nEnt;                     //Точка входа
//    public ShapeNode nExt;                     //Точка выхода



    public LeyoutComponent() {
        parent = null;
        controllerObservers = new ArrayList<>();
        componentObservers = new ArrayList<>();
        leafs = new ArrayList<>();
        conditions = new ArrayList<>();
//        nodes = new ArrayList<>();
    }

    public void setParent(LeyoutComponent parent){
        this.parent = parent;
    }

    public LeyoutComponent parent(){
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

    public void addControllerObserver(GraphicsController observer){
        this.controllerObservers.add(observer);
    }

    public void delControllerObsetver(GraphicsController observer){
        this.controllerObservers.remove(observer);
    }

    public void addComponentObserver(LeyoutComponent observer){
        this.componentObservers.add(observer);
    }

    public void delComponentObsetver (LeyoutComponent observer){
        this.componentObservers.remove(observer);
    }


    public ArrayList<GraphicsController> getObservers () {
        return controllerObservers;
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

    public void addCondition (Condition condition){
        conditions.add(condition);
    }

    public ArrayList<Condition> getConditions (){
        return conditions;
    }

    public void logining(Employer employer){
        WorkPlace wp = getWorkPlace();
        if (wp != null) {
            wp.setEmployer(employer);
//            update();
        }
    }

    public void update(){
        for (LeyoutComponent lc: leafs){
            lc.update();
        }
        for (LeyoutComponent lc:componentObservers) {
            lc.update();
        }
        for (GraphicsController gc: controllerObservers) {
            gc.update();
        }
    }

    public WorkPlace getWorkPlace() {
        return null;
    }

}
