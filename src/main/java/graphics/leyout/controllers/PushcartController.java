package graphics.leyout.controllers;

import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.views.PushcartView;
import javafx.scene.input.MouseButton;

import java.io.IOException;

public class PushcartController extends LeyoutComponentController {

    public PushcartController(LeyoutComponent component) throws IOException {
        super(component);
        setView(new PushcartView(this));
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
