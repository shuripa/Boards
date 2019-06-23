package leyout.groups.test;


import javafx.scene.input.MouseButton;
import leyout.LeyoutComponentWiev;
import leyout.controllers.CanbanController;
import leyout.controllers.GridController;
import leyout.groups.GroupLine;
import leyout.wievs.ShapeConnection;
import leyout.wievs.ShapeNode;

public class CompositBoardWiev extends LeyoutComponentWiev {

    public CompositBoardWiev(CompositBoardController controller, int size, int x, int y, double a){
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
    public void getElements() {
        this.getChildren().add(((CompositBoardController)controller).getHumanShape());
        this.getChildren().add(((CompositBoardController)controller).getGridShape());
        this.getChildren().add(((CompositBoardController)controller).getBoardShape());
        this.getChildren().add(((CompositBoardController)controller).getBoardIndex());
    }

    @Override
    protected void paint() {

    }

    @Override
    public void reset() {

    }

    @Override
    public void emplacement(int size) {
        ((CompositBoardController)controller).getHumanShape().relocate(size/2-10, 7);
        ((CompositBoardController)controller).getBoardShape().relocate(0, 25);
        ((CompositBoardController)controller).getBoardIndex().relocate(size-5, 7);
    }

    @Override
    public void showInfo() {

    }
}