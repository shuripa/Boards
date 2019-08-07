package graphics.leyout.controllers;

import graphics.leyout.components.WorkPlacedComposit;
import model.Employer;
import sets.SetWorkPlacedComposits;
import sets.SetWorkPlesedControllers;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Композиты которые имеют рабочее место
 * Задачи:
 * Все что связано с рабочими местами.
 */

public abstract class LeyoutWorkPlacedController extends LeyoutCompositController{

    private ArrayList<WorkPlaceController> workplaces;

    public LeyoutWorkPlacedController(WorkPlacedComposit component) throws IOException {
        super(component);
        workplaces = new ArrayList<>();
        SetWorkPlesedControllers scc = SetWorkPlesedControllers.getInstance();
        scc.addController(this);
        updateComposits();
    }

    //Подсветить все рабочие места для рабочего
    public void selectWhithPriority(Employer empoloyer){
        select(getPriority(empoloyer));
    }

    public int getPriority(Employer employer) {
        return ((WorkPlacedComposit)component()).getPriorityToEmployer(employer);
    }

    public int getPriority(){
        return ((WorkPlacedComposit)component()).getPriority();
    }


    @Override
    protected void setComponentProperties() {

    }


    public double getSumEffectivity() {
        if ((((WorkPlacedComposit)component())).getWorkPlace() != null){
            return ((WorkPlacedComposit)component()).getWorkPlace().isLogined() ? 100 : 0;
        } return 0;
    }

    private void updateComposits() {
        SetWorkPlacedComposits setComposits = SetWorkPlacedComposits.getInstance();
        setComposits.update();
    }

    public int getCountWorkPlase() {
        return 1;
    }

}
