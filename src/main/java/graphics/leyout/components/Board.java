package graphics.leyout.components;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Condition;

public class Board extends LeyoutComponent {

    private final static String TITLE_PROP_ID = "Board Id";
    private final static String TITLE_PROP_TITLE = "Board title";
    private final static String TITLE_PROP_CONDITION = "Condition";
    private final IntegerProperty id;
    private final StringProperty title;
    private final StringProperty condition;


    public Board(){
        this.id = new SimpleIntegerProperty(this, TITLE_PROP_ID, 0);
        this.title = new SimpleStringProperty(this, TITLE_PROP_TITLE, "");
        this.condition = new SimpleStringProperty(this, TITLE_PROP_CONDITION, "");
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getId() {
        return id.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getTitle() {
        return title.get();
    }

    public void setCondition(String condition) {
        //TODO: оставлено для совместимости. Удалить.
        this.condition.set(condition);

        addCondition(new Condition(condition));
    }

    public String getCondition() {
        return condition.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty titleProperty() {
        return title;
    }

    public StringProperty conditionProperty() {
        return condition;
    }

    public String toString(){
        return "Board:\nID = " + id.get() +";\nTitle = " + title.get() + ";\nCondition = " + condition.get();
    }
}