package graphics.leyout.views;

import graphics.leyout.controllers.CompositManagerTableController;
import graphics.leyout.controllers.LeyoutComponentController;
import graphics.leyout.controllers.component.WorkPlaceController;

public class CompositManagerTableView extends LeyoutComponentView {
    CompositManagerTableController tcontroller;
    WorkPlaceController workPlaceController;

    public CompositManagerTableView(LeyoutComponentController controller) {
        super(controller);
        tcontroller = (CompositManagerTableController)controller();
        workPlaceController = tcontroller.getWorkPlaceController();
    }

    @Override
    public void paint() {

        switch (tcontroller.getSide()){
            case DOWN: workPlaceController.setXYAS(10,25, 0, 0); break;
            case UP: workPlaceController.setXYAS(10,25, -180, 0); break;
            case UP_LEFT: workPlaceController.setXYAS(15,30, -195, 0); break;
            case UP_RIGHT: workPlaceController.setXYAS(10,23, -165, 0); break;
        }


//        ((CompositManagerTableController)controller()).getWorkPlaceController().setXYAS(30,30, 0, 0);

        this.getChildren().add(((CompositManagerTableController)controller()).getManagerTableController().view());
        this.getChildren().add(((CompositManagerTableController)controller()).getWorkPlaceController().view());

    }

    @Override
    public void repaint() {
        switch (tcontroller.getSide()){
            case DOWN: workPlaceController.setXYAS(10,25, 0, 0); break;
            case UP: workPlaceController.setXYAS(10,25, -180, 0); break;
            case UP_LEFT: workPlaceController.setXYAS(15,30, -195, 0); break;
            case UP_RIGHT: workPlaceController.setXYAS(10,23, -165, 0); break;
        }
    }
}
