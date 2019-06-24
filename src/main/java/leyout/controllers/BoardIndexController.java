package leyout.controllers;

import leyout.component.BoardIndex;
import leyout.views.BoardIndexView;
import model.Order;

public class BoardIndexController extends LeyoutComponentController {

    public BoardIndexController(LeyoutComponentController parent, int proc){
        super(parent);
        element = new BoardIndex(this);
        ((BoardIndex)element).setProc(proc);
        wiev = new BoardIndexView(this);
    }

    public int getProc() {
        return ((BoardIndex)element).getProc();
    }

    public void addOrder(Order order) {
        ((BoardIndex)element).addOrder(order);
    }


}
