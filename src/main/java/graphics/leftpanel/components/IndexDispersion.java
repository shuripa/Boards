package graphics.leftpanel.components;

import graphics.leyout.components.WorkPlace;
import graphics.leyout.components.WorkPlacedComposit;
import model.Employer;
import sets.Buffer;
import sets.SetEmployers;
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
        Buffer<Employer> bufferEmploers = SetEmployers.getInstance().getBufferEmploers();
        for (Employer employer: bufferEmploers) {
            employer.free();
        }
    }

    private void completed(){
        Buffer<Employer> bufferEmploers = SetEmployers.getInstance().getBufferEmploers();
//        SetCompositControllers setControllers = SetCompositControllers.getInstance();
//        HashMap<Integer, ArrayList<LeyoutCompositController>> controllers;
        HashMap<Integer, ArrayList<WorkPlacedComposit>> composits;
        WorkPlace wp;

        for (Employer employer: bufferEmploers) {
            System.out.println("WATHCING EMPLOYER: " + employer.getId());
//            controllers = setControllers.getControllersToEmployer(employer);
            composits = setComposits.getWorkPlacedToEmployer(employer);
            for (int i = 1; i<9; i++) {
                if (employer.isLogined() && employer.getWorkPlase().getPriority() != 0 && employer.getWorkPlase().getPriority()<i) break;

                if (composits.containsKey(i)) {
                    for (WorkPlacedComposit composit : composits.get(i)) {
                        wp = composit.getWorkPlace();
                        if (wp.isLogined()) {
                            if (wp.getPriority() == 0 || wp.getPriority() > i) {
//                                        b.remove(wp.getEmployer());
                                free(bufferEmploers, wp);
                                login(employer, i, composit);
                            } else {
                                int pem = employer.getProductivity(composit);
                                int pwp = wp.getEmployer().getProductivity(composit);
                                if (wp.getPriority() == i && pem > pwp){
//                                            arrEmployers.remove(wp.getEmployer());
                                    free(bufferEmploers, wp);
                                    login(employer, i, composit);
                                }
                            }
                        } else {
                            if (employer.isLogined()){
                                int pem = employer.getProductivity(composit);
                                int pwp = employer.getProductivity((WorkPlacedComposit)employer.getWorkPlase().parent());
                                if (pem > pwp){
                                    login(employer, i, composit);
                                }
                            } else {
                                login(employer, i, composit);
                            }
                        }
                    }
                }
                if (employer.isLogined()) break;
            }
        }
    }


    private void free(Buffer<Employer> bufferEmploers, WorkPlace wp) {
        System.out.println("FREING: employer " + wp.getEmployer()
                + " free at place " + ((WorkPlacedComposit)wp.parent()).getId()
                + " with priority " + wp.getPriority());
        bufferEmploers.enque(wp.getEmployer());
    }
    
    private void login(Employer employer, int i, WorkPlacedComposit composit) {
        (composit).logining(employer, i);
        System.out.println("LOGINING: emloyer " + employer.getId()
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
