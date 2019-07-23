package graphics.leyout.controllers;

import javafx.scene.input.MouseButton;
import graphics.leyout.components.BoardIndex;
import graphics.leyout.views.BoardIndexView;
import model.Order;

import java.io.IOException;

public class BoardIndexController extends LeyoutComponentController {

    public BoardIndexController() throws IOException {
        setView(new BoardIndexView(this));
    }

    public BoardIndexController(BoardIndex index) throws IOException {
        super(index);
        setView(new BoardIndexView(this));
    }

    public int getProc() {
        return ((BoardIndex) component()).getProc();
    }

    private void setProc() {
        ((BoardIndexView)view()).setLimit(getProc());
    }

    private void setText() {
        String text = "" + ((BoardIndex)component()).getEffectivityShift() + "%";
        ((BoardIndexView)view()).setText(text);
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
    public void updateViewData() {

        setProc();
        setText();
    }

    @Override
    protected void setDragEvent() {
    }
}