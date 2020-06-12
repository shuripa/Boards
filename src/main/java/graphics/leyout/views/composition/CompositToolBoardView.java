package graphics.leyout.views.composition;


import graphics.leyout.controllers.CompositToolController;
import graphics.leyout.controllers.LeyoutWorkPlacedController;

public class CompositToolBoardView extends CompositToolView {

    public CompositToolBoardView(LeyoutWorkPlacedController controller) {
        super(controller);
    }

    @Override
    public void paint() {
        //Размещение компонентов
//        ((CompositBoardController)controller()).getHumanView().relocate(controller().getS()/2-10, 7);
//        ((CompositBoardController)controller()).getBoardView().relocate(0, 25);
//        ((CompositBoardController) controller()).getBoardController().setXYAS(0, 27, 0, controller().getS());
//        ((CompositBoardController)controller()).getBoardIndexView().relocate(controller().getS()-5, 7);
        //Добавление компонентов к лейауту
        this.getChildren().add(((CompositToolController)controller()).getToolController().view());
        this.getChildren().add(((CompositToolController)controller()).getMaterialPlaceController().view());
        this.getChildren().add(((CompositToolController)controller()).getProductionPlaceController().view());
//        this.getChildren().add(((CompositToolController)controller()).getBoardIndexView());
//        this.getChildren().add(((CompositToolController)controller()).getEffectivityIndexView());
        this.getChildren().add(((CompositToolController)controller()).getWorkPlaceController().view());
        this.getChildren().add(((CompositToolController)controller()).getInstructionsController().view());
    }

    @Override
    public void repaint() {
        ((CompositToolController) controller()).getWorkPlaceController().setXY(controller().S()/2-10, 7);
        ((CompositToolController) controller()).getWorkPlaceController().view().update();
        ((CompositToolController) controller()).getMaterialPlaceController().setS(controller().S());
        ((CompositToolController) controller()).getMaterialPlaceController().view().update();
        ((CompositToolController) controller()).getToolController().setXYAS(0, 27, 0, controller().S());
        ((CompositToolController) controller()).getToolController().view().update();
        ((CompositToolController) controller()).getProductionPlaceController().setXYAS(controller().S()-18, 8, 0, 0);
        ((CompositToolController) controller()).getInstructionsController().setXYAS(0, 8, 0, 0);

//        ((CompositToolController) controller()).getBoardIndexController().setXY(controller().S()-30, 12);
//        ((CompositToolController) controller()).getBoardIndexController().view().update();
//        ((CompositToolController) controller()).getEffectivityIndexController().setXY(controller().S()-27, 22);
//        ((CompositToolController) controller()).getEffectivityIndexController().view().update();
    }

}