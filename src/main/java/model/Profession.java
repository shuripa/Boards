package model;

public enum Profession {
    DELIVER,                //Канторський
    BINDER,                 //Вязальник
    TESTER,                 //Тестувальник
    BRIGADIER,              //Бригадир
    MASTER,                 //Майстер
    ENGINEER,               //Інженер
    LEADER,                 //Керівник проекту
    GROUP_MANAGER,          //Керівник групи
    DEPARTMENT_MANAGER,     //Керівник відділу
    LOCATION_MANAGER;       //Керівник локації
    @Override
    public String toString() {
        switch (this) {
            case DELIVER: return "Канторський";
            case BINDER: return "В’язальник";
            case TESTER: return "Тестувальник";
            case BRIGADIER: return "Бригадир";
            case MASTER: return "Майстер";
            case ENGINEER: return "Інженер";
            case LEADER: return "Кер.проекту";
            case GROUP_MANAGER: return "Кер.групи";
            case DEPARTMENT_MANAGER: return "Кер.відділу";
            case LOCATION_MANAGER: return "Кер.локації";
        }
        return super.toString();
    }
}
