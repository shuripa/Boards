package graphics.leyout.controllers;

import graphics.leyout.components.CompositMao;
import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.views.CompositMaoView;
import inout.CompositBuilder;
import model.Condition;

import java.io.IOException;
import java.util.ArrayList;

public class CompositMaoController extends LeyoutCompositController {

    public CompositMaoController(CompositMao cm) throws IOException {
        super(cm);
        setView(new CompositMaoView(this));
    }

    public CompositMaoController(LeyoutComponent cm, CompositBuilder builder) throws IOException {
        super(cm);
        setView(new CompositMaoView(this));
        setXYAS(builder.getX(), builder.getY(), builder.getA(), builder.getS());
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
