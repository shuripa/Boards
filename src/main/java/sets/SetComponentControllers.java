package sets;

import graphics.components.LeyoutComponent;
import graphics.controllers.LeyoutComponentController;

import java.io.IOException;
import java.util.ArrayList;

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

    public void addComponentController(LeyoutComponentController component) throws IOException {
        arrComponentControllers.add(component);
    }

    public void remComponentController(LeyoutComponent component){
        arrComponentControllers.remove(component);
    }

    public ArrayList<LeyoutComponentController> getComponentControllers(){
        return arrComponentControllers;
    }

}
