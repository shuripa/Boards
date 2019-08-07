package graphics.leyout.controllers;

import graphics.leyout.components.Board;
import graphics.leyout.views.BoardView;

import java.io.IOException;

public class BoardController extends LeyoutComponentController {

    public BoardController () throws IOException {
        setView(new BoardView(this));
    }

    public BoardController (Board board) throws IOException {
        super(board);
        setView(new BoardView(this));
    }

    public BoardController (Board board, LeyoutCompositController parent) throws IOException {
        super(board);
        setParent(parent);
        setView(new BoardView(this));
    }

    public String getId() {
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
        setStrProperty(((Board)component()).idProperty());
        setStrProperty(((Board)component()).titleProperty());
        setStrProperty(((Board)component()).conditionProperty());
    }

    @Override
    public void update() {
        ((BoardView)view()).setTt(getTitle());
        ((BoardView)view()).setTi("" + getId());
        super.update();
    }



//В контроллерах нет необходимости дублировать toString. Функциональность реализована на уровне суперклассов.

}