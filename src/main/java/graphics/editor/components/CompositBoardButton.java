package graphics.editor.components;

import graphics.leyout.components.CompositBoard;
import graphics.leyout.controllers.CompositBoardController;
import graphics.leyout.controllers.LeyoutComponentController;

import java.io.IOException;

public class CompositBoardButton extends EditorButton {

    public CompositBoardButton() {
        super("CompositBoardButton");
    }

    @Override
    public LeyoutComponentController createComponent() throws IOException {
        CompositBoard component = new CompositBoard();
        CompositBoardController controller = new CompositBoardController(component);
        controller.setS(60);
        return controller;
    }

}
