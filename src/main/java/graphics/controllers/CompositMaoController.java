package graphics.controllers;

import graphics.components.CompositMao;
import graphics.views.CompositMaoView;
import javafx.scene.input.MouseButton;

import java.io.IOException;

public class CompositMaoController extends LeyoutComponentController {

    public CompositMaoController(CompositMao cm) throws IOException {
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
    public void updateViewData() {

    }

    @Override
    protected void setDragEvent() {

    }

    @Override
    protected void setEventTonExt(MouseButton button) {
        
    }

}
