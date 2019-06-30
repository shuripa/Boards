package graphics.views;

import javafx.scene.shape.Rectangle;
import graphics.controllers.LeyoutComponentController;


public class GridView extends LeyoutComponentView {
    Rectangle rb, rl, rr;

    public GridView(LeyoutComponentController controller) {
        super(controller);
    }

    @Override
    public void paint(){
        rb = new Rectangle(60,5);       //rectangle centr
        rb.relocate(.5,1.5);
        rl = new Rectangle(5,7);      //rectangle left
        rl.relocate(5,.5);
        rr = new Rectangle(5,7);      //rectangle right
        rr.relocate(50,.5);
        addActiveElements(rb, rl, rr);
    }

    @Override
    public void repaint() {
        rb.setWidth(controller().getS());
        rr.relocate(controller().getS()-10, .5);
    }

}
