package graphics.leyout.components;

import model.Condition;
import model.Employee;
import model.Skill;
import sets.SetWorkPlacedComposits;


public abstract class WorkPlacedComposit extends LeyoutComponent {

    private String title;
    private String id;
    SetWorkPlacedComposits sets;

    public WorkPlacedComposit() {
        title = "";
        sets = SetWorkPlacedComposits.getInstance();
        sets.addComposit(this);
    }

    public WorkPlacedComposit(String title, String id) {
        this.title = title;
        this.id = id;
        sets = SetWorkPlacedComposits.getInstance();
        sets.addComposit(this);
    }

    public void destroy(){
        sets.remComposit(this);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //Необходимо для получения ID рабочего места. ((LeyautComposit)workplace.parent).getId()
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public WorkPlacedComposit parent(){
        return (WorkPlacedComposit)super.parent();
    }

    public abstract WorkPlace getWorkPlace();

    public Condition getCondition(){
        return null;
    }

    public void logining(Employee employee){
        if (employee != null) {
            logining(employee, getPriorityToEmployer(employee));
            setActive(true);
        }
    }

    public void logining(Employee employee, int priority){
        WorkPlace wp = getWorkPlace();
        if (wp != null) {
            wp.setEmployerWithPriority(employee, priority);
            SetWorkPlacedComposits.getInstance().update();
        }
        setActive(true);
    }

    public int getPriority(){
        if (getWorkPlace().isLogined()){
            return getPriorityToEmployer(getWorkPlace().getEmployee());
        } else return 1;
    }

    public int getPriorityToEmployer(Employee employee){
        int result = 10;
        for (String s: employee.getBindWorkPlaces()) {
            if (s.equals(getId())) {
                return 2;
            }
        }
        for (Skill skill : employee.getSkills()) {
            for (Condition condition : getConditions()) {
                if (condition.isLike(skill) && this.getWorkPlace().getProfession() == employee.getProfession()) {
                    return 3;
                }
                if (condition.isLike(skill)) {
                    return 7;
                }
            }
        }

//
//        if (getWorkPlace().isLogined() == false || getWorkPlace().getLogined() == employer.getId() || getWorkPlace().getPriority() >= 5){
        if (getWorkPlace().isLogined() == false || getWorkPlace().getLogined() == employee.getId()) {
            if (this.getWorkPlace().getProfession() == employee.getProfession()) {
                return 5;
            } else {
                return 9;   //Условие: Профессия не совпадает. Число поставлено на угад.
            }
        }
        return result;
    }

    public double getEffectivity(){
        return 0;
    }

    public abstract int getCountFreeWorkPlace();

}
