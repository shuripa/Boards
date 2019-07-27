package sets;

import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.controllers.LeyoutCompositController;
import model.Employer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Набір контроллерів всіх ЛейаутКомпонентів
 */

public class SetCompositControllers {

    private static SetCompositControllers instance;
    private ArrayList<LeyoutCompositController> arrComponentControllers;
//    private HashMap <Integer, LeyoutComponent> mapComponents;
//    private ArrayList<Condition> arrConditions;

    private SetCompositControllers(){
//        mapComponents = new HashMap<>();
        arrComponentControllers = new ArrayList<>();
        instance = this;
    }

    public static SetCompositControllers getInstance(){
        if (instance == null) {
            instance = new SetCompositControllers();
        }
        return instance;
    }

    public void addComponentController(LeyoutCompositController controller) throws IOException {
        arrComponentControllers.add(controller);
    }

    public void remComponentController(LeyoutComponent component){
        arrComponentControllers.remove(component);
    }

    public ArrayList<LeyoutCompositController> getComponentControllers(){
        return arrComponentControllers;
    }

    //Подсветка всех рабочих мест для рабочего
    public void selectControllersToEmployer(Employer employer) {
        for (LeyoutCompositController controller: arrComponentControllers) {
            controller.selectWhithPriority(employer);
        }
    }

    public HashMap<Integer, ArrayList<LeyoutCompositController>> getControllersToEmployer(Employer employer) {

        HashMap<Integer, ArrayList<LeyoutCompositController>> result = new HashMap<>();

        for (LeyoutCompositController controller: arrComponentControllers) {
            int priority = controller.getPriority(employer);

            if (result.containsKey(priority)) {
                result.get(priority).add(controller);
            } else{
                ArrayList<LeyoutCompositController> elementSet = new ArrayList<>();
                elementSet.add(controller);
                result.put(priority, elementSet);
            }
        }
        return result;
    }
}
