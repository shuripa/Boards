package graphics.leyout.components;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Condition;
import model.Employer;

public class Board extends LeyoutComponent {

    private final static String TITLE_PROP_ID = "Board Id";
    private final static String TITLE_PROP_TITLE = "Board title";
    private final static String TITLE_PROP_CONDITION = "Condition";
    private final StringProperty id;
    private final StringProperty title;
    private final StringProperty condition;


    public Board(){
        this.id = new SimpleStringProperty(this, TITLE_PROP_ID, "" + 0);
        this.title = new SimpleStringProperty(this, TITLE_PROP_TITLE, "");
        this.condition = new SimpleStringProperty(this, TITLE_PROP_CONDITION, "");
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getId() {
        return id.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getTitle() {
        return title.get();
    }

    @Deprecated
    public void setCondition(String condition) {
        //TODO: оставлено для совместимости. Удалить.
//        this.condition.set(condition);
        addCondition(new Condition(condition, 110));
    }

    public void setCondition(Condition condition){
        addCondition(condition);
    }

    public String getCondition() {
        return condition.get();
    }

    public StringProperty idProperty() {
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

    @Override
    public void logining(Employer employer) {

    }
}