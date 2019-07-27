package graphics.leyout.components;

import model.Profession;
import model.Side;

public class CompositManagerTable extends LeyoutComposit {

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
    public String toString() {
        return "";
    }
}
