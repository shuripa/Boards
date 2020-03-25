package sets;

import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.components.WorkPlacedComposit;
import model.Employee;

import java.util.ArrayList;
import java.util.HashMap;

public class SetWorkPlacedComposits {
    private static SetWorkPlacedComposits instance;
    private ArrayList<WorkPlacedComposit> composits;
    private ArrayList<LeyoutComponent> observers;

    private SetWorkPlacedComposits(){
        instance = this;
        composits = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static SetWorkPlacedComposits getInstance(){
        if (instance == null) {
            return new SetWorkPlacedComposits();
        } else {
            return instance;
        }
    }

//    TODO компонент добавляется при создании. Рабочего места еще нет. Обновлять еще нечего.
    public void addComposit(WorkPlacedComposit composit){
        composits.add(composit);
    }

    public void remComposit(WorkPlacedComposit composit){
        if (composits.contains(composit))
            composits.remove(composit);
        update();
    }

    public void addObserver(LeyoutComponent observer){
        observers.add(observer);
        observer.update();
    }

    public void remObserver(LeyoutComponent observer){
        if (observers.contains(observer)) observers.remove(observer);
    }

    public int getCountWorkPlace(){
        return composits.size();
    }

    public int getCountFreeWorkPlace(){
        int result = 0;
        for (WorkPlacedComposit composit:composits) {
            result = result + composit.getCountFreeWorkPlace();
        }
        return result;
    }

    public double getSumEffectivity() {
        double result = 0;
        for (WorkPlacedComposit wp : composits) {
            result += wp.getEffectivity();
        }
        int N = getCountWorkPlace();
        if (N != 0){
            result = result / N;
        } else {
            result = 0;
        }
        return result;
    }

    public void update() {
        for (LeyoutComponent lc : observers) {
            lc.update();
        }
    }

    public HashMap<Integer, ArrayList<WorkPlacedComposit>> getWorkPlacedToEmployer(Employee employee) {
        HashMap<Integer, ArrayList<WorkPlacedComposit>> result = new HashMap<>();

        for (WorkPlacedComposit composit: composits) {
            //TODO запрос нужно перенести к компоненту
            int priority = composit.getPriorityToEmployer(employee);

            if (result.containsKey(priority)) {
                result.get(priority).add(composit);
            } else{
                ArrayList<WorkPlacedComposit> elementSet = new ArrayList<>();
                elementSet.add(composit);
                result.put(priority, elementSet);
            }
        }
        return result;
    }
}
