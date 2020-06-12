package graphics.leyout.views.composition;


import graphics.leyout.controllers.LeyoutWorkPlacedController;
import graphics.leyout.views.LeyoutWorkPlacedView;

public abstract class CompositControlView extends LeyoutWorkPlacedView {

    public CompositControlView(LeyoutWorkPlacedController controller) {
        super(controller);
    }

    @Override
    public abstract void paint();

    @Override
    public abstract void repaint();

}