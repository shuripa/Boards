package leyout.controllers;

import javafx.scene.Node;
import leyout.views.LeyoutComponentView;
import leyout.component.LeyoutComponent;

public class LeyoutComponentController {
    public LeyoutComponent element;
    public LeyoutComponentView wiev;
    public LeyoutComponentController controller;
    public LeyoutComponentController parent;

    public LeyoutComponentController(){
    }

    public LeyoutComponentController(LeyoutComponentController parent){
        this.parent = parent;
    }

    public void initialize(LeyoutComponentController controller, LeyoutComponent element, LeyoutComponentView wiev){
        this.element = element;
        this.wiev = wiev;
        setController(controller);
    }

    public void setController(LeyoutComponentController controller) {
        this.controller = controller;
        element.setController(controller);
        wiev.setController(controller);
    }

    public Node getWievAsNode() {
        return wiev;
    }

    public void activate() {
        wiev.activate();
    }

    public void relocate(int x, int y) {
        wiev.relocate(x, y);
    }

    public LeyoutComponentView getWievAsSuper(){
        return wiev;
    }

    public LeyoutComponent element(){
        return element;
    }

    public LeyoutComponentController getParentController() {
        return parent;
    }

    @Override
    public String toString(){
        return element.toString();
    }

    public String getText(){
        return "0";
    }
}