package graphics.leyout.controllers.component;

import graphics.leyout.components.MaterialStore;
import graphics.leyout.controllers.LeyoutComponentController;
import graphics.leyout.views.materialStores.MaterialStoreView;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MaterialStoreController extends LeyoutComponentController {
    public MaterialStoreController(MaterialStore materialStore, String viewType) throws IOException {
        super(materialStore);
        createView(viewType);
    }

    private void createView(String viewType){
        Class<?> view;
        Constructor<?> constructor;
        String className = "graphics.leyout.views.materialStores."+ viewType;
        try {
            view = Class.forName(className);
            try {
                constructor = view.getConstructor(LeyoutComponentController.class);
                try {
                    try {
                        setView((MaterialStoreView)constructor.newInstance(this));
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

    @Override
    protected void setComponentProperties() throws IOException {
//        setView(new ToolGridView(this));
    }
}
