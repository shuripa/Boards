package graphics.leyout.components;

import inout.CompositBuilder;
import model.Profession;

public class CompositInformTable extends WorkPlacedComposit {
    InformTable informTable;
    WorkPlace workPlace;

    //На етапі створення компоненту не відомо ні id ні proffession
    // TODO переробити id і proffession в властивості

    public CompositInformTable(String id, Profession profession) {
        super("", id);
        informTable = new InformTable(this);
        workPlace = new WorkPlace(this, profession);
        addLeafs(informTable, workPlace);
    }

    public CompositInformTable(CompositBuilder builder) {
        super("", "" + builder.getId());
        informTable = new InformTable(this);
        workPlace = new WorkPlace(this, Profession.valueOf(builder.getProfession()));
        addLeafs(informTable, workPlace);
    }

    public InformTable getInformTable() {
        return informTable;
    }

    public WorkPlace getWorkPlace(){
        return workPlace;
    }

    @Override
    public double getEffectivity() {
        return 100;
    }

    @Override
    public int getCountFreeWorkPlace() {
        return (workPlace.isLogined()) ? 0 : 1;
    }

    @Override
    public String toString() {
        return "";
    }
}
