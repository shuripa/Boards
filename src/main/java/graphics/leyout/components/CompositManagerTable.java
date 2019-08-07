package graphics.leyout.components;

import model.Profession;
import model.Side;

public class CompositManagerTable extends WorkPlacedComposit {

    ManagerTable mt;
    WorkPlace wp;


    public CompositManagerTable(String id, Side side, Profession profession) {
        setId(id);
        mt = new ManagerTable(this, side);
        wp = new WorkPlace(this, profession, side);
        addLeafs(mt, wp);
    }

    public ManagerTable getManagerTable(){
        return mt;
    }

    @Override
    public WorkPlace getWorkPlace(){
        return wp;
    }

    @Override
    public double getEffectivity() {
        return 100;
    }

    @Override
    public int getCountFreeWorkPlace() {
        return (wp.isLogined()) ? 0 : 1;
    }

    @Override
    public String toString() {
        return "";
    }
}
