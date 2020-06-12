package graphics.leyout.views.composition;


import graphics.leyout.controllers.LeyoutWorkPlacedController;
import graphics.leyout.views.LeyoutWorkPlacedView;

public abstract class CompositToolView extends LeyoutWorkPlacedView {

    public CompositToolView(LeyoutWorkPlacedController controller) {
        super(controller);
    }

    @Override
    public abstract void paint();

    @Override
    public abstract void repaint();

}