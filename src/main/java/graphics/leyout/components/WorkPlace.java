package graphics.leyout.components;

import model.Employer;

public class WorkPlace extends LeyoutComponent {

    private Employer employer;

    @Deprecated
    public WorkPlace(){
    }

    public WorkPlace(LeyoutComponent parent){
        setParent(parent);
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

    public void setEmployer(Employer employer) {
        Employer temp = this.employer;
        if (temp != null) temp.free();
        this.employer = employer;
        System.out.println(employer.getId() + " " + parent().getId()+ " " + parent().getTitle());
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