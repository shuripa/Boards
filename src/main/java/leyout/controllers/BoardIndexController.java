package leyout.controllers;

import leyout.elements.BoardIndex;
import leyout.groups.test.LeyoutGroupController;
import leyout.wievs.BoardIndexWiev;
import model.Order;

public class BoardIndexController extends LeyoutElementController{

    public BoardIndexController(LeyoutGroupController parent, int proc){
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
