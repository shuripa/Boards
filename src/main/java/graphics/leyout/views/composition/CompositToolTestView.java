package graphics.leyout.views.composition;

import graphics.leyout.controllers.CompositToolController;
import graphics.leyout.controllers.LeyoutWorkPlacedController;
import javafx.scene.shape.Rectangle;

public class CompositToolTestView extends CompositToolView {
    public CompositToolTestView(LeyoutWorkPlacedController controller) {
        super(controller);
    }

    @Override
    public void paint() {
        this.getChildren().add(((CompositToolController)controller()).getToolController().view());
        this.getChildren().add(((CompositToolController)controller()).getWorkPlaceController().view());
        this.getChildren().add(((CompositToolController)controller()).getProductionPlaceController().view());
//        this.getChildren().add(((CompositToolController)controller()).getWorkTableController().view());
        this.getChildren().add(((CompositToolController)controller()).getMaterialPlaceController().view());
    }

    @Override
    public void repaint() {
        ((CompositToolController)controller()).getToolController().setXYAS(32, 22, 0, controller().S());
        ((CompositToolController)controller()).getToolController().view().update();
        ((CompositToolController)controller()).getWorkPlaceController().setXY(22 + controller().S()/2, 2);
        ((CompositToolController)controller()).getWorkPlaceController().view().update();
        ((CompositToolController)controller()).getProductionPlaceController().setXY(34 + controller().S(), 12);
        ((CompositToolController)controller()).getProductionPlaceController().view().update();
//        ((CompositToolController)controller()).getWorkTableController().setXY(20, 1);
//        ((CompositToolController)controller()).getWorkTableController().view().update();
        ((CompositToolController)controller()).getMaterialPlaceController().setXY(0, 22);
        ((CompositToolController)controller()).getMaterialPlaceController().view().update();
    }
}
