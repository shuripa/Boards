package graphics.leyout.views;

import graphics.leyout.controllers.CompositTestTableController;
import graphics.leyout.controllers.LeyoutComponentController;

public class CompositTestView extends LeyoutComponentView {
    public CompositTestView(LeyoutComponentController controller) {
        super(controller);
    }

    @Override
    public void paint() {
        this.getChildren().add(((CompositTestTableController)controller()).getTestTableController().view());
        this.getChildren().add(((CompositTestTableController)controller()).getWorkPlaceController().view());
        this.getChildren().add(((CompositTestTableController)controller()).getPaletteController().view());
        this.getChildren().add(((CompositTestTableController)controller()).getWorkTableController().view());
        this.getChildren().add(((CompositTestTableController)controller()).getTestCanbanController().view());
    }

    @Override
    public void repaint() {
        ((CompositTestTableController)controller()).getTestTableController().setXYAS(32, 22, 0, controller().S());
        ((CompositTestTableController)controller()).getTestTableController().view().updateView();
        ((CompositTestTableController)controller()).getWorkPlaceController().setXY(22 + controller().S()/2, 4);
        ((CompositTestTableController)controller()).getWorkPlaceController().view().updateView();
        ((CompositTestTableController)controller()).getPaletteController().setXY(34 + controller().S(), 12);
        ((CompositTestTableController)controller()).getPaletteController().view().updateView();
        ((CompositTestTableController)controller()).getWorkTableController().setXY(20, 1);
        ((CompositTestTableController)controller()).getWorkTableController().view().updateView();
        ((CompositTestTableController)controller()).getTestCanbanController().setXY(0, 22);
        ((CompositTestTableController)controller()).getTestCanbanController().view().updateView();
    }
}
