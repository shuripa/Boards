package graphics.leyout.views;

import graphics.leyout.controllers.LeyoutWorkPlacedController;

public abstract class LeyoutWorkPlacedView extends LeyoutComponentView {
    public LeyoutWorkPlacedView(LeyoutWorkPlacedController controller) {
        super(controller);
    }

    @Override
    public abstract void paint();

    @Override
    public abstract void repaint();

//    @Override
//    public void exited() {
//        if (isActivate() == false) {
//            super.exited();
//        } else {
//            super.exited(((LeyoutWorkPlacedController)controller()).getPriority());
//        }
//    }

}
