package graphics.editor.components;

import graphics.leyout.components.CanbanBoard;
import graphics.leyout.controllers.CanbanBoardController;
import graphics.leyout.controllers.LeyoutComponentController;

import java.io.IOException;

public class CompositCanbanButton extends EditorButton{
    public CompositCanbanButton() {
        super("CompositCanbanButton");
    }


    @Override
    public LeyoutComponentController createComponent() throws IOException {
        CanbanBoard component = new CanbanBoard(10, 6);
        CanbanBoardController controller = new CanbanBoardController(component);
        return controller;
    }
}
