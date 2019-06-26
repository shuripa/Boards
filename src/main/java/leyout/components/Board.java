package leyout.components;

        import javafx.beans.property.IntegerProperty;
        import javafx.beans.property.SimpleIntegerProperty;
        import javafx.beans.property.SimpleStringProperty;
        import javafx.beans.property.StringProperty;
        import leyout.controllers.BoardController;

public class Board extends LeyoutComponent {

    private final static String TITLE_PROP_ID = "ID";
    private final static String TITLE_PROP_TITLE = "TITLE";
    private final static String TITLE_PROP_CONDITION = "CONDITION";
    private final IntegerProperty id;
    private final StringProperty title;
    private final StringProperty condition;

//    int id;
//    String title;
//    String condition;

    public Board(BoardController controller, int id, String title) {
        super(controller);
        this.id = new SimpleIntegerProperty(this, TITLE_PROP_ID, id);
        this.title = new SimpleStringProperty(this, TITLE_PROP_TITLE, title);
        this.condition = new SimpleStringProperty(this, TITLE_PROP_CONDITION, "");
        getIntProperties().add(this.id);
        getStrProperties().add(this.title);
        getStrProperties().add(this.condition);

    }

    public void setID(int id) {
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
        this.condition.set(condition);
    }

    public String getCondition() {
        return condition.get();
    }

    public String toString(){
        return "Дошка:\nID = " + id.get() +";\nTitle = " + title.get() + ";\nCondition = " + condition.get();
    }
}