package graphics.editor.components;

import graphics.leyout.components.CompositMao;
import graphics.leyout.controllers.CompositMaoController;
import graphics.leyout.controllers.LeyoutComponentController;

import java.io.IOException;

public class CompositMaoButton extends EditorButton {
    public CompositMaoButton() {
        super("CompositMaoButton");
    }

    @Override
    public LeyoutComponentController createComponent() throws IOException {
        CompositMao component = new CompositMao();
//        component.setTitle("UO_MB12");
//        component.addCondition("MFC1802012***");
//        component.addCondition("MFC1802317***");
//        component.addCondition("MFC1847164***");
        CompositMaoController controller = new CompositMaoController(component);
        return controller;
    }
}
