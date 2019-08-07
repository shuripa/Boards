package graphics.leyout.controllers;

import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.views.TestWorkTableView;

import java.io.IOException;

public class TestWorkTableController extends LeyoutComponentController {

    public TestWorkTableController(LeyoutComponent component) throws IOException {
        super(component);
        setView(new TestWorkTableView(this));
    }

    @Override
    protected void setComponentProperties() {

    }

}
