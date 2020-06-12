package graphics.leyout.views.instruction;

import graphics.leyout.controllers.LeyoutComponentController;
import graphics.leyout.views.LeyoutComponentView;
import javafx.scene.shape.Rectangle;

public class InstructionView extends LeyoutComponentView {

    Rectangle rb;

    public InstructionView(LeyoutComponentController controller){
        super (controller);
        rb = new Rectangle( 0,0, 15, 5);
        addActiveElements(rb);
    }

    @Override
    public void paint(){

    }

    @Override
    public void repaint() {
    }

}