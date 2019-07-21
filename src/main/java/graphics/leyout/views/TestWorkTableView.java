package graphics.leyout.views;


import graphics.leyout.controllers.LeyoutComponentController;
import javafx.scene.shape.Rectangle;

public class TestWorkTableView extends LeyoutComponentView {

    public TestWorkTableView(LeyoutComponentController controller){
        super(controller);
    }

    public void paint() {
        //rc1
        Rectangle wt = new Rectangle(15, 20);
        wt.relocate(.5,.5);
        addActiveElement(wt);
    }

    @Override
    public void repaint() {

    }


}
