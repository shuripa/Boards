package graphics.leyout.components;

public class CompositPushcart extends LeyoutComponent {
    Pushcart pushcart;
    WorkPlace workPlace;

    public CompositPushcart(){
        pushcart = new Pushcart();
        workPlace = new WorkPlace();
    }

    public Pushcart getPushcart() {
        return pushcart;
    }


    public WorkPlace getWorkPlace() {
        return workPlace;
    }

    @Override
    public String toString() {
        return "";
    }

}
