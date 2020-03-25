package model.priority;

import graphics.leyout.components.WorkPlace;
import model.Employee;

public class PriorityProfession extends Priority {
    public PriorityProfession(Employee employee, WorkPlace workPlace) {
        super(employee, workPlace);
        setRank(3);
//        Priority result = super.verification(employer, workPlace);
        result = null;
    }

    @Override
    public Priority verification (Employee employee, WorkPlace workPlace){
        if ((result == null) && (employee.getProfession() == workPlace.getProfession())) result = this;
        return result;
    }
}
