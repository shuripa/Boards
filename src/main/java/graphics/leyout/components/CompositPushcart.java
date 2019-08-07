package graphics.leyout.components;

import model.Profession;

public class CompositPushcart extends WorkPlacedComposit {
    Pushcart pushcart;
    WorkPlace workPlace;

    public CompositPushcart(String id){
        setId(id);
        pushcart = new Pushcart();
        workPlace = new WorkPlace(this, Profession.DELIVER);
        addLeafs(pushcart, workPlace);
    }

    public Pushcart getPushcart() {
        return pushcart;
    }


    public WorkPlace getWorkPlace() {
        return workPlace;
    }

    @Override
    public double getEffectivity() {
        return 100;
    }

    @Override
    public int getCountFreeWorkPlace() {
        return (workPlace.isLogined()) ? 0 : 1;
    }

    @Override
    public String toString() {
        return "";
    }

}
