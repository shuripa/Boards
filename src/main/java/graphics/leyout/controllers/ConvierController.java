package graphics.leyout.controllers;

import graphics.leyout.components.Convier;
import graphics.leyout.views.ConvierView;
import javafx.scene.input.MouseButton;

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

    @Override
    public void updateViewData() {

    }

    @Override
    protected void setDragEvent() {

    }

    @Override
    protected void setEventTonExt(MouseButton button) {

    }
}
