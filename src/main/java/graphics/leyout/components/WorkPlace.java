package graphics.leyout.components;

import model.Employer;
import model.Profession;
import model.Side;

public class WorkPlace extends LeyoutComponent {

    /**
     * Приоритеты определены в LeyoutComposit и могут быть переопределены в дочерних классах.
     * Приоритеты хранятся в классе рабочего места, т.к. именно для него они имеют смысл.
     * Список обоснований приоритетов не окончательный.
     *
     * 0 - ничего удовлетворяющего условиям приоритетов
     * 1 - светлозеленый    - закрепленное рабочее место
     * 2 - темно-зеленый    - место не закреплено но есть навыки
     * 3 -
     * 4 - темно-желтый     - есть навыки но другая професия
     * 5 -
     * 6 -
     * 7 -
     * 8 - красный          - любое свободное место на проекте
     * 9 - обычный серый    - не используется так как использован при обычном выделении хотя для обычного выделения можно установить и 10 или пересмотреть 0
     */



    private Employer employer;
    int priority;

    Side side;
    Profession profession;
    @Deprecated
    public WorkPlace(){
    }

    public WorkPlace(LeyoutComposit parent, Profession profession){
        setParent(parent);
        priority = 9;
        this.side = Side.DOWN;
        this.profession = profession;
    }

    public WorkPlace(LeyoutComponent parent, Profession profession, Side side){
        setParent(parent);
        priority = 9;
        this.profession = profession;
        this.side = side;
    }

    public Employer getEmployer() {
        return employer;
    }

    public boolean isLogined() {
        return employer == null ? false : true;
    }

    public String getLogined(){
        return employer == null ? "0" : employer.getId();
    }

    @Override
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Side getSide(){
        return side;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setEmployer(Employer employer) {
        Employer temp = this.employer;
        if (temp != null) temp.free();
        this.employer = employer;
        this.employer.setWorkPlace(this);
        update();
//        if (this.employer.getWorkPlase() != this) employer.setWorkPlace(this);
    }

    public void setEmployerWithPriority(Employer employer, int priority){
        this.priority = priority;
        setEmployer(employer);
    }

    public void free(){
        if (employer != null) {
            Employer e = employer;
            employer = null;
            if (e.getWorkPlase () != null) e.free();
        }
        update();
    }

    @Override
    public String toString(){
        return isLogined()
                ? "Employer: " + employer.getId()
                + "\n" + employer.getName()
                + "\n" + employer.getPhone()
                : "Emloyer isn't logined.";
    }

    public String getText(){
        return "" + getLogined();
    }


}