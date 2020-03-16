package graphics.leyout.controllers;

import graphics.leyout.components.BoardIndex;
import graphics.leyout.views.BoardIndexView;

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

    @Override
    protected void setComponentProperties() {
        setIntProperty(((BoardIndex)component()).procProperty());
    }

    @Override
    public void update() {
        setProc();
        super.update();
    }


}
