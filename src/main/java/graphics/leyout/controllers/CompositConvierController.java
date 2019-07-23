package graphics.leyout.controllers;

import graphics.leyout.components.CompositBoard;
import graphics.leyout.components.CompositConvier;
import graphics.leyout.views.CompositConvierView;
import javafx.scene.input.MouseButton;

import java.io.IOException;

public class CompositConvierController extends LeyoutComponentController {

    ConvierController convierController;
    CompositBoardController[] compositBoardControllers;


    public CompositConvierController(CompositConvier component) throws IOException {
        super(component);
        convierController = new ConvierController(((CompositConvier)component()).getConvier());
        compositBoardControllers = new CompositBoardController[countPos()];
        for (int i = 0; i < countPos(); i++) {
            CompositBoard cb = ((CompositConvier) component()).getBoard(i);
            compositBoardControllers[i] = new CompositBoardController(cb);
        }
        setView(new CompositConvierView(this));
    }

    public ConvierController getConvierController() {
        return convierController;
    }

    public CompositBoardController getCompositBoardController(int i){
        return compositBoardControllers[i];
    }

    public int countPos(){
        return ((CompositConvier)component()).getCountPos();
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
        convierController.updateViewData();
        for (int i = 0; i < countPos(); i++) {
            compositBoardControllers[i].updateViewData();
        }
    }

    @Override
    public void select() {
        convierController.select();
        for (int i = 0; i < countPos(); i++) {
            compositBoardControllers[i].select();
        }
    }

    @Override
    public void unselect(){
        convierController.unselect();
        for (int i = 0; i < countPos(); i++) {
            compositBoardControllers[i].unselect();
        }
    }
}
