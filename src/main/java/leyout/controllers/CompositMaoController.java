package leyout.controllers;

import leyout.components.CompositMao;
import leyout.views.CompositMaoView;

public class CompositMaoController extends LeyoutComponentController {

    public CompositMaoController(){
        super();
        component = new CompositMao(this);
        view = new CompositMaoView();
        view().setController(this);
        updateProperty();
    }

    public void setTitle(String s) {
        ((CompositMao)component).setTitle(s);
    }

    public void addCondition(String condition) {
        ((CompositMao)component()).addCondition(condition);
    }

}
