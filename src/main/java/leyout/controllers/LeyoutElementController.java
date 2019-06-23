package leyout.controllers;

import javafx.scene.Node;
import leyout.elements.LeyoutElement;
import leyout.groups.test.LeyoutGroupController;
import leyout.wievs.LeyoutElementWiev;

public class LeyoutElementController {
    LeyoutElement element;
    LeyoutElementWiev wiev;
    LeyoutElementController controller;
    LeyoutGroupController parent;

    public LeyoutElementController(){
    }

    public LeyoutElementController(LeyoutGroupController parent){
        this.parent = parent;
    }

    public void initialize(LeyoutElementController controller, LeyoutElement element, LeyoutElementWiev wiev){
        this.element = element;
        this.wiev = wiev;
        setController(controller);
    }

    public void setController(LeyoutElementController controller) {
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

    public LeyoutElementWiev getWievAsSuper(){
        return wiev;
    }

    public LeyoutElement element(){
        return element;
    }

    public LeyoutGroupController getParentController() {
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