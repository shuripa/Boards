package model.priority;

import graphics.leyout.components.WorkPlacedComposit;
import graphics.leyout.components.WorkPlace;
import model.Employee;

public class PriorityBinding extends PriorityProffessionAndSkill {


    public PriorityBinding(Employee employee, WorkPlace workPlace) {
        super(employee, workPlace);
        setRank(1);
    }

    @Override
    public Priority verification(Employee employee, WorkPlace workPlace) {
        for (String wpId : employee.getBindWorkPlaces()) {
            if (wpId == ((WorkPlacedComposit)workPlace.parent()).getId())
                result = this;
        }
        return result;
    }
}
