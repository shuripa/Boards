package graphics.leyout.controllers;

import graphics.leyout.components.*;
import graphics.leyout.views.composition.CompositToolConvierView;
import inout.CompositBuilder;

import java.io.IOException;

public class CompositToolConvierController extends LeyoutWorkPlacedController {

    ToolConvierController convierController;
    CompositBoardController[] compositBoardControllers;


    public CompositToolConvierController(CompositToolConvier component) throws IOException {
        super(component);
        component.addRecreateObservers(this);
        create();
    }

    public CompositToolConvierController(LeyoutComponent component, CompositBuilder builder) throws IOException{
        super((WorkPlacedComposit) component);
        component.addRecreateObservers(this);
        create();
        setXYAS(builder.getX(), builder.getY(), builder.getA(), builder.getS());
    }

    @Override
    public void create() throws IOException {
        convierController = new ToolConvierController(((CompositToolConvier)component()).getConvier());
        convierController.setParent(this);
        setS(60);   //По замовчуванню розмір дошки
        int N = countPos();
        compositBoardControllers = new CompositBoardController[N];
        for (int i = 0; i < N; i++) {
            CompositBoard cb = ((CompositToolConvier) component()).getBoard(i);
            compositBoardControllers[i] = new CompositBoardController(cb);
            compositBoardControllers[i].setS(S());
            compositBoardControllers[i].setParent(this);
        }
        setView(new CompositToolConvierView(this));
    }

    public int countPos(){
        return ((CompositToolConvier)component()).getCntPos();
    }


    @Override
    protected void setComponentProperties() {
        setStrProperty (((CompositToolConvier)component()).titleProperty());
        setIntProperty(((CompositToolConvier)component()).cntPosProperty());
    }

    public ToolConvierController getConvierController() {
        return convierController;
    }

    public CompositBoardController getCompositBoardController(int i){
        return compositBoardControllers[i];
    }


    @Override
    public void update(String propertyName) throws IOException {
        if (propertyName == "Count pos") {
            delView(view());
            ((CompositConvier)component()).update();
            view().relocate(X(), Y());
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
