package graphics.leyout.controllers;

import graphics.leyout.components.CompositMao;
import graphics.leyout.views.CompositMaoView;
import javafx.scene.input.MouseButton;
import model.Condition;

import java.io.IOException;
import java.util.ArrayList;

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

    @Override
    public ArrayList<Condition> getConditions() {
        return null;
    }

}
