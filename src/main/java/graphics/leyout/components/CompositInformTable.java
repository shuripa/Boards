package graphics.leyout.components;

import model.Profession;

public class CompositInformTable extends LeyoutComposit {
    InformTable informTable;
    WorkPlace workPlace;

    public CompositInformTable(String id, Profession profession) {
        super("", id);
        informTable = new InformTable(this);
        workPlace = new WorkPlace(this, profession);
        addLeafs(informTable, workPlace);
    }

    public InformTable getInformTable() {
        return informTable;
    }

    public WorkPlace getWorkPlace(){
        return workPlace;
    }

    @Override
    public String toString() {
        return "";
    }
}
