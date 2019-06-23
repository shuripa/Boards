package leyout.controllers;

import leyout.LeyoutComponentController;
import leyout.elements.BoardIndex;
import leyout.wievs.BoardIndexWiev;
import model.Order;

public class BoardIndexController extends LeyoutComponentController {

    public BoardIndexController(LeyoutComponentController parent, int proc){
        super(parent);
        element = new BoardIndex(this);
        ((BoardIndex)element).setProc(proc);
        wiev = new BoardIndexWiev(this);
    }

    public int getProc() {
        return ((BoardIndex)element).getProc();
    }

    public void addOrder(Order order) {
        ((BoardIndex)element).addOrder(order);
    }


}
