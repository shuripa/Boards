package leyout.controllers;

import javafx.scene.input.MouseButton;
import leyout.components.Human;
import leyout.views.HumanView;

public class HumanController extends LeyoutComponentController {

    public HumanController(Human human){
        super(human);
        setView(new HumanView(this));
    }

    public Integer getLogined() {
        return ((Human) component()).getLogined();
    }

    public String getText(){
        return ((Human) component()).getText();
    }

    @Override
    protected void setComponentProperties() {
        setIntProperty(((Human)component()).idProperty());
    }

    @Override
    protected void setEventTonExt(MouseButton button) {

    }

    @Override
    public void updateData() {
        ((HumanView)view()).setText("" + getLogined());
    }

}