package graphics.leyout.components;

import javafx.beans.property.*;
import model.Material;
import model.Skill;

import java.util.Collection;
import java.util.HashMap;

public class Employer extends LeyoutComponent{

    private final static String TITLE_PROP_ID = "Emploer Id";
    private final static String TITLE_PROP_NAME = "Name";
    private final static String TITLE_PROP_PHONE = "Phone";
    private final static String TITLE_PROP_ACTIVATED = "Activated";
    private final static String TITLE_PROP_SHIFT = "Shift";         //Зміна

    private final BooleanProperty activated;
    private final IntegerProperty id;
    private final StringProperty name;
    private final StringProperty phone;
    private final StringProperty shift;
    private final HashMap<String, Skill> skills;
    private WorkPlace workPlase;

    /** Constructors */
    public Employer(){
        this.id = new SimpleIntegerProperty(this, TITLE_PROP_ID, 0);
        this.name = new SimpleStringProperty(this, TITLE_PROP_NAME, "");
        this.phone = new SimpleStringProperty(this, TITLE_PROP_PHONE, "");
        this.shift = new SimpleStringProperty(this, TITLE_PROP_SHIFT, "");
        this.activated = new SimpleBooleanProperty(this, TITLE_PROP_ACTIVATED, false);
        skills = new HashMap<>();
    }

    public Employer(Integer id, String name, String phone, String shift){
        this.id = new SimpleIntegerProperty(this, TITLE_PROP_ID, id);
        this.name = new SimpleStringProperty(this, TITLE_PROP_NAME, name);
        this.phone = new SimpleStringProperty(this, TITLE_PROP_PHONE, phone);
        this.shift = new SimpleStringProperty(this, TITLE_PROP_SHIFT, shift);
        this.activated = new SimpleBooleanProperty(this, TITLE_PROP_ACTIVATED, false);
        skills = new HashMap<>();
    }

    /** Properties */

    public int getId() {
        return id.getValue();
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

    public boolean isActivated() {
        return activated.get();
    }

    public BooleanProperty activatedProperty() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated.set(activated);
    }

    public void setSkill(Skill skill) {
        if (skills.containsKey(skill.getMaterialBlank())) {
            Skill s = skills.get(skill.getMaterialBlank());
            s.setProductivity(skill.getProductivity());
        } else {
            skills.put(skill.getMaterialBlank(), skill);
        }
    }

    public Collection<Skill> getSkills() {
        return this.skills.values();
    }

    public Double getProductivity(Material module){
        Double result = 25.0;
        for (Skill s: skills.values()) {
            if (s.Like(module.getTitle())){
                return s.getProductivity();
            }
        }
        return result;
    }

    public Integer getID() {
        return id.get();
    }

    public WorkPlace getWorkPlase() {
        return workPlase;
    }

    public void setWorkPlace(WorkPlace workPlase) {
        this.workPlase = workPlase;
    }

    /** Overrides */

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

    public void free() {
        setWorkPlace(null);
    }
}