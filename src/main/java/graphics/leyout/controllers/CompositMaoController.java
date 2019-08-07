package graphics.leyout.controllers;

import graphics.leyout.components.CompositMao;
import graphics.leyout.views.CompositMaoView;
import model.Condition;

import java.io.IOException;
import java.util.ArrayList;

public class CompositMaoController extends LeyoutCompositController {

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
    public ArrayList<Condition> getConditions() {
        return null;
    }

}
