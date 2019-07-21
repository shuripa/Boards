package graphics.leyout.controllers;

import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.views.TestWorkTableView;
import javafx.scene.input.MouseButton;

import java.io.IOException;

public class TestWorkTableController extends LeyoutComponentController {

    public TestWorkTableController(LeyoutComponent component) throws IOException {
        super(component);
        setView(new TestWorkTableView(this));
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
