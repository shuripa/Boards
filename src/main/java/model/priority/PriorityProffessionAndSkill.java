package model.priority;

import graphics.leyout.components.WorkPlacedComposit;
import graphics.leyout.components.WorkPlace;
import model.Employee;

public class PriorityProffessionAndSkill extends PriorityProfession{


    public PriorityProffessionAndSkill(Employee employee, WorkPlace workPlace) {
        super(employee, workPlace);
    }

    @Override
    public Priority verification (Employee employee, WorkPlace workPlace){
        Priority result = super.verification(employee, workPlace);
            if ((result == null) && (employee.getProductivity((WorkPlacedComposit) workPlace.parent()) >0)){
            setRank(2);
            result = this;
        }
        return result;
    }
}

