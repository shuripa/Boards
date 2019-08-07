package graphics.leyout.components;

import model.Condition;
import model.Profession;

import java.util.ArrayList;

public class CompositBoard extends WorkPlacedComposit {
    Board b;
    WorkPlace wp;
    BoardIndex i;
    Grid g;
    int step;

    public CompositBoard (){
        super();
        step =110;
        b = new Board();
        wp = new WorkPlace(this, Profession.BINDER);
        g = new Grid();
        i = new BoardIndex(this);
        wp.addComponentObserver(i);
        addLeafs(b, wp, g, i);
    }

    public Board getBoard() {
        return b;
    }

    @Override
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

    public void setId(String boardId) {
        b.setId(boardId);
    }

    public String getId(){
        return b.getId();
    }

    public void setCondition(String condition) {
        b.setCondition(condition);
    }

    public void setCondition(Condition condition){
        b.setCondition(condition);
    }

    public String getCondition (){
        return b.getCondition();
    }

    @Override
    public ArrayList<Condition> getConditions() {
        return b.getConditions();
    }

//    public void action(Employer employer) {
//        getWorkPlace().setEmployer(employer);
//        update();
//        getBoardIndex().updateData();
//    }

//    @Override
//    public void update(){
//        b.update();
//        wp.update();
//        i.update();
//        g.update();
//        super.update();
//    }

    public void setProc(int proc) {
        i.setProc(proc);
    }

    @Override
    public double getEffectivity() {
        return (i != null) ? getBoardIndex().getEffectivityShift() : 0;
    }

    @Override
    public int getCountFreeWorkPlace() {

        return wp == null || !wp.isLogined() ? 1 : 0;
    }

    @Override
    public String toString() {
        return "";
    }

}

