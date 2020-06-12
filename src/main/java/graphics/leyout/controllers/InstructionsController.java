package graphics.leyout.controllers;

import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.views.instruction.InstructionView;

import java.io.IOException;

public class InstructionsController extends LeyoutComponentController {

    public InstructionsController(LeyoutComponent component) throws IOException {
        super(component);
        setView(new InstructionView(this));
    }

    @Override
    protected void setComponentProperties()  {

    }
}
