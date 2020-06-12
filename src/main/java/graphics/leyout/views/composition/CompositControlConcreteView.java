package graphics.leyout.views.composition;

import graphics.leyout.controllers.CompositControlController;
import graphics.leyout.controllers.LeyoutWorkPlacedController;

public class CompositControlConcreteView extends CompositControlView {

    public CompositControlConcreteView(LeyoutWorkPlacedController controller) {
        super(controller);
    }

    @Override
    public void paint() {
        ((CompositControlController)controller()).getControlController().setXY(0,0);
        this.getChildren().add(((CompositControlController)controller()).getControlController().view());
    }

    @Override
    public void repaint() {

    }
}
