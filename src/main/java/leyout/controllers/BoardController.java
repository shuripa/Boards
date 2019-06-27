package leyout.controllers;

import javafx.scene.input.MouseButton;
import leyout.views.BoardView;
import leyout.components.Board;

public class BoardController extends LeyoutComponentController {

    public BoardController (Board board){
        super(board);
        setView(new BoardView(this));
    }

    public int getId() {
        return ((Board)component()).getId();
    }

    public String getTitle() {
        return ((Board)component()).getTitle();
    }

    public String getCondition (){
        return ((Board)component()).getCondition();
    }

    @Override
    protected void setComponentProperties() {
        setStrProperty(((Board)component()).titleProperty());
        setStrProperty(((Board)component()).conditionProperty());
        setIntProperty(((Board)component()).idProperty());
    }

    @Override
    protected void setEventTonExt(MouseButton button) {

    }

    @Override
    public void updateData() {
        ((BoardView)view()).setTt(getTitle());
        ((BoardView)view()).setTi("" + getId());
    }

//В контроллерах нет необходимости дублировать toString. Функциональность реализована на уровне суперклассов.

}