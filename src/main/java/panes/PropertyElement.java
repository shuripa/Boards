package panes;

import javafx.beans.property.SimpleStringProperty;

public class PropertyElement {
    private SimpleStringProperty title;
    private SimpleStringProperty value;
    private SimpleStringProperty type;

    public PropertyElement (String title, String value, String type){
        this.title = new SimpleStringProperty(title);
        this.value = new SimpleStringProperty(value);
        this.type = new SimpleStringProperty(type);
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getValue() {
        return value.get();
    }

    public SimpleStringProperty valueProperty() {
        return value;
    }

    public void setValue(String value) {
        this.value.set(value);
    }

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

}