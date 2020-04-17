package sets;

import graphics.leyout.components.WorkPlacedComposit;
import graphics.leyout.controllers.LeyoutComponentController;
import graphics.leyout.controllers.LeyoutWorkPlacedController;
import model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SetWorkPlesedControllers implements Iterable<LeyoutWorkPlacedController>{
    private static SetWorkPlesedControllers instance;
    private ArrayList<LeyoutWorkPlacedController> controllers;
    private ArrayList<LeyoutComponentController> observers;

    private SetWorkPlesedControllers(){
        controllers = new ArrayList<>();
        observers = new ArrayList<>();
        instance = this;
    }

    public static SetWorkPlesedControllers getInstance(){
        if (instance == null) {
            instance = new SetWorkPlesedControllers();
        }
        return instance;
    }

    public void addController(LeyoutWorkPlacedController controller)  {
        controllers.add(controller);
        for (LeyoutComponentController observer: observers) {
            controller.component().addComponentObserver(observer.component());
//            TODO В зависимости от событий которые нужно слушать можно сделать разные функции к каким именно объектам прислушиваться
//            В даном случае меня интересует событие login поэтому я добаляю всех слушателей в к рабочему месту.
//            Но так нужно делать не всегда.
            ((WorkPlacedComposit)controller.component()).getWorkPlace().addComponentObserver(observer.component());
        }
    }

    public void remController(LeyoutWorkPlacedController component){
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


    //Подсветка всех рабочих мест для рабочего
    public void selectControllersToEmployer(Employee employee) {
        for (LeyoutWorkPlacedController controller: controllers) {
            controller.selectWhithPriority(employee);
        }
    }

    //Получение рабочих мест с приоритетами
    public HashMap<Integer, ArrayList<LeyoutWorkPlacedController>> getControllersToEmployer(Employee employee) {

        HashMap<Integer, ArrayList<LeyoutWorkPlacedController>> result = new HashMap<>();

        for (LeyoutWorkPlacedController controller: controllers) {
            //TODO запрос нужно перенести к компоненту
            int priority = controller.getPriority(employee);

            if (result.containsKey(priority)) {
                result.get(priority).add(controller);
            } else{
                ArrayList<LeyoutWorkPlacedController> elementSet = new ArrayList<>();
                elementSet.add(controller);
                result.put(priority, elementSet);
            }
        }
        return result;
    }

    public Iterator<LeyoutWorkPlacedController> iterator() {
        return controllers.iterator();
    }

}
