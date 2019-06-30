package graphics.components;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Skill;

import java.util.ArrayList;

public class Employer extends LeyoutComponent{
    private final static String TITLE_PROP_ID = "Emploer Id";
    private final static String TITLE_PROP_NAME = "Name";
    private final static String TITLE_PROP_PHONE = "Phone";
    private final static String TITLE_PROP_SHIFT = "Shift";         //Зміна

    private final IntegerProperty id;
    private final StringProperty name;
    private final StringProperty phone;
    private final StringProperty shift;
    private final ArrayList<Skill> skills;

    public Employer(){
        this.id = new SimpleIntegerProperty(this, TITLE_PROP_ID, 0);
        this.name = new SimpleStringProperty(this, TITLE_PROP_NAME, "");
        this.phone = new SimpleStringProperty(this, TITLE_PROP_PHONE, "");
        this.shift = new SimpleStringProperty(this, TITLE_PROP_SHIFT, "");
        skills = new ArrayList<>();
    }

    public Employer(Integer id, String name, String phone, String shift){
        this.id = new SimpleIntegerProperty(this, TITLE_PROP_ID, id);
        this.name = new SimpleStringProperty(this, TITLE_PROP_NAME, name);
        this.phone = new SimpleStringProperty(this, TITLE_PROP_PHONE, phone);
        this.shift = new SimpleStringProperty(this, TITLE_PROP_SHIFT, shift);
        skills = new ArrayList<>();
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public String getShift() {
        return shift.get();
    }

    public void setShift(String shift) {
        this.shift.set(shift);
    }

    public StringProperty shiftProperty() {
        return shift;
    }

    public void setSkill(Skill skill) {
        skills.add(skill);
    }

    public ArrayList<Skill> getSkills() {
        return this.skills;
    }

    public Double getProductivity(String module){
        Double result = 25.0;
        for (Skill s: skills) {
            //TODO: Що таке матеріал шаблон??? з класу навики
            if (s.getMaterialBlank().equals(module)){
                result = s.getProductivity();
            }
        }
        return result;
    }

    public Integer getID() {
        return id.get();
    }

    @Override
    public String toString() {
        return "Employer{" +
                "id=" + id.get() +
                ", name=" + name.get() +
                ", phone=" + phone.get() +
//                ", shift=" + shift.get() +
//                ", skills=" + skills.get() +
                "}";
    }
}
