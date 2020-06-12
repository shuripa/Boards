package graphics.leyout.controllers;

import graphics.leyout.components.CompositLeaderTable;
import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.components.WorkPlacedComposit;
import graphics.leyout.controllers.component.WorkPlaceController;
import graphics.leyout.views.CompositLeaderTableView;
import inout.CompositBuilder;
import model.Side;

import java.io.IOException;


public class CompositLeaderTableController extends LeyoutWorkPlacedController {

    public CompositLeaderTableController(CompositLeaderTable component) throws IOException {
        super(component);
        addLeaf(new WorkPlaceController(component.getWorkPlace()));
        addLeaf(new LeaderTableController(component.getManagerTable(), this));
        setView(new CompositLeaderTableView(this));
    }

    public CompositLeaderTableController(LeyoutComponent component, CompositBuilder builder) throws IOException {
        super((CompositLeaderTable)component);
        addLeaf(new WorkPlaceController(((CompositLeaderTable)component).getWorkPlace()));
        addLeaf(new LeaderTableController(((CompositLeaderTable)component).getManagerTable(), this));
        setView(new CompositLeaderTableView(this));
        setXYAS(builder.getX(), builder.getY(), builder.getA(), builder.getS());
    }

    public WorkPlaceController getWorkPlaceController() {
        return (WorkPlaceController) getLeaf(0);
    }

    public LeaderTableController getLeaderTableController() {
        return (LeaderTableController) getLeaf(1);
    }

    public Side getSide (){
        return ((WorkPlacedComposit)component()).getWorkPlace().getSide();
    }


    @Override
    protected void setComponentProperties() {

    }


}
