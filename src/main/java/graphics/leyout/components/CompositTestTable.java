package graphics.leyout.components;

public class CompositTestTable extends LeyoutComponent{
    TestTable ttable;
    WorkPlace wplace;
    Palette palette;
    TestWorkTable workTable;
    TestCanban canban;

    public CompositTestTable(){
        ttable = new TestTable();
        wplace = new WorkPlace();
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

    public void setLogining(Employer employer){
        wplace.setEmployer(employer);
    }

    // Условия



    @Override
    public String toString() {
        return "";
    }
}
