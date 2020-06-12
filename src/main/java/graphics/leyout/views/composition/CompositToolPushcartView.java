package graphics.leyout.views.composition;

import graphics.leyout.controllers.CompositRelocationController;
import graphics.leyout.controllers.LeyoutWorkPlacedController;

public class CompositToolPushcartView extends CompositRelocationView {

    public CompositToolPushcartView(LeyoutWorkPlacedController controller) {
        super(controller);
    }

    @Override
    public void paint() {
        ((CompositRelocationController)controller()).getRelocationController().setXY(0,20);
        ((CompositRelocationController)controller()).getWorkPlaceController().setXY(5,0);
        this.getChildren().add(((CompositRelocationController)controller()).getRelocationController().view());
        this.getChildren().add(((CompositRelocationController)controller()).getWorkPlaceController().view());
    }

    @Override
    public void repaint() {

    }
}
