package sets;

import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.controllers.LeyoutComponentController;
import graphics.leyout.controllers.LeyoutCompositController;
import model.Employer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Набір контроллерів всіх ЛейаутКомпонентів
 */

public class SetCompositControllers implements Iterable<LeyoutCompositController>{

    private static SetCompositControllers instance;
    private ArrayList<LeyoutCompositController> arrComponentControllers;
    private ArrayList<LeyoutComponentController> observers;
//    private HashMap <Integer, LeyoutComponent> mapComponents;
//    private ArrayList<Condition> arrConditions;

    private SetCompositControllers(){
//        mapComponents = new HashMap<>();
        arrComponentControllers = new ArrayList<>();
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
        arrComponentControllers.add(controller);
        for (LeyoutComponentController observer: observers) {
            controller.component().addComponentObserver(observer.component());
//            TODO В зависимости от событий которые нужно слушать можно сделать разные функции к каким именно объектам прислушиваться
//            В даном случае меня интересует событие login поэтому я добаляю всех слушателей в к рабочему месту.
//            Но так нужно делать не всегда.
            controller.component().getWorkPlace().addComponentObserver(observer.component());
        }
    }

    public void remComponentController(LeyoutComponent component){
        arrComponentControllers.remove(component);
    }

    public void addObserver(LeyoutComponentController observer){
        observers.add(observer);
        for (LeyoutComponentController controller : arrComponentControllers) {
            controller.component().addComponentObserver(observer.component());
            controller.component().getWorkPlace().addComponentObserver(observer.component());
        }
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
            //TODO запрос нужно перенести к компоненту
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



    @Override
    public Iterator<LeyoutCompositController> iterator() {
        return arrComponentControllers.iterator();
    }
}
