package graphics.editor.components;

import graphics.leyout.components.KanbanBoard;
import graphics.leyout.controllers.KanbanBoardController;
import graphics.leyout.controllers.LeyoutComponentController;

import java.io.IOException;

public class CompositCanbanButton extends EditorButton{
    public CompositCanbanButton() {
        super("CompositCanbanButton");
    }


    @Override
    public LeyoutComponentController createComponent() throws IOException {
        KanbanBoard component = new KanbanBoard();
        KanbanBoardController controller = new KanbanBoardController(component);
        return controller;
    }
}
