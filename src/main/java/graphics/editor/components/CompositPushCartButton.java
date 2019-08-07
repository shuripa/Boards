package graphics.editor.components;

import graphics.leyout.components.CompositPushcart;
import graphics.leyout.controllers.CompositPushcartController;
import graphics.leyout.controllers.LeyoutComponentController;

import java.io.IOException;

public class CompositPushCartButton extends EditorButton {
    public CompositPushCartButton() {
        super("CompositPushCartButton");
    }


    @Override
    public LeyoutComponentController createComponent() throws IOException {
        CompositPushcart component = new CompositPushcart("");
        CompositPushcartController controller = new CompositPushcartController(component);
        controller.setS(60);
        return controller;
    }
}
