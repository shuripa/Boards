package leyout.controllers;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import leyout.components.LeyoutComponent;
import leyout.views.LeyoutComponentView;

import java.util.ArrayList;

public class LeyoutComponentController {
    public LeyoutComponent component;
    public LeyoutComponentView view;
    public LeyoutComponentController controller;
    public LeyoutComponentController parent;
    LeyoutComponentController[] leafs;
    private ArrayList<StringProperty> strProperties; // Строковые свойства
    private ArrayList<IntegerProperty> intProperties; // Строковые свойства

    int posCount;

    public LeyoutComponentController(){
        strProperties = new ArrayList<>();
        intProperties = new ArrayList<>();
    }

    public void updateProperty() {
        view().updateProperties();
        leafs = new LeyoutComponentController[4];
    }

    public LeyoutComponentController(LeyoutComponentController parent){
        this.parent = parent;
        strProperties = new ArrayList<>();
        intProperties = new ArrayList<>();
        leafs = new LeyoutComponentController[4];
    }

    public LeyoutComponentController(LeyoutComponent component, LeyoutComponentView view){
        this.component = component;
        this.view = view;
        this.controller = this;
//        System.out.println("Controller " + this.toString());
        leafs = new LeyoutComponentController[4];
        strProperties = new ArrayList<>();
        intProperties = new ArrayList<>();
//        TODO проверить!!!
//        component.setController(this);
//        view.setController(this);
    }


    /**    General */

    public void initialize(LeyoutComponentController controller, LeyoutComponent element, LeyoutComponentView wiev){
    this.component = element;
    this.view = wiev;
    setController(controller);
}

    public void activate() {
        view.activate();
    }

    public void setController(LeyoutComponentController controller) {
        this.controller = controller;
        component.setController(controller);
        view.setController(controller);
    }

    public Node getWievAsNode() {
        return view;
    }

    public LeyoutComponentView view(){
        return view;
    }

    public LeyoutComponentView getWievAsSuper(){
        return view;
    }

    public LeyoutComponent component(){
        return component;
    }

    public LeyoutComponentController controller() {
        return controller;
    }

    public LeyoutComponentController getParentController() {
        return parent;
    }



    /**    Composit */



    /**    Leaf */

    public void addLeafByIndex(LeyoutComponentController controller, int index) {
        if (index <= posCount) leafs[index] = controller;
    }

    public void addLeaf(LeyoutComponentController leaf) {
        int i = 0;
        while (leafs[i] != null){
            i++;
        }
        if (i == leafs.length) addLeafByIndex(leaf, leafsLenght()+1);
        else leafs[i] = leaf;
    }

    public int leafsLenght() {
        return leafs.length;
    }

    public void setPosCount(int posCount){
        this.posCount = posCount;
        LeyoutComponentController[] temp = leafs;
        leafs = new LeyoutComponentController[posCount];
        for (int i = 0; i < posCount; i++) {
            leafs[i] = temp[i];
        }
    }

    public LeyoutComponentController getLeaf(int i) {
        return leafs[i];
    }


    /** View*/

    public void setPosition(int x, int y, int angle, int size) {
        view().relocate(x, y);
        view().setRotate(angle);
    }

    public void relocate(int x, int y) {
        view.relocate(x, y);
    }

    public void setPositionArgs(int x, int y, int angle, int size) {
        view().relocate(x, y, angle);
        view().setSize(size);
    }

    /** Properties */

    public ArrayList<StringProperty> getStrProperties(){
        return strProperties;
    }

    public ArrayList<IntegerProperty> getIntProperties(){
        return intProperties;
    }


    /** Get String */

    @Override
    public String toString(){
        return component.toString();
    }

    public String getText(){
        return "0";
    }

    public void refresh() {
        view().refresh();
    }
}