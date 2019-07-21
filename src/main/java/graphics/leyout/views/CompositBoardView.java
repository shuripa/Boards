package graphics.leyout.views;


import graphics.leyout.controllers.CompositBoardController;
import graphics.leyout.controllers.LeyoutComponentController;

public class CompositBoardView extends LeyoutComponentView {

    public CompositBoardView(LeyoutComponentController controller) {
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
    }

    @Override
    public void repaint() {
        ((CompositBoardController) controller()).getHumanController().setXY(controller().S()/2-10, 7);
        ((CompositBoardController) controller()).getHumanController().view().updateView();
        ((CompositBoardController) controller()).getGridController().setS(controller().S());
        ((CompositBoardController) controller()).getGridController().view().updateView();
        ((CompositBoardController) controller()).getBoardController().setXYAS(0, 27, 0, controller().S());
        ((CompositBoardController) controller()).getBoardController().view().updateView();
        ((CompositBoardController) controller()).getBoardIndexController().setXY(controller().S()-30, 12);
        ((CompositBoardController) controller()).getBoardIndexController().view().updateView();
    }

}