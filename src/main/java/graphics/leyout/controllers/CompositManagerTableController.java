package graphics.leyout.controllers;

import graphics.leyout.components.CompositManagerTable;
import graphics.leyout.components.WorkPlacedComposit;
import graphics.leyout.views.CompositManagerTableView;
import model.Side;

import java.io.IOException;


public class CompositManagerTableController extends LeyoutWorkPlacedController {

    public CompositManagerTableController(CompositManagerTable component) throws IOException {
        super(component);
        addLeaf(new WorkPlaceController(component.getWorkPlace()));
        addLeaf(new ManagerTableController(component.getManagerTable(), this));
        setView(new CompositManagerTableView(this));

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
