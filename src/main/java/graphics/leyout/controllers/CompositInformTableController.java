package graphics.leyout.controllers;

import graphics.leyout.components.CompositInformTable;
import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.controllers.component.WorkPlaceController;
import graphics.leyout.views.CompositInformTableView;
import inout.CompositBuilder;

import java.io.IOException;

public class CompositInformTableController extends LeyoutWorkPlacedController {

    public CompositInformTableController(CompositInformTable component) throws IOException {
        super(component);
        addLeaf(new WorkPlaceController(component.getWorkPlace()));
        addLeaf(new InformTableController(component.getInformTable(), this));
        setView(new CompositInformTableView(this));
    }

    public CompositInformTableController(LeyoutComponent component, CompositBuilder builder) throws IOException {
        super((CompositInformTable)component);
        addLeaf(new WorkPlaceController(((CompositInformTable)component).getWorkPlace()));
        addLeaf(new InformTableController(((CompositInformTable)component).getInformTable(), this));
        setView(new CompositInformTableView(this));
        setXYAS(builder.getX(), builder.getY(), builder.getA(), builder.getS());
    }

    public WorkPlaceController getWorkPlaceController(){
        return (WorkPlaceController) getLeaf(0);
    }

    public InformTableController getInformTableController(){
        return (InformTableController) getLeaf(1);
    }

    @Override
    protected void setComponentProperties() {

    }

}
