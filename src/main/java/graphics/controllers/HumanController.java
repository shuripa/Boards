package graphics.controllers;

import javafx.beans.property.IntegerProperty;
import javafx.scene.input.MouseButton;
import graphics.components.Human;
import graphics.views.HumanView;

import java.io.IOException;

public class HumanController extends LeyoutComponentController {

    public HumanController() throws IOException {
        setView(new HumanView(this));
    }

    public HumanController(Human human) throws IOException {
        super(human);
        setView(new HumanView(this));
    }

    public Integer getLogined() {
        return ((Human) component()).getLogined();
    }

    public String getText(){
        return ((Human) component()).getText();
    }

    public IntegerProperty property() {
        return  ((Human)component()).idProperty();
    }

    @Override
    protected void setDragEvent() {

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
    public void updateViewData() {
        ((HumanView)view()).setText("" + getLogined());
    }

}