package graphics.leyout.components;

import model.Condition;
import model.Employer;
import model.Profession;

import java.util.ArrayList;

public class CompositTestTable extends WorkPlacedComposit {
    TestTable ttable;
    WorkPlace wplace;
    Palette palette;
    TestWorkTable workTable;
    TestCanban canban;
//    int step;


    public CompositTestTable(){
//        step = 120;
        ttable = new TestTable();
        wplace = new WorkPlace(this, Profession.TESTER);
        palette = new Palette();
        workTable = new TestWorkTable();
        canban = new TestCanban();
        addLeafs(ttable, wplace, palette, workTable, canban);
    }

    public TestTable getTestTable() {
        return ttable;
    }

    public WorkPlace getWorkPlace() {
        return wplace;
    }

    public Palette getPalette() {
        return palette;
    }

    public TestWorkTable getWorkTable() {
        return workTable;
    }

    public TestCanban getTestCanban() {
        return canban;
    }


    public void setTitle(String title){
        ttable.setTitle(title);
    }

    public String getTitle(){
        return ttable.getTitle();
    }

    public void setId(String id){
        ttable.setId(id);
    }

    public String getId(){
        return ttable.getId();
    }

    public void logining(Employer employer){
        wplace.setEmployer(employer);
    }

    // Условия

    //TODO реализовать
    @Override
    public double getEffectivity() {
        return 100;
    }

    @Override
    public int getCountFreeWorkPlace() {
        return (getWorkPlace().isLogined()) ? 0 : 1;
    }


    @Override
    public String toString() {
        return "";
    }

    public void setCondition(String condition) {
        getTestTable().setCondition (new Condition ("MFC1847164***", 120));
    }

    public Condition getCondition(){
        return  ttable.getCondition();
    }

    public ArrayList<Condition> getConditions() {
        return ttable.getConditions();
    }

}
