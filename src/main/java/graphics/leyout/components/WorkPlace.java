package graphics.leyout.components;

import model.Employee;
import model.Profession;
import model.Side;

public class WorkPlace extends LeyoutComponent {

    /**
     * WorkPlace - WorkPosition
     * ТЗ: Робоча позиція відображає місце куди може бути залогований працівник, або працівника,
     * який залогований. При наведенні мишки на карточку працівника підсвічуються всі робочі місця,
     * куди може бути залогований працівник. Кольором виділяються пріоритети куди і чому в першу
     * чергу потрібно логувати працівника. При натисканні правої клавіші миші в інформмітці
     * відображається інформація про працівника.
     * Також повинна бути можливість:
     * - вилогувати працівника за допомогою контекстного меню, – кнопка "free"
     * - вибрати зі списку всіх працівників, що підходять для робочого місця, або вільних працівника
     * і залогувати його. Список повинен бути відсортований по трьох категоріях. "Закріплені",
     * "Ті що мають навички", "Всі інші".
     *
     * Фіксується час логування і вилоговування працівника. Страрт і фініш кожного продукту.
     * Звіт про виконані замовлення у вигляді діаграми ганта.
     *
     * Приоритеты определены в WorkPlacedComposit и могут быть переопределены в дочерних классах.
     * Приоритеты хранятся в классе рабочего места, т.к. именно для него они имеют смысл.
     * Список обоснований приоритетов не окончательный.
     *
     * 0 - ничего удовлетворяющего условиям приоритетов
     * 1 - светлозеленый    - закрепленное рабочее место
     * 2 - темно-зеленый    - место не закреплено но есть навыки
     * 3 -
     * 4 - темно-желтый     - есть навыки но другая професия
     * 5 -
     * 6 -
     * 7 -
     * 8 - красный          - любое свободное место на проекте
     * 9 - обычный серый    - не используется так как использован при обычном выделении
     * хотя для обычного выделения можно установить и 10 или пересмотреть 0
     */



    private Employee employee;
    int priority;

    Side side;
    Profession profession;

    //Простое создание используется в тестах
    public WorkPlace(){
    }

    public WorkPlace(WorkPlacedComposit parent, Profession profession){
        setParent(parent);
        priority = 1;
        this.side = Side.DOWN;
        this.profession = profession;
    }

    public WorkPlace(LeyoutComponent parent, Profession profession, Side side){
        setParent(parent);
        priority = 1;
        this.profession = profession;
        this.side = side;
    }

    public Employee getEmployee() {
        return employee;
    }

    public boolean isLogined() {
        return employee == null ? false : true;
    }

    public String getLogined(){
        return employee == null ? "0" : employee.getId();
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Side getSide(){
        return side;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setEmployee(Employee employee) {
        Employee temp = this.employee;
        if (temp != null) temp.free();
        this.employee = employee;
        this.employee.setWorkPlace(this);
        if (parent() != null)
        priority = ((WorkPlacedComposit)this.parent()).getPriorityToEmployer(this.employee);
        update();
    }

    public void setEmployerWithPriority(Employee employee, int priority){
        this.priority = priority;
        setEmployee(employee);
    }

    public void free(){
        if (employee != null) {
            Employee e = employee;
            employee = null;
            if (e.getWorkPlaсe() != null) e.free();
        }
        update();
    }

    @Override
    public String toString(){
        return isLogined()
                ? "Employer: " + employee.getId()
                + "\n" + employee.getName()
                + "\n" + employee.getPhone()
                : "Emloyer isn't logined.";
    }

    public String getText(){
        return "" + getLogined();
    }

}