package graphics.components;

import model.Condition;

import java.util.ArrayList;

public class CompositBoard extends LeyoutComponent {
    Board b;
    Human h;
    BoardIndex i;
    Grid g;

    public CompositBoard (){
        b = new Board();
        h = new Human();
        g = new Grid();
        i = new BoardIndex(this);
        addLeafs(b, h, g, i);
    }

    public Board getBoard() {
        return b;
    }

    public Human getHuman() {
        return h;
    }

    public BoardIndex getBoardIndex(){
        return i;
    }

    public Grid getGrid(){
        return g;
    }

    public void setTitle(String title) {
        b.setTitle(title);
    }

    public String getTitle (){
        return b.getTitle();
    }

    public void setId(int boardId) {
        b.setId(boardId);
    }

    public void setCondition(String condition) {
        b.setCondition(condition);
    }

    public String getCondition (){
        return b.getCondition();
    }

    @Override
    public ArrayList<Condition> getConditions() {
        return b.getConditions();
    }

    public void setLogining(Employer employer) {
        h.setLogining(employer);
    }

    public void setProc(int proc) {
        i.setProc(proc);
    }

    @Override
    public String toString() {
        return "";
    }
}
