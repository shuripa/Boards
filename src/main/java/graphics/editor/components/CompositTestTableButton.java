package graphics.editor.components;

import graphics.leyout.components.CompositTestTable;
import graphics.leyout.controllers.CompositTestTableController;
import graphics.leyout.controllers.LeyoutComponentController;

import java.io.IOException;

public class CompositTestTableButton extends EditorButton {
    public CompositTestTableButton() {
        super("CompositTestTableButton");
    }


    @Override
    public LeyoutComponentController createComponent() throws IOException {
        CompositTestTable component = new CompositTestTable();
        CompositTestTableController controller = new CompositTestTableController(component);
        controller.setS(60);
        return controller;
    }
}
