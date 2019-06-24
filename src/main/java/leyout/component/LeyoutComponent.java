package leyout.component;

import leyout.controllers.LeyoutComponentController;

public abstract class LeyoutComponent {
    protected LeyoutComponentController controller;

    public LeyoutComponent(LeyoutComponentController controller){
        this.controller = controller;
    }

    public LeyoutComponent() {

    }

    @Override
    public abstract String toString();

    public void setController(LeyoutComponentController controller) {
        this.controller = controller;
    }
}
