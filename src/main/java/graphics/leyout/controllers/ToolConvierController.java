package graphics.leyout.controllers;

import graphics.leyout.components.Convier;
import graphics.leyout.views.tools.ToolConvierView;
import graphics.leyout.views.tools.ToolView;

import java.io.IOException;

public class ToolConvierController extends LeyoutComponentController {

    public ToolConvierController(Convier component) throws IOException {
        super(component);
        setView(new ToolConvierView(this));
        ((ToolView)view()).setTi(component.getId());
        ((ToolView)view()).setTt(component.getTitle());
    }


    public int countPos(){
        return ((Convier)component()).getCountPos();
    }

    @Override
    protected void setComponentProperties() {

    }

}
