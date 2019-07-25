package graphics.leyout.views;

import javafx.scene.shape.Rectangle;
import graphics.leyout.controllers.LeyoutComponentController;


public class GridView extends LeyoutComponentView {
    Rectangle rb, rl, rr;

    public GridView(LeyoutComponentController controller) {
        super(controller);
        rb = new Rectangle(60, 5);  //rectangle centr
        rl = new Rectangle(5, 7);   //rectangle left
        rr = new Rectangle(5, 7);   //rectangle right
    }

    @Override
    public void paint(){
        rb.relocate(.5,1.5);
        rl.relocate(5,.5);
        rr.relocate(50,.5);
        addActiveElements(rb, rl, rr);
    }

    @Override
    public void repaint() {
        rb.setWidth(controller().S());
        rr.relocate(controller().S()-10, .5);
    }

}
