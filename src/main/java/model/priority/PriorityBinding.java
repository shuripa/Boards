package model.priority;

import graphics.leyout.components.WorkPlacedComposit;
import graphics.leyout.components.WorkPlace;
import model.Employer;

public class PriorityBinding extends PriorityProffessionAndSkill {


    public PriorityBinding(Employer employer, WorkPlace workPlace) {
        super(employer, workPlace);
        setRank(1);
    }

    @Override
    public Priority verification(Employer employer, WorkPlace workPlace) {
        for (String wpId : employer.getBindWorkPlaces()) {
            if (wpId == ((WorkPlacedComposit)workPlace.parent()).getId())
                result = this;
        }
        return result;
    }
}
