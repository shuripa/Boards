package graphics.leyout.components;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TestTable extends LeyoutComponent {
    private final static String TITLE_PROP_ID = "Test Id";
    private final static String TITLE_PROP_TITLE = "Test title";

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

    private final StringProperty id;
    private final StringProperty title;

    public TestTable(){
        this.id = new SimpleStringProperty(this, TITLE_PROP_ID, "");
        this.title = new SimpleStringProperty(this, TITLE_PROP_TITLE, "");
    }

    @Override
    public String toString(){
        return "Тевтувальний стіл:\n" +
               "Назва:              " + title.get() + "\n" +
               "Номер:              " + id.get() + "\n";
    }
}
