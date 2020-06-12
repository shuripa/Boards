package graphics.leyout.controllers;

import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.components.ManagerTable;
import graphics.leyout.components.WorkPlacedComposit;
import graphics.leyout.views.leaders.LeaderTableView;
import model.Profession;
import model.Side;

import java.io.IOException;

public class LeaderTableController extends LeyoutComponentController {

    public LeaderTableController(LeyoutComponent component, LeyoutCompositController parent) throws IOException {
        super(component);
        setParent(parent);
        setView(new LeaderTableView(this));
    }

    public Side getSide(){
        return ((ManagerTable)component()).getSide();
    }

    public Profession getProfession() {
        return ((WorkPlacedComposit)parent().component()).getWorkPlace().getProfession();
    }

    @Override
    protected void setComponentProperties() {

    }
}
