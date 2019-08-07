package graphics.leyout.controllers;

import graphics.leyout.components.BoardIndex;
import graphics.leyout.components.WorkPlacedComposit;
import graphics.leyout.views.BoardIndexView;
import model.Order;

import java.io.IOException;

public class BoardIndexController extends LeyoutComponentController {

    @Deprecated
    public BoardIndexController() throws IOException {
        setView(new BoardIndexView(this));
    }

    public BoardIndexController(BoardIndex index) throws IOException {
        super(index);
        setView(new BoardIndexView(this));
//        (index.parent()).getWorkPlace().addControllerObserver(this);
    }

    public int getProc() {
        return ((BoardIndex) component()).getProc();
    }

    private void setProc() {
        ((BoardIndexView)view()).setLimit(getProc());
    }

    private void setText() {
        String text;
        if (((WorkPlacedComposit)component().parent()).getWorkPlace().isLogined()) {
            text = "" + ((BoardIndex)component()).getEffectivityShift() + "%";
        } else {
            text = "0.0%";
        }
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
    public void update() {
        setProc();
        setText();
        super.update();
    }


}
