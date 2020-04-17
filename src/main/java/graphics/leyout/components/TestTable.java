package graphics.leyout.components;

import inout.CompositBuilder;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Condition;

public class TestTable extends LeyoutComponent {
    private final static String TITLE_PROP_ID = "Test Id";
    private final static String TITLE_PROP_TITLE = "Test title";
    private final StringProperty id;
    private final StringProperty title;
    private Condition condition;

    public TestTable(){
        this.id = new SimpleStringProperty(this, TITLE_PROP_ID, "");
        this.title = new SimpleStringProperty(this, TITLE_PROP_TITLE, "");
    }

    public void building(CompositBuilder builder) {
        setId("" + builder.getId());
        setTitle(builder.getTitle());
        setCondition(builder.getConditionString(), 120);
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getTitle() {
        return title.get();
    }


    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    @Override
    public String toString(){
        return "Тевтувальний стіл:\n" +
               "Назва:              " + title.get() + "\n" +
               "Номер:              " + id.get() + "\n";
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
}
