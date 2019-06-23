package leyout;

public class LeyoutComponent {
    protected LeyoutComponentController controller;

    public LeyoutComponent(LeyoutComponentController controller){
        this.controller = controller;
    }

    public LeyoutComponent() {

    }

    @Override
    public String toString() {
        return this.toString();
    }

    public void setController(LeyoutComponentController controller) {
        this.controller = controller;
    }
}
