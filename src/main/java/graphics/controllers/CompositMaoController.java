package graphics.controllers;

import javafx.scene.input.MouseButton;
import graphics.components.CompositMao;
import graphics.views.CompositMaoView;

public class CompositMaoController extends LeyoutComponentController {

    public CompositMaoController(CompositMao cm){
        super(cm);
        setView(new CompositMaoView(this));
    }

    public void setTitle(String s) {
        ((CompositMao)component()).setTitle(s);
    }

    @Override
    protected void setComponentProperties() {
        setStrProperty(((CompositMao)component()).titleProperty());
    }

    @Override
    public void updateData() {

    }

    @Override
    protected void setEventTonExt(MouseButton button) {
        
    }

}
