package leyout.components;

public class Human extends LeyoutComponent {
    private int empId;

    public Human(){
        free();
    }

    public int getLogined(){
        return empId;
    }

    public void setLogining(int empId) {
        this.empId = empId;
        update();
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