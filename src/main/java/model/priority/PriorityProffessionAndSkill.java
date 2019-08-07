package model.priority;

import graphics.leyout.components.WorkPlacedComposit;
import graphics.leyout.components.WorkPlace;
import model.Employer;

public class PriorityProffessionAndSkill extends PriorityProfession{


    public PriorityProffessionAndSkill(Employer employer, WorkPlace workPlace) {
        super(employer, workPlace);
    }

    @Override
    public Priority verification (Employer employer, WorkPlace workPlace){
        Priority result = super.verification(employer, workPlace);
            if ((result == null) && (employer.getProductivity((WorkPlacedComposit) workPlace.parent()) >0)){
            setRank(2);
            result = this;
        }
        return result;
    }
}

