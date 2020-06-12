package graphics.leyout.views.tools;

import graphics.leyout.controllers.LeyoutComponentController;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class ToolBoardView extends ToolView {

    Rectangle rb;
    Line l;

    public ToolBoardView(LeyoutComponentController controller){
        super (controller);
        rb = new Rectangle(.5 ,.5, 55, 20);
        l = new Line(1, 9.5, 53, 9.5);
        addActiveElements(rb, l);
    }

    @Override
    public void paint(){
        ti.relocate(2,-5);
        tt.relocate(2,5);
        super.paint();
    }

    @Override
    public void repaint() {
        rb.setWidth(controller().S()-5);
        l.setEndX(controller().S()-5);
    }

}