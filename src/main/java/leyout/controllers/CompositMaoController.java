package leyout.controllers;

import javafx.scene.input.MouseButton;
import leyout.components.CompositMao;
import leyout.views.CompositMaoView;

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
