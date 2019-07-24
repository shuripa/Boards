package graphics.leyout.components;

import model.Employer;

public class WorkPlace extends LeyoutComponent {

    private Employer employer;

    public WorkPlace(){
    }

    public WorkPlace(LeyoutComponent parent){
        setParent(parent);
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        if (this.employer != null) {
            this.employer.free();
            update();
        }
        if (employer != null) {
            this.employer = employer;
            if (this.employer.getWorkPlase() != this) employer.setWorkPlace(this);
//            employer.setWorkPlace(this);
            update();
        }
    }

    public String getLogined(){
        return employer == null ? "0" : employer.getId();
    }

    public boolean isLogined() {
        return employer == null ? false : true;
    }

    public void free(){
        if (employer != null) {
            Employer e = employer;
            employer = null;
            e.free();
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