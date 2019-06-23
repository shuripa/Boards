package leyout.elements;

import leyout.controllers.HumanController;

public class Human extends LeyoutElement {
    private int empId;

    public Human(HumanController controller){
        super(controller);
        free();
    }

    public Human(){
        super();
        free();
    }

    public int getLogined(){
        return empId;
    }

    public void setLogining(int empId) {
        this.empId = empId;
        controller.activate();
    }

    public boolean isLogined() {
        return getLogined() == 0 ? false : true;
    }

    public void free(){
        empId = 0;
    }

    @Override
    public String toString(){
        return isLogined() ? "Працівник: " + getLogined() : "Працівник не залогований.";
    }

    public String getText(){
        return "" + getLogined();
    }

}