package leyout.controllers;

import leyout.views.BoardView;
import leyout.components.Board;

public class BoardController extends LeyoutComponentController {

    public BoardController(int id, String title, int size) {
        component = new Board(this, id, title);
        view = new BoardView(this, size);
    }

    public int getId() {
        return ((Board) component).getId();
    }

    public String getTitle() {
        return ((Board) component).getTitle();
    }

    public void setCondition(String condition) {
        ((Board) component()).setCondition(condition);
    }

    public void setID(int id) {
        ((Board) component()).setID(id);
        view.reset();
    }

    public void setTitle(String title) {
        ((Board) component()).setTitle(title);
//        ((BoardView)view).setTt(title);
        view.reset();
    }

    public String getCondition (){
        return ((Board)component()).getCondition();
    }


//TODO: В контроллерах нет необходимости дублировать toString. Функциональность реализована на уровне суперклассов.
//    public String toString(){
//        return ((Board)component).toString();
//    }
}