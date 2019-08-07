package model.priority;

import graphics.leyout.components.WorkPlace;
import model.Employer;

public class PriorityProfession extends Priority {
    public PriorityProfession(Employer employer, WorkPlace workPlace) {
        super(employer, workPlace);
        setRank(3);
//        Priority result = super.verification(employer, workPlace);
        result = null;
    }

    @Override
    public Priority verification (Employer employer, WorkPlace workPlace){
        if ((result == null) && (employer.getProfession() == workPlace.getProfession())) result = this;
        return result;
    }
}
