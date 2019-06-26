package leyout.controllers;

import javafx.scene.input.MouseButton;
import leyout.components.BoardIndex;
import leyout.views.BoardIndexView;
import model.Order;

public class BoardIndexController extends LeyoutComponentController {

    public BoardIndexController(BoardIndex index){
        setComponent(index);
        setView(new BoardIndexView());
    }

    public int getProc() {
        return ((BoardIndex) component()).getProc();
    }

    public void addOrder(Order order) {
        ((BoardIndex) component()).addOrder(order);
    }


    @Override
    protected void setComponentProperties() {

    }

    @Override
    protected void setEventTonExt(MouseButton button) {

    }

    @Override
    public void update() {

    }
}
