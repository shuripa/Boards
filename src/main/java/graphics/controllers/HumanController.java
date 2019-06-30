package graphics.controllers;

import javafx.scene.input.MouseButton;
import graphics.components.Human;
import graphics.views.HumanView;

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
        setStrProperty(((Human)component()).nameProperty());
        setStrProperty(((Human)component()).phoneProperty());
    }

    @Override
    protected void setEventTonExt(MouseButton button) {

    }

    @Override
    public void updateData() {
        ((HumanView)view()).setText("" + getLogined());
    }

}