package leyout.controllers;

import leyout.components.BoardIndex;
import leyout.views.BoardIndexView;
import model.Order;

public class BoardIndexController extends LeyoutComponentController {

    public BoardIndexController(LeyoutComponentController parent, int proc){
        super(parent);
        component = new BoardIndex(this);
        ((BoardIndex) component).setProc(proc);
        view = new BoardIndexView(this);
    }

    public int getProc() {
        return ((BoardIndex) component).getProc();
    }

    public void addOrder(Order order) {
        ((BoardIndex) component).addOrder(order);
    }


}
