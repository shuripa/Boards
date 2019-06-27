package leyout.components;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Human extends LeyoutComponent {
    private final static String TITLE_PROP_ID = "Employe Id";

    private final IntegerProperty id;

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public Human(){
        id = new SimpleIntegerProperty(this, TITLE_PROP_ID, 0);
    }

    public int getLogined(){
        return id.get();
    }

    public void setLogining(int id) {
        this.id.setValue(id);
        update();
    }

    public boolean isLogined() {
        return getLogined() == 0 ? false : true;
    }

    public void free(){
        id.setValue(0);
    }

    @Override
    public String toString(){
        return isLogined() ? "Працівник: " + getLogined() : "Працівник не залогований.";
    }

    public String getText(){
        return "" + getLogined();
    }

}