package graphics.leyout.views;

import graphics.leyout.controllers.CompositPushcartController;
import graphics.leyout.controllers.LeyoutComponentController;

public class CompositPushcartView extends LeyoutComponentView {

    public CompositPushcartView(LeyoutComponentController controller) {
        super(controller);
    }

    @Override
    public void paint() {
        ((CompositPushcartController)controller()).getPushcartController().setXY(0,20);
        ((CompositPushcartController)controller()).getWorkPlaceController().setXY(5,0);
        this.getChildren().add(((CompositPushcartController)controller()).getPushcartController().view());
        this.getChildren().add(((CompositPushcartController)controller()).getWorkPlaceController().view());
    }

    @Override
    public void repaint() {

    }
}
