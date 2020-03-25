package graphics.leftpanel.components;

import graphics.leyout.components.WorkPlace;
import graphics.leyout.components.WorkPlacedComposit;
import model.Employee;
import sets.Buffer;
import sets.SetEmployees;
import sets.SetWorkPlacedComposits;

import java.util.ArrayList;
import java.util.HashMap;

public class IndexDispersion extends IndexButton {

//    TODO: после проверки работы индикаторов закомментированное удалить.

    Boolean complete = false;
    int countWorkPlace;
    double sumEffectivity;
    //    ArrayList<LeyoutCompositController> setControllers;
    SetWorkPlacedComposits setComposits;

    public IndexDispersion(String hint, String measure){
        super(hint, measure);
//        SetCompositControllers instance = SetCompositControllers.getInstance();
//        setControllers = instance.getComponentControllers();
//        for (LeyoutComponentController lcc: setControllers) {
//            LeyoutComponent component = lcc.component();
//            component.addComponentObserver(this);
//            component.update();
//        }
        setComposits = SetWorkPlacedComposits.getInstance();
//        setComposits.addObserver(this);
//        update();
    }

    public int getCountWorkPlace() {
        return countWorkPlace;
    }

    public double getSumEffectivity() {
        return sumEffectivity;
    }

    public int getMediumEffectivity(){

        return (int)Math.ceil(sumEffectivity/countWorkPlace);
    }


    public void action() {
        if (!complete) {
            completed();
            complete = true;
        } else {
            freeded();
            complete = false;
        }
        update();
    }

    private void freeded(){
        Buffer<Employee> bufferEmploers = SetEmployees.getInstance().getBufferEmploers();
        for (Employee employee : bufferEmploers) {
            employee.free();
        }
    }

    private void completed(){
        Buffer<Employee> bufferEmploers = SetEmployees.getInstance().getBufferEmploers();
//        SetCompositControllers setControllers = SetCompositControllers.getInstance();
//        HashMap<Integer, ArrayList<LeyoutCompositController>> controllers;
        HashMap<Integer, ArrayList<WorkPlacedComposit>> composits;
        WorkPlace wp;

        for (Employee employee : bufferEmploers) {
            System.out.println("WATHCING EMPLOYER: " + employee.getId());
//            controllers = setControllers.getControllersToEmployer(employer);
            composits = setComposits.getWorkPlacedToEmployer(employee);
            for (int i = 1; i<9; i++) {
                if (employee.isLogined() && employee.getWorkPlaсe().getPriority() != 0 && employee.getWorkPlaсe().getPriority()<i) break;

                if (composits.containsKey(i)) {
                    for (WorkPlacedComposit composit : composits.get(i)) {
                        wp = composit.getWorkPlace();
                        if (wp.isLogined()) {
                            if (wp.getPriority() == 0 || wp.getPriority() > i) {
//                                        b.remove(wp.getEmployer());
                                free(bufferEmploers, wp);
                                login(employee, i, composit);
                            } else {
                                int pem = employee.getProductivity(composit);
                                int pwp = wp.getEmployee().getProductivity(composit);
                                if (wp.getPriority() == i && pem > pwp){
//                                            arrEmployers.remove(wp.getEmployer());
                                    free(bufferEmploers, wp);
                                    login(employee, i, composit);
                                }
                            }
                        } else {
                            if (employee.isLogined()){
                                int pem = employee.getProductivity(composit);
                                int pwp = employee.getProductivity((WorkPlacedComposit) employee.getWorkPlaсe().parent());
                                if (pem > pwp){
                                    login(employee, i, composit);
                                }
                            } else {
                                login(employee, i, composit);
                            }
                        }
                    }
                }
                if (employee.isLogined()) break;
            }
        }
    }


    private void free(Buffer<Employee> bufferEmploers, WorkPlace wp) {
        System.out.println("FREING: employer " + wp.getEmployee()
                + " free at place " + ((WorkPlacedComposit)wp.parent()).getId()
                + " with priority " + wp.getPriority());
        bufferEmploers.enque(wp.getEmployee());
    }
    
    private void login(Employee employee, int i, WorkPlacedComposit composit) {
        (composit).logining(employee, i);
        System.out.println("LOGINING: emloyer " + employee.getId()
                + " logined to " + composit.getId()
                + " with priority " + i);
    }

    @Override
    public void update() {
//        setComposits = SetWorkPlacedComposits.getInstance();
//        countWorkPlace = setComposits.getCountWorkPlace();
//        sumEffectivity = setComposits.getSumEffectivity();
//        setIndex(getMediumEffectivity());

        setIndex((int)Math.ceil(SetWorkPlacedComposits.getInstance().getSumEffectivity()));
        super.update();
    }



    @Override
    public String toString() {
        return "";
    }
}
