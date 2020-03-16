package graphics.leyout.views;


import graphics.leyout.controllers.CompositBoardController;
import graphics.leyout.controllers.LeyoutWorkPlacedController;

public class CompositBoardView extends LeyoutWorkPlacedView {

    public CompositBoardView(LeyoutWorkPlacedController controller) {
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
        this.getChildren().add(((CompositBoardController)controller()).getHumanView());
        this.getChildren().add(((CompositBoardController)controller()).getGridShapeView());
        this.getChildren().add(((CompositBoardController)controller()).getBoardView());
        this.getChildren().add(((CompositBoardController)controller()).getBoardIndexView());
        this.getChildren().add(((CompositBoardController)controller()).getEffectivityIndexView());
    }

    @Override
    public void repaint() {
        ((CompositBoardController) controller()).getWorkPlaceController().setXY(controller().S()/2-10, 7);
        ((CompositBoardController) controller()).getWorkPlaceController().view().update();
        ((CompositBoardController) controller()).getGridController().setS(controller().S());
        ((CompositBoardController) controller()).getGridController().view().update();
        ((CompositBoardController) controller()).getBoardController().setXYAS(0, 27, 0, controller().S());
        ((CompositBoardController) controller()).getBoardController().view().update();
        ((CompositBoardController) controller()).getBoardIndexController().setXY(controller().S()-30, 12);
        ((CompositBoardController) controller()).getBoardIndexController().view().update();
        ((CompositBoardController) controller()).getEffectivityIndexController().setXY(controller().S()-27, 22);
        ((CompositBoardController) controller()).getEffectivityIndexController().view().update();
    }

}