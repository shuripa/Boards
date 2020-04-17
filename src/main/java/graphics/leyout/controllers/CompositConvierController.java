package graphics.leyout.controllers;

import graphics.leyout.components.CompositBoard;
import graphics.leyout.components.CompositConvier;
import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.views.CompositConvierView;
import inout.CompositBuilder;

import java.io.IOException;

public class CompositConvierController extends LeyoutCompositController {

    ConvierController convierController;
    CompositBoardController[] compositBoardControllers;


    public CompositConvierController(CompositConvier component) throws IOException {
        super(component);
        component.addRecreateObservers(this);
        create();
    }

    public CompositConvierController(LeyoutComponent component, CompositBuilder builder) throws IOException{
        super(component);
        component.addRecreateObservers(this);
        create();
        setXYAS(builder.getX(), builder.getY(), builder.getA(), builder.getS());
    }

    @Override
    public void create() throws IOException {
        convierController = new ConvierController(((CompositConvier)component()).getConvier());
        convierController.setParent(this);
        setS(60);   //По замовчуванню розмір дошки
        int N = countPos();
        compositBoardControllers = new CompositBoardController[N];
        for (int i = 0; i < N; i++) {
            CompositBoard cb = ((CompositConvier) component()).getBoard(i);
            compositBoardControllers[i] = new CompositBoardController(cb);
            compositBoardControllers[i].setS(S());
            compositBoardControllers[i].setParent(this);
        }
        setView(new CompositConvierView(this));
    }

    public int countPos(){
        return ((CompositConvier)component()).getCntPos();
    }


    @Override
    protected void setComponentProperties() {
        setStrProperty (((CompositConvier)component()).titleProperty());
        setIntProperty(((CompositConvier)component()).cntPosProperty());
    }

    public ConvierController getConvierController() {
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
