package graphics.leyout.controllers.component;

import graphics.leyout.components.ProductionStore;
import graphics.leyout.controllers.LeyoutComponentController;
import graphics.leyout.views.productStores.ProductStoreView;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ProductStoreController extends LeyoutComponentController {
    public ProductStoreController(ProductionStore productionStore, String viewType) throws IOException {
        super(productionStore);
        createView(viewType);
    }

    private void createView(String viewType){
        Class<?> view;
        Constructor<?> constructor;
        String className = "graphics.leyout.views.productStores."+ viewType;
        try {
            view = Class.forName(className);
            try {
                constructor = view.getConstructor(LeyoutComponentController.class);
                try {
                    try {
                        setView((ProductStoreView)constructor.newInstance(this));
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
