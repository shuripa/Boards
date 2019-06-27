package leyout.views;


import leyout.controllers.CompositBoardController;
import leyout.controllers.LeyoutComponentController;

public class CompositBoardView extends LeyoutComponentView {

    public CompositBoardView(LeyoutComponentController controller) {
        super(controller);
    }

    @Override
    public void paint() {
        //Размещение компонентов
        ((CompositBoardController)controller()).getHumanShape().relocate(controller().getS()/2-10, 7);
        ((CompositBoardController)controller()).getBoardShape().relocate(0, 25);
        ((CompositBoardController)controller()).getBoardIndex().relocate(controller().getS()-5, 7);
        //Добавление компонентов к лейауту
        this.getChildren().add(((CompositBoardController)controller()).getHumanShape());
        this.getChildren().add(((CompositBoardController)controller()).getGridShape());
        this.getChildren().add(((CompositBoardController)controller()).getBoardShape());
        this.getChildren().add(((CompositBoardController)controller()).getBoardIndex());
    }

    @Override
    public void repaint() {

    }

}