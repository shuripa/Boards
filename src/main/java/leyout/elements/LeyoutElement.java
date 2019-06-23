package leyout.elements;

import leyout.controllers.LeyoutElementController;

public class LeyoutElement {
    protected LeyoutElementController controller;

    public LeyoutElement(LeyoutElementController controller){
        this.controller = controller;
    }

    public LeyoutElement() {

    }

    @Override
    public String toString() {
        return this.toString();
    }

    public void setController(LeyoutElementController controller) {
        this.controller = controller;
    }
}
