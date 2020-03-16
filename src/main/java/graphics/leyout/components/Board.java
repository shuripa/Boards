package graphics.leyout.components;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Condition;

public class Board extends LeyoutComponent {

    private final static String TITLE_PROP_ID = "Board Id";
    private final static String TITLE_PROP_TITLE = "Board title";
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


    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Condition getCondition(){
        return condition;
    }


    public StringProperty idProperty() {
        return id;
    }

    public StringProperty titleProperty() {
        return title;
    }

//    public StringProperty conditionProperty() {
//        return condition;
//    }

    public String toString(){
        return "Board:\nID = " + id.get() +";\nTitle = " + title.get() + ";\nCondition = " + condition.getConditionString();
    }
}