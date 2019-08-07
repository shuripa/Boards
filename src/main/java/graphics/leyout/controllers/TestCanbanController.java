package graphics.leyout.controllers;

import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.views.TestCanbanView;

import java.io.IOException;

public class TestCanbanController extends LeyoutComponentController {

    public TestCanbanController(LeyoutComponent component) throws IOException {
        super(component);
        setView(new TestCanbanView(this));
    }

    @Override
    protected void setComponentProperties() {

    }

}
