package model;

public enum ProfessionColor {
    DELIVER,                //Канторський
    BINDER,                 //Вязальник
    TESTER,                 //Тестувальник
    BRIGADIER,              //Бригадир
    MASTER,                 //Майстер
    ENGINEER,               //Інженер
    LEADER,                 //Керівник проекту
    GROUP_MANAGER,          //Керівник групи
    DEPARTMENT_MANAGER,      //Керівник відділу
    LOCATION_MANAGER;        //Керівник локації
    @Override
    public String toString() {
        switch (this) {
            case DELIVER: return "rgba(70, 50, 160, 1.0)";
            case BINDER: return "cornflowerblue";
            case TESTER: return "mediumslateblue";
            case BRIGADIER: return "yellow";
            case MASTER: return  "rgba(255, 200, 80, 1.0)"; // "orangered";       //orange или orangered
            case ENGINEER: return "rgba(0, 50, 100, 1.0)";
            case LEADER: return "rgba(0, 50, 100, 1.0)";
            case GROUP_MANAGER: return "rgba(0, 50, 100, 1.0)";
            case DEPARTMENT_MANAGER: return "rgba(192, 192, 192, 1.0)";
            case LOCATION_MANAGER: return "rgba(25, 25, 40, 1.0)";
        }
        return super.toString();
    }
}
