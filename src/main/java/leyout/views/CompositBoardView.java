package leyout.views;


import javafx.scene.input.MouseButton;
import leyout.controllers.CanbanController;
import leyout.controllers.CompositBoardController;
import leyout.controllers.GridController;
import leyout.components.GroupLine;

public class CompositBoardView extends LeyoutComponentView {

    public CompositBoardView(CompositBoardController controller, int size, int x, int y, int a){
        super(controller, size, x ,y, a);
    }

    @Override
    protected void setEventTonExt(MouseButton button) {
        if (button == MouseButton.PRIMARY) {
            CanbanController cc = CanbanController.getInstance();
            for (String s : ((GridController)((CompositBoardController)controller).getGridController()).getMaterial()) {
                for (ShapeNode ext : cc.getExt(s)) {
                    new ShapeConnection(nEnt.getX(), nEnt.getY(), ext.getX(), ext.getY());
                    ext.getOwner().showInfo();
                }

            }
        } else{
            GroupLine.getInstance().rem();
            System.out.println("MouseLeft");
        }
    }

    @Override
    public void paint() {
        //Размещение компонентов
        ((CompositBoardController)controller).getHumanShape().relocate(size/2-10, 7);
        ((CompositBoardController)controller).getBoardShape().relocate(0, 25);
        ((CompositBoardController)controller).getBoardIndex().relocate(size-5, 7);
        //Добавление компонентов к лейауту
        this.getChildren().add(((CompositBoardController)controller).getHumanShape());
        this.getChildren().add(((CompositBoardController)controller).getGridShape());
        this.getChildren().add(((CompositBoardController)controller).getBoardShape());
        this.getChildren().add(((CompositBoardController)controller).getBoardIndex());
    }

    @Override
    public void reset() {

    }

    @Override
    public void showInfo() {

    }
}