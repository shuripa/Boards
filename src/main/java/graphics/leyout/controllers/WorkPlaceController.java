package graphics.leyout.controllers;

import graphics.leyout.components.WorkPlace;
import graphics.leyout.views.WorkPlaceView;
import model.Employer;

import java.io.IOException;

public class WorkPlaceController extends LeyoutComponentController {

    public WorkPlaceController() throws IOException {
        setView(new WorkPlaceView(this));
    }

    public WorkPlaceController(WorkPlace workPlace) throws IOException {
        super(workPlace);
        setView(new WorkPlaceView(this));
    }

    public WorkPlaceController(WorkPlace workPlace, LeyoutWorkPlacedController parent) throws IOException {
        super(workPlace);
        setParent(parent);
        setView(new WorkPlaceView(this));
    }

    public String getLogined() {
        return ((WorkPlace) component()).getLogined();
    }

    public String getText(){
        return ((WorkPlace) component()).getText();
    }


    @Override
    protected void setComponentProperties() {
        if (((WorkPlace)component()).getEmployer() !=  null) {
            setStrProperty(((WorkPlace) component()).getEmployer().idProperty());
            setStrProperty(((WorkPlace) component()).getEmployer().nameProperty());
            setStrProperty(((WorkPlace) component()).getEmployer().phoneProperty());
        }
    }

    @Override
    public void update() {
        ((WorkPlaceView)view()).setText("" + getLogined());
        if (((WorkPlace)component()).isLogined()) {
            view().activate(((WorkPlace)component()).getPriority());
        } else {
            view().disactivate();
            unselect();
        }
        super.update();
    }

    @Override
    public void unselect(){
        Employer emp = ((WorkPlace)component()).getEmployer();
        if (emp != null){
            super.select(((WorkPlace) component()).getPriority());
        } else {
            super.unselect();
        }
    }

}