package leyout.controllers;

import leyout.LeyoutComponentController;
import leyout.wievs.BoardView;
import leyout.elements.Board;

public class BoardController extends LeyoutComponentController {

    public BoardController(int id, String title, int size) {
        element = new Board(this, id, title);
        wiev = new BoardView(this, size);
    }

    public int getId() {
        return ((Board)element).getId();
    }

    public String getTitle() {
        return ((Board)element).getTitle();
    }

    public void setCondition(String condition) {
        ((Board)element()).setCondition(condition);
    }

    public void setID(int id) {
        ((Board)element()).setID(id);
        wiev.reset();
    }

    public void setTitle(String title) {
        ((Board)element()).setTitle(title);
//        ((BoardView)wiev).setTt(title);
        wiev.reset();
    }


//TODO: В контроллерах нет необходимости дублировать toString. Функциональность реализована на уровне суперклассов.
//    public String toString(){
//        return ((Board)element).toString();
//    }
}