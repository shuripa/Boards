package graphics.leyout.controllers;

import javafx.scene.input.MouseButton;
import graphics.leyout.views.BoardView;
import graphics.leyout.components.Board;

import java.io.IOException;

public class BoardController extends LeyoutComponentController {

    public BoardController () throws IOException {
        setView(new BoardView(this));
    }

    public BoardController (Board board) throws IOException {
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
        setIntProperty(((Board)component()).idProperty());
        setStrProperty(((Board)component()).titleProperty());
        setStrProperty(((Board)component()).conditionProperty());
    }

    @Override
    protected void setEventTonExt(MouseButton button) {

    }

    @Override
    public void updateViewData() {
        ((BoardView)view()).setTt(getTitle());
        ((BoardView)view()).setTi("" + getId());
    }

    @Override
    protected void setDragEvent() {

    }

//В контроллерах нет необходимости дублировать toString. Функциональность реализована на уровне суперклассов.

}