package leyout.controllers;

import leyout.LeyoutComponentController;
import leyout.wievs.ShapeHuman;
import leyout.elements.Human;

public class HumanController extends LeyoutComponentController {

    public HumanController(){
//        initialize(this, new Human(), new ShapeHuman());
//        setController(this);
        element = new Human(this);
        wiev = new ShapeHuman(this);
    }

    public Integer getId() {
        return ((Human)element).getLogined();
    }

//    TODO: Не используется
    public boolean isLogined() {
        return ((Human)element).isLogined();
    }

    public void setLogining(int employerId) {
        ((Human)element).setLogining(employerId);
        ((ShapeHuman) wiev).reset();
        wiev.requestLayout();
    }

    public String getText(){
        return ((Human)element).getText();
    }
}