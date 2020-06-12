package graphics.leyout.views.controls;

import graphics.leyout.controllers.LeyoutComponentController;
import graphics.leyout.views.LeyoutComponentView;

public abstract class ControlView extends LeyoutComponentView {

    public ControlView(LeyoutComponentController controller){
        super (controller);
    }

    @Override
    public abstract void paint();

    @Override
    public abstract void repaint();

}