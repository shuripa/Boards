package graphics.leyout.controllers;

import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.views.InformTableView;
import javafx.scene.input.MouseButton;

import java.io.IOException;

public class InformTableController extends LeyoutComponentController {

    @Deprecated
    public InformTableController(LeyoutComponent component) throws IOException {
        super(component);
        setView(new InformTableView(this));
    }

    public InformTableController(LeyoutComponent component, LeyoutCompositController parent) throws IOException {
        super(component);
        setParent(parent);
        setView(new InformTableView(this));
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
}
