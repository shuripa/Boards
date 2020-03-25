package graphics.leyout.components;

import inout.CompositBuilder;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Condition;

/**
 * Board - Tool
 * Властивості:
 *      - номер дошки
 *      - назва дошки
 * Поля:
 *      - умова: Condition
 * (Конструктор)
 * (Методи доступу)
 * (Інформаційний текст)
 */

public class Board extends LeyoutComponent {

    private final static String TITLE_PROP_ID = "Board Id";
    private final static String TITLE_PROP_TITLE = "Board title";
//    TODO: привести в порядок
//    @Deprecated
//    private final static String TITLE_PROP_CONDITION = "Condition";
    private final StringProperty id;
    private final StringProperty title;
//    private final StringProperty condition;
    private Condition condition;

    public Board(){
        this.id = new SimpleStringProperty(this, TITLE_PROP_ID, "" + 0);
        this.title = new SimpleStringProperty(this, TITLE_PROP_TITLE, "");
//        this.condition = new SimpleStringProperty(this, TITLE_PROP_CONDITION, "");
    }

    public void building (CompositBuilder builder){
        setId("" + builder.getId());
        setTitle(builder.getTitle());
        setCondition(builder.getConditionString(), 110);
    }


    public void setId(String id) {
        this.id.set(id);
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return this.title;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public void setCondition (String template, int step){
        this.condition = new Condition(template, 110);
    }

    public Condition getCondition(){
        return condition;
    }

//    public StringProperty conditionProperty() {
//        return condition;
//    }

    public String toString(){
        String result = "Board:";
        if (!id.getValue().equals("0")) result += "\nID = " + id.getValue();
        if (!title.getValue().equals("")) result += ";\nTitle = " + title.getValue();
        if (condition != null) result += ";\nCondition = " + condition.getConditionAsString() + ".";
        return result;
    }
}