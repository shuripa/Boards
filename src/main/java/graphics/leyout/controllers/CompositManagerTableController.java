package graphics.leyout.controllers;

import graphics.leyout.components.CompositManagerTable;
import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.components.WorkPlacedComposit;
import graphics.leyout.controllers.component.WorkPlaceController;
import graphics.leyout.views.CompositManagerTableView;
import inout.CompositBuilder;
import model.Side;

import java.io.IOException;


public class CompositManagerTableController extends LeyoutWorkPlacedController {

    public CompositManagerTableController(CompositManagerTable component) throws IOException {
        super(component);
        addLeaf(new WorkPlaceController(component.getWorkPlace()));
        addLeaf(new ManagerTableController(component.getManagerTable(), this));
        setView(new CompositManagerTableView(this));
    }

    public CompositManagerTableController(LeyoutComponent component, CompositBuilder builder) throws IOException {
        super((CompositManagerTable)component);
        addLeaf(new WorkPlaceController(((CompositManagerTable)component).getWorkPlace()));
        addLeaf(new ManagerTableController(((CompositManagerTable)component).getManagerTable(), this));
        setView(new CompositManagerTableView(this));
        setXYAS(builder.getX(), builder.getY(), builder.getA(), builder.getS());
    }

    public WorkPlaceController getWorkPlaceController() {
        return (WorkPlaceController) getLeaf(0);
    }

    public ManagerTableController getManagerTableController() {
        return (ManagerTableController) getLeaf(1);
    }

    public Side getSide (){
        return ((WorkPlacedComposit)component()).getWorkPlace().getSide();
    }


    @Override
    protected void setComponentProperties() {

    }


}
