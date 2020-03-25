package model;

import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.components.WorkPlacedComposit;
import graphics.leyout.components.WorkPlace;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Employee extends LeyoutComponent {

    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty phone;
    private final StringProperty shift;
    private Profession profession;
    private final HashMap<String, Skill> skills;

    private WorkPlace workPlace;
    private ArrayList<String> bindWorkPlace;
    private final BooleanProperty activated;

    private final static String TITLE_PROP_ID = "Emploer Id";
    private final static String TITLE_PROP_NAME = "Name";
    private final static String TITLE_PROP_PHONE = "Phone";
    private final static String TITLE_PROP_SHIFT = "Shift";         //Зміна
    private final static String TITLE_PROP_PROFESSION = "Profession";
    private final static String TITLE_PROP_ACTIVATED = "Activated";


    /* Constructors */
    //Создается классом EmployeesCsvLoader, чем и обусловлена длинная форма конструктора далее используется в тестах. Больше нигде.
    public Employee(String id, String name, String phone, String shift, Profession profession, String project, String ... bindWorkPlace){
        this.id = new SimpleStringProperty(this, TITLE_PROP_ID, id);
        this.name = new SimpleStringProperty(this, TITLE_PROP_NAME, name);
        this.phone = new SimpleStringProperty(this, TITLE_PROP_PHONE, phone);
        this.shift = new SimpleStringProperty(this, TITLE_PROP_SHIFT, shift);
        this.activated = new SimpleBooleanProperty(this, TITLE_PROP_ACTIVATED, false);
        skills = new HashMap<>();
        this.profession = profession;
        this.bindWorkPlace = new ArrayList<>();
        for (String s: bindWorkPlace) {
            this.bindWorkPlace.add(s);
        }
    }

    /* Properties */
    //Предполагается что id не изменяется, поэтому сеттера нету.
    public String getId() {
        return id.getValue();
    }

    public StringProperty idProperty() {
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

    public ArrayList<String> getBindWorkPlaces() {
        return bindWorkPlace;
    }

    public boolean isActivated() {
        return activated.get();
    }

    public boolean isLogined(){
        return (workPlace != null) ? true: false;
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
            s.setProductivity(skill.getProductivity());     //Старая продуктивность заменяется новой
        } else {
            skills.put(skill.getMaterialBlank(), skill);    //Добавляется новый елемент продуктивности
        }
    }

    //Получение всех скилов.
    public Collection<Skill> getSkills() {
        return this.skills.values();
    }

    public ArrayList<Skill> getSortedSkills(){
        Skill[] result = new Skill[skills.keySet().size()];
        for (Skill s: skills.values()) {
            for (int i = 0; i<result.length; i++) {
                if (result[i] == null){
                    result [i] = s; break;
                }else{
                    if (s.getProductivity() < result[i].getProductivity()){
                        int j = i+1;
                        Skill temp = result[i];
                        while (result[j] != null){
                            temp = result[j];
                            result[j] = result[j-1];
                            j++;
                        }
                        result[j] = temp;
                        result[i] = s; break;
                    }
                }
            }
        }
        ArrayList<Skill> listResult = new ArrayList<>();
        for (int i = result.length; i > 0; i--) {
            listResult.add(result[i-1]);
        }
        return listResult;
    }

    public Double productivity(Material module){
        Double result = 25.0;
        for (Skill s: skills.values()) {
            if (s.isLike(module.getTitle(), s.getStep())){
//                System.out.println("skill: " + s.getMaterialBlank() + "; prod:" + s.getProductivity());
                return s.getProductivity();
            }
        }
        return result;
    }

//    Существование метода обусловлено не типом выходных данных а типом параметра метода
    public int getProductivity (WorkPlacedComposit component){
        int count = 0;
        int result = 0;
        double prod = 0;

            for (Skill sk: this.getSkills()) {
                if (component.getCondition() != null)
                if (component.getCondition().isLike(sk)) {
                    prod = prod + sk.getProductivity();
                    count++;
//                    System.out.println("prod: " + prod + "; count: " + count );
                }
            }

        if (count != 0) result = (int) Math.ceil(prod / count);
        return result;
    }

    public WorkPlace getWorkPlaсe() {
        return workPlace;
    }

    public void setWorkPlace(WorkPlace workPlace) {
        if (this.workPlace != null) this.workPlace.free();
        this.workPlace = workPlace;
        if (this.workPlace.getEmployee() != this) this.workPlace.setEmployee(this);
        update();
    }

    public void free() {
        if (workPlace != null) {
            WorkPlace wp = workPlace;
            workPlace = null;
            if (wp.getEmployee() != null) wp.free();
        }
        update();
    }

    public Profession getProfession() {
        return profession;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id.get() +
                ", name=" + name.get() +
                ", phone=" + phone.get() +
                ", shift=" + shift.get() +
//                ", skills=" + skills.get() +
                "}";
    }
}