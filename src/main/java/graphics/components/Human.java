package graphics.components;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Human extends LeyoutComponent {

//    TODO вместо свойств этот компонент должен хранить сам объек Employer

    private final static String TITLE_PROP_ID = "Employe Id";
    private final static String TITLE_PROP_NAME = "Emploer Name";
    private final static String TITLE_PROP_PHONE = "Phone";

    private IntegerProperty id;
    private StringProperty name;
    private StringProperty phone;

    private Employer employer;

    public Human(){
        id = new SimpleIntegerProperty(this, TITLE_PROP_ID, 0);
        name = new SimpleStringProperty(this, TITLE_PROP_NAME, "");
        phone = new SimpleStringProperty(this, TITLE_PROP_PHONE, "");
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public static String getTitlePropId() {
        return TITLE_PROP_ID;
    }

    public static String getTitlePropPhone() {
        return TITLE_PROP_PHONE;
    }

    public String getPhone() {
        return phone.get();
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getLogined(){
        return id.get();
    }

    public void setLogining(Employer employer) {
        this.employer = employer;
        setProerties();
    }

    private void setProerties() {
        id = employer.idProperty();
        name = employer.nameProperty();
        phone = employer.phoneProperty();
        update();
    }

    public boolean isLogined() {
        return getLogined() == 0 ? false : true;
    }

    public void free(){
        id.setValue(0);
        phone.setValue("");
        name.setValue("");
        employer = null;
    }

    @Override
    public String toString(){
        return isLogined() ?
                "Працівник: " + getLogined()
                + "\n" + name.get()
                + "\n" + phone.get() :
                "Працівник не залогований.";
    }

    public String getText(){
        return "" + getLogined();
    }

}