package graphics.leyout.components;

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
        this.employer = employer;
        employer.setWorkPlace(this);
        update();
    }

    public int getLogined(){
        return employer == null ? 0 : employer.getId();
    }

    public boolean isLogined() {
        return employer == null ? false : true;
    }

    public void free(){
        employer.free();
        employer = null;
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