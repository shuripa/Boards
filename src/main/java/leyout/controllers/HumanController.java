package leyout.controllers;

import leyout.views.ShapeHuman;
import leyout.components.Human;

public class HumanController extends LeyoutComponentController {

    public HumanController(){
//        initialize(this, new Human(), new ShapeHuman());
//        setController(this);
        component = new Human(this);
        view = new ShapeHuman(this);
        updateProperty();
    }

    public Integer getId() {
        return ((Human) component).getLogined();
    }

//    TODO: Не используется
    public boolean isLogined() {
        return ((Human) component).isLogined();
    }

    public void setLogining(int employerId) {
        ((Human) component).setLogining(employerId);
        ((ShapeHuman) view).reset();
        view.requestLayout();
    }

    public String getText(){
        return ((Human) component).getText();
    }
}