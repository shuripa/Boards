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
    DEPARTMENT_MANAGER;      //Керівник відділу
    @Override
    public String toString() {
        switch (this) {
            case DELIVER: return "slateblue";
            case BINDER: return "cornflowerblue";
            case TESTER: return "blueviolet";
            case BRIGADIER: return "yellow";
            case MASTER: return "orangered";       //orange или orangered
            case ENGINEER: return "navy";
            case LEADER: return "navy";
            case GROUP_MANAGER: return "navy";
            case DEPARTMENT_MANAGER: return "grey";
        }
        return super.toString();
    }
}
