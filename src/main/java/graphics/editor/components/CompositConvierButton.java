package graphics.editor.components;

import graphics.leyout.components.CompositConvier;
import graphics.leyout.controllers.CompositConvierController;
import graphics.leyout.controllers.LeyoutComponentController;

import java.io.IOException;

public class CompositConvierButton extends EditorButton {
    public CompositConvierButton() {
        super("CompositConvierButton");
    }

    @Override
    public LeyoutComponentController createComponent() throws IOException {
        CompositConvier component = new CompositConvier();
        CompositConvierController controller = new CompositConvierController(component);
        controller.setS(60);
        return controller;
    }
}
