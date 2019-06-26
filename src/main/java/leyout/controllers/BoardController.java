package leyout.controllers;

import javafx.scene.input.MouseButton;
import leyout.views.BoardView;
import leyout.components.Board;

public class BoardController extends LeyoutComponentController {

    public BoardController (Board board){
        setComponent(board);
        setView(new BoardView());
        view().setController(this);
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

    }

    @Override
    protected void setEventTonExt(MouseButton button) {

    }

    @Override
    public void update() {

    }


//TODO: В контроллерах нет необходимости дублировать toString. Функциональность реализована на уровне суперклассов.
//    public String toString(){
//        return ((Board)component).toString();
//    }
}