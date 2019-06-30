package graphics.views;


import graphics.controllers.CompositBoardController;
import graphics.controllers.LeyoutComponentController;

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
        ((CompositBoardController) controller()).getHumanController().setXY(controller().getS()/2-10, 7);
        ((CompositBoardController) controller()).getGridController().setS(controller().getS());
        ((CompositBoardController) controller()).getBoardController().setXYAS(0, 27, 0, controller().getS());
        ((CompositBoardController) controller()).getBoardIndexController().setXY(controller().getS()-5, 27);
    }

}