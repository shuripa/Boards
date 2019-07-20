package graphics.leyout.components;

import model.Condition;

import java.util.ArrayList;

public class CompositBoard extends LeyoutComponent {
    Board b;
    WorkPlace wp;
    BoardIndex i;
    Grid g;

    public CompositBoard (){
        b = new Board();
        wp = new WorkPlace(this);
        g = new Grid();
        i = new BoardIndex(this);
        addLeafs(b, wp, g, i);
    }

    public Board getBoard() {
        return b;
    }

    public WorkPlace getWorkPlace() {
        return wp;
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
        wp.setEmployer(employer);
    }

    public void setProc(int proc) {
        i.setProc(proc);
    }

    @Override
    public String toString() {
        return "";
    }
}
