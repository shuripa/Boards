package graphics.leyout.controllers;

import graphics.leyout.components.WorkPlace;
import graphics.leyout.views.WorkPlaceView;
import javafx.scene.input.MouseButton;

import java.io.IOException;

public class WorkPlaceController extends LeyoutComponentController {

    public WorkPlaceController() throws IOException {
        setView(new WorkPlaceView(this));
    }

    public WorkPlaceController(WorkPlace workPlace) throws IOException {
        super(workPlace);
        setView(new WorkPlaceView(this));
    }

    public String getLogined() {
        return ((WorkPlace) component()).getLogined();
    }

    public String getText(){
        return ((WorkPlace) component()).getText();
    }

    @Override
    protected void setDragEvent() {

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
    protected void setEventTonExt(MouseButton button) {

    }

    @Override
    public void update() {
        System.out.println("WorkPlace update");
        ((WorkPlaceView)view()).setText("" + getLogined());
        if (((WorkPlace)component()).isLogined()) {
            view().activate();
        } else {
            view().disactivate();
            unselect();
        }
    }

}