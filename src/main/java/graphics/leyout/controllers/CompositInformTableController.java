package graphics.leyout.controllers;

import graphics.leyout.components.CompositInformTable;
import graphics.leyout.views.CompositInformTableView;
import javafx.scene.input.MouseButton;

import java.io.IOException;

public class CompositInformTableController extends LeyoutCompositController {

    public CompositInformTableController(CompositInformTable component) throws IOException {
        super(component);
        addLeaf(new WorkPlaceController(component.getWorkPlace()));
        addLeaf(new InformTableController(component.getInformTable(), this));
        setView(new CompositInformTableView(this));
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

    @Override
    protected void setDragEvent() {

    }

    @Override
    protected void setEventTonExt(MouseButton button) {

    }
}
