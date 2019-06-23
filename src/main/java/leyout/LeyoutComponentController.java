package leyout;

import javafx.scene.Node;

public class LeyoutComponentController {
    public LeyoutComponent element;
    public LeyoutComponentWiev wiev;
    public LeyoutComponentController controller;
    public leyout.LeyoutComponentController parent;

    public LeyoutComponentController(){
    }

    public LeyoutComponentController(leyout.LeyoutComponentController parent){
        this.parent = parent;
    }

    public void initialize(LeyoutComponentController controller, LeyoutComponent element, LeyoutComponentWiev wiev){
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

    public LeyoutComponentWiev getWievAsSuper(){
        return wiev;
    }

    public LeyoutComponent element(){
        return element;
    }

    public leyout.LeyoutComponentController getParentController() {
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