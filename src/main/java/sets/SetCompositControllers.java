package sets;

import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.controllers.LeyoutComponentController;
import graphics.leyout.controllers.LeyoutCompositController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Набір контроллерів всіх ЛейаутКомпонентів
 */

public class SetCompositControllers implements Iterable<LeyoutCompositController>{

    private static SetCompositControllers instance;
    private ArrayList<LeyoutCompositController> controllers;
    private ArrayList<LeyoutComponentController> observers;

    private SetCompositControllers(){
//        mapComponents = new HashMap<>();
        controllers = new ArrayList<>();
        observers = new ArrayList<>();
        instance = this;
    }

    public static SetCompositControllers getInstance(){
        if (instance == null) {
            instance = new SetCompositControllers();
        }
        return instance;
    }

    public void addComponentController(LeyoutCompositController controller) throws IOException {
        controllers.add(controller);
        for (LeyoutComponentController observer: observers) {
            controller.component().addComponentObserver(observer.component());
        }
    }

    public void remComponentController(LeyoutComponent component){
        controllers.remove(component);
    }

    public void addObserver(LeyoutComponentController observer){
        observers.add(observer);
        for (LeyoutComponentController controller : controllers) {
            controller.component().addComponentObserver(observer.component());
//            if (((WorkPlacedComposit)controller.component()).getWorkPlace() != null) {
//                ((WorkPlacedComposit)controller.component()).getWorkPlace().addComponentObserver(observer.component());
//            }
        }
    }

    public ArrayList<LeyoutCompositController> getComponentControllers(){
        return controllers;
    }

    @Override
    public Iterator<LeyoutCompositController> iterator() {
        return controllers.iterator();
    }

}
