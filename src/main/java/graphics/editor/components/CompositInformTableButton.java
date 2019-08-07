package graphics.editor.components;

import graphics.leyout.components.CompositInformTable;
import graphics.leyout.controllers.CompositInformTableController;
import graphics.leyout.controllers.LeyoutComponentController;
import model.Profession;

import java.io.IOException;

public class CompositInformTableButton extends EditorButton {
    public CompositInformTableButton() {
        super("CompositInformTableButton");
    }


    @Override
    public LeyoutComponentController createComponent() throws IOException {
        CompositInformTable component = new CompositInformTable("", Profession.BRIGADIER);
        CompositInformTableController controller = new CompositInformTableController(component);
        controller.setS(60);
        return controller;
    }
}
