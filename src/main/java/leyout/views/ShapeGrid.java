package leyout.views;

import javafx.scene.shape.Rectangle;


public class ShapeGrid extends LeyoutComponentView {

    private Integer size;

    @Override
    public void paint(){
        Rectangle rb = new Rectangle(size,5);       //rectangle centr
        rb.relocate(.5,1.5);
        Rectangle rl = new Rectangle(5,7);      //rectangle left
        rl.relocate(5,.5);
        Rectangle rr = new Rectangle(5,7);      //rectangle right
        rr.relocate(size-10,.5);

        addActiveElements(rb, rl, rr);
    }

}
