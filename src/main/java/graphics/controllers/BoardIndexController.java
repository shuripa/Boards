package graphics.controllers;

import javafx.scene.input.MouseButton;
import graphics.components.BoardIndex;
import graphics.views.BoardIndexView;
import model.Order;

public class BoardIndexController extends LeyoutComponentController {

    public BoardIndexController(BoardIndex index){
        super(index);
        setView(new BoardIndexView(this));
    }

    public int getProc() {
        return ((BoardIndex) component()).getProc();
    }

    public void setProc() {
        ((BoardIndexView)view()).setLimit(getProc());
    }

    public void addOrder(Order order) {
        ((BoardIndex) component()).addOrder(order);
    }


    @Override
    protected void setComponentProperties() {
        setIntProperty(((BoardIndex)component()).procProperty());
    }

    @Override
    protected void setEventTonExt(MouseButton button) {

    }

    @Override
    public void updateData() {
        setProc();
    }
}
