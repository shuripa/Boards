package graphics.editor.components;

import graphics.leyout.components.CompositManagerTable;
import graphics.leyout.controllers.CompositManagerTableController;
import graphics.leyout.controllers.LeyoutComponentController;
import model.Profession;
import model.Side;

import java.io.IOException;

public class CompositManagerTableButton extends EditorButton{

    public CompositManagerTableButton() {
        super("CompositManagerTableButton");
    }


    @Override
    public LeyoutComponentController createComponent() throws IOException {
        CompositManagerTable component = new CompositManagerTable("", Side.UP_LEFT, Profession.MASTER);
        CompositManagerTableController controller = new CompositManagerTableController(component);
        return controller;
    }
}
