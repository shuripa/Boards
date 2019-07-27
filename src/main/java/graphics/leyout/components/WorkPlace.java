package graphics.leyout.components;

import model.Employer;
import model.Profession;
import model.Side;

public class WorkPlace extends LeyoutComponent {

    private Employer employer;
    Side side;
    Profession profession;

    @Deprecated
    public WorkPlace(){
    }

    public WorkPlace(LeyoutComposit parent, Profession profession){
        setParent(parent);
        side = Side.DOWN;
        this.profession = profession;
    }

    public WorkPlace(LeyoutComponent parent, Profession profession, Side side){
        setParent(parent);
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