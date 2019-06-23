package panes;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PlanElement {
    private SimpleStringProperty modul;
    private SimpleIntegerProperty count;
    private SimpleDoubleProperty ettime;

    public PlanElement(String modul, Integer count, Double ettime) {
        this.modul = new SimpleStringProperty(modul);
        this.count = new SimpleIntegerProperty(count);
        this.ettime = new SimpleDoubleProperty(ettime);
    }

    public void setModul(String modul) {
        this.modul.set(modul);
    }

    public String getModul() {
        return modul.get();
    }

    public void setCount(Integer count) {
        this.count.set(count);
    }

    public Integer getCount() {
        return count.get();
    }

    public void setEttime(Double ettime) {
        this.ettime.set(ettime);
    }

    public Double getEttime() {
        return ettime.get();
    }

}
