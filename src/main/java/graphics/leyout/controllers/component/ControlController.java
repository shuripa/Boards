package graphics.leyout.controllers.component;

import graphics.leyout.components.CompositMao;
import graphics.leyout.components.Control;
import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.controllers.LeyoutComponentController;
import graphics.leyout.controllers.LeyoutCompositController;
import graphics.leyout.views.CompositMaoView;
import graphics.leyout.views.controls.ControlView;
import model.Condition;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class ControlController extends LeyoutCompositController {

    public ControlController(Control cm) throws IOException {
        super(cm);
        setView(new CompositMaoView(this));
    }

    public ControlController(LeyoutComponent cm, LeyoutCompositController parent, String viewType) throws IOException {
        super(cm);
        setParent(parent);
        createView(viewType);
//        setView(new CompositMaoView(this));
    }

    private void createView(String viewType){
        Class<?> view;
        Constructor<?> constructor;
        String className = "graphics.leyout.views.controls."+ viewType;
        try {
            view = Class.forName(className);
            try {
                constructor = view.getConstructor(LeyoutComponentController.class);
                try {
                    try {
                        setView((ControlView)constructor.newInstance(this));
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


    public void setTitle(String s) {
        ((CompositMao)component()).setTitle(s);
    }

    @Override
    protected void setComponentProperties() {
//        setStrProperty(((CompositMao)component()).titleProperty());
    }

    @Override
    public ArrayList<Condition> getConditions() {
        return null;
    }

}
