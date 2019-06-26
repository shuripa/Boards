package leyout.controllers;

import javafx.scene.input.MouseButton;
import leyout.views.ShapeHuman;
import leyout.components.Human;

public class HumanController extends LeyoutComponentController {

    public HumanController(Human human){
        setComponent(human);
        setView(new ShapeHuman(this));
    }

    public Integer getId() {
        return ((Human) component()).getLogined();
    }

    @Override
    protected void setComponentProperties() {

    }

    public String getText(){
        return ((Human) component()).getText();
    }

    @Override
    protected void setEventTonExt(MouseButton button) {

    }

    @Override
    public void update() {

    }
}