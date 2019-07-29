package graphics.leyout.views;

import graphics.leyout.controllers.CompositInformTableController;
import graphics.leyout.controllers.LeyoutComponentController;

public class CompositInformTableView extends LeyoutComponentView {
    LeyoutComponentView workPlaceView;
    LeyoutComponentView tableView;

    public CompositInformTableView(LeyoutComponentController controller) {
        super(controller);
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
        workPlaceView.relocate(12, 0);
        tableView.relocate(0,20);
    }
}
