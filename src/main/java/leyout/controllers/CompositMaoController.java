package leyout.controllers;

import javafx.scene.input.MouseButton;
import leyout.components.CompositMao;
import leyout.views.CompositMaoView;

public class CompositMaoController extends LeyoutComponentController {

    public CompositMaoController(CompositMao cm){
        setComponent(cm);
        setView(new CompositMaoView());
        view().setController(this);
        cm.addObserver(this);
    }

    public void setTitle(String s) {
        ((CompositMao)component()).setTitle(s);
    }

    @Override
    protected void setComponentProperties() {
        setStrProperty(((CompositMao)component()).titleProperty());
    }

    @Override
    protected void setEventTonExt(MouseButton button) {
        
    }

    @Override
    public void update() {
        view().transform();
    }
}
