package graphics.leyout.controllers.component;

import graphics.leyout.components.WorkPlace;
import graphics.leyout.controllers.LeyoutComponentController;
import graphics.leyout.controllers.LeyoutWorkPlacedController;
import graphics.leyout.views.workPlaces.ToolPositionView;
import model.Employee;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ToolWorkPlaceController extends LeyoutComponentController {

    public ToolWorkPlaceController(WorkPlace workPlace, LeyoutWorkPlacedController parent, String type) throws IOException {
        super(workPlace);
        setParent(parent);
        createView((type));
    }

    private void createView(String viewType){
        Class<?> view;
        Constructor<?> constructor;
        String className = "graphics.leyout.views.workPlaces."+ viewType;
        try {
            view = Class.forName(className);
            try {
                constructor = view.getConstructor(LeyoutComponentController.class);
                try {
                    try {
                        setView((ToolPositionView)constructor.newInstance(this));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public String getLogined() {
        return ((WorkPlace) component()).getLogined();
    }

    public String getText(){
        return ((WorkPlace) component()).getText();
    }


    @Override
    protected void setComponentProperties() {
        if (((WorkPlace)component()).getEmployee() !=  null) {
            setStrProperty(((WorkPlace) component()).getEmployee().idProperty());
            setStrProperty(((WorkPlace) component()).getEmployee().nameProperty());
            setStrProperty(((WorkPlace) component()).getEmployee().phoneProperty());
        }
    }

    @Override
    public void update() {
        ((ToolPositionView)view()).setText("" + getLogined());
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
        Employee emp = ((WorkPlace)component()).getEmployee();
        if (emp != null){
            super.select(((WorkPlace) component()).getPriority());
        } else {
            super.unselect();
        }
    }

}