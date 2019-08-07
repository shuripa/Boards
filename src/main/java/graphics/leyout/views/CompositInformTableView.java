package graphics.leyout.views;

import graphics.leyout.controllers.CompositInformTableController;
import graphics.leyout.controllers.LeyoutWorkPlacedController;
import graphics.leyout.controllers.WorkPlaceController;

public class CompositInformTableView extends LeyoutWorkPlacedView {
    LeyoutComponentView workPlaceView;
    LeyoutComponentView tableView;
    WorkPlaceController wpController;


    public CompositInformTableView(LeyoutWorkPlacedController controller) {
        super(controller);
        wpController = ((CompositInformTableController)controller()).getWorkPlaceController();
    }

    @Override
    public void paint() {

        workPlaceView = ((CompositInformTableController)controller()).getWorkPlaceController().view();
        workPlaceView.relocate(12, 0);
        tableView = ((CompositInformTableController)controller()).getInformTableController().view();
        tableView.relocate(0,20);
        getChildren().addAll(workPlaceView, tableView);
    }

    @Override
    public void repaint() {
        wpController.setXY(12, 0);
    }
}
