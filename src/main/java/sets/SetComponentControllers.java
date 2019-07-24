package sets;

import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.controllers.LeyoutComponentController;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Набір контроллерів всіх ЛейаутКомпонентів
 */

public class SetComponentControllers {

    private static SetComponentControllers instance;
    private ArrayList<LeyoutComponentController> arrComponentControllers;
//    private HashMap <Integer, LeyoutComponent> mapComponents;
//    private ArrayList<Condition> arrConditions;

    private SetComponentControllers(){
//        mapComponents = new HashMap<>();
        arrComponentControllers = new ArrayList<>();
        instance = this;
    }

    public static SetComponentControllers getInstance(){
        if (instance == null) {
            instance = new SetComponentControllers();
        }
        return instance;
    }

    public void addComponentController(LeyoutComponentController controller) throws IOException {
        arrComponentControllers.add(controller);
    }

    public void remComponentController(LeyoutComponent component){
        arrComponentControllers.remove(component);
    }

    public ArrayList<LeyoutComponentController> getComponentControllers(){
        return arrComponentControllers;
    }

}
