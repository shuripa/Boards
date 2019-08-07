package graphics.leyout.controllers;

import graphics.leyout.components.Convier;
import graphics.leyout.views.ConvierView;

import java.io.IOException;

public class ConvierController extends LeyoutComponentController {

    public ConvierController(Convier component) throws IOException {
        super(component);
        setView(new ConvierView(this));
    }


    public int countPos(){
        return ((Convier)component()).getCountPos();
    }

    @Override
    protected void setComponentProperties() {

    }

}
