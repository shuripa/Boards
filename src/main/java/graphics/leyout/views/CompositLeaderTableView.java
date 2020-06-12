package graphics.leyout.views;

import graphics.leyout.controllers.CompositLeaderTableController;
import graphics.leyout.controllers.LeyoutComponentController;
import graphics.leyout.controllers.component.WorkPlaceController;

public class CompositLeaderTableView extends LeyoutComponentView {
    CompositLeaderTableController tcontroller;
    WorkPlaceController workPlaceController;

    public CompositLeaderTableView(LeyoutComponentController controller) {
        super(controller);
        tcontroller = (CompositLeaderTableController)controller();
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

        this.getChildren().add(((CompositLeaderTableController)controller()).getLeaderTableController().view());
        this.getChildren().add(((CompositLeaderTableController)controller()).getWorkPlaceController().view());

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
