package graphics.controllers;

import javafx.scene.input.MouseButton;
import graphics.views.BoardView;
import graphics.components.Board;

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
        setIntProperty(((Board)component()).idProperty());
        setStrProperty(((Board)component()).titleProperty());
        setStrProperty(((Board)component()).conditionProperty());
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