package graphics.leyout.controllers;

import graphics.leyout.components.CanbanBoard;
import graphics.leyout.components.CanbanLeaf;
import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.views.CanbanBoardView;
import javafx.scene.input.MouseButton;

import java.io.IOException;

public class CanbanBoardController extends LeyoutComponentController {

    CanbanLeafController[] canbanLeafControllers;

    public CanbanBoardController(LeyoutComponent component) throws IOException {
        super(component);
        canbanLeafControllers = new CanbanLeafController[countLeaves()];
        for (int i = 0; i < countLeaves(); i++) {
            CanbanLeaf canbanLeaf = ((CanbanBoard)component()).getLeaf(i);
            canbanLeafControllers[i] = new CanbanLeafController(canbanLeaf);
            canbanLeafControllers[i].setXY( 3+(canbanLeaf.getMaxLeafCountOrder()*4+15)*i, 2);
        }
        setView(new CanbanBoardView(this));
    }

    public int countLeaves(){
        return ((CanbanBoard)component()).getCountLeaves();
    }

    public CanbanLeafController getLeafController(int i){
        return canbanLeafControllers[i];
    }

    @Override
    protected void setComponentProperties() {

    }

    @Override
    protected void setDragEvent() {

    }

    @Override
    protected void setEventTonExt(MouseButton button) {

    }

    @Override
    public void updateViewData() {
        for (int i = 0; i < countLeaves(); i++) {
            canbanLeafControllers[i].updateViewData();
        }
    }

    @Override
    public void select() {
        for (int i = 0; i < countLeaves(); i++) {
            canbanLeafControllers[i].select();
        }
    }

    @Override
    public void unselect(){
        for (int i = 0; i < countLeaves(); i++) {
            canbanLeafControllers[i].unselect();
        }
    }
}
