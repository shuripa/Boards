package graphics.leyout.controllers;

import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.components.Tool;
import graphics.leyout.views.PushcartView;

import java.io.IOException;

public class RelocationController extends LeyoutComponentController {

    public RelocationController(LeyoutComponent component) throws IOException {
        super(component);
        setView(new PushcartView(this));
    }

    public RelocationController(Tool tool, CompositRelocationController parent, String toolViewType) throws IOException {
        super(tool);
        setParent(parent);
        setView(new PushcartView(this));
    }

    @Override
    protected void setComponentProperties() {

    }

    public String getId() {
        return "";
    }

    public String getTitle() {
        return "";
    }
}
