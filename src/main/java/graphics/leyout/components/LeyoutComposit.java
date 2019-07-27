package graphics.leyout.components;

import model.Condition;
import model.Employer;
import model.Skill;


public abstract class LeyoutComposit extends LeyoutComponent {

    private String title;
    private String id;

    public LeyoutComposit() {
        title = "";
    }

    public LeyoutComposit(String title, String id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPriorityToEmployer(Employer employer){
        int result = 0;
        for (String s: employer.getBindWorkPlaces()) {
            if (s.equals(getId())) {
                return 1;
            }
        }
        for (Skill skill : employer.getSkills()) {
            for (Condition condition : getConditions()) {
                if (condition.isSuited(skill) && this.getWorkPlace().getProfession() == employer.getProfession()) {
                    return 2;
                }
                if (condition.isSuited(skill)) {
                    return 6;
                }
            }
        }
        if (this.getWorkPlace().getProfession() == employer.getProfession() && getWorkPlace().isLogined() == false){
            return 4;
        }
        return result;
    }
}
