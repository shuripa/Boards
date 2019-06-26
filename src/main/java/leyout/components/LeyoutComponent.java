package leyout.components;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import leyout.controllers.LeyoutComponentController;

import java.util.ArrayList;

public abstract class LeyoutComponent {
    private LeyoutComponentController controller;

    public LeyoutComponent(LeyoutComponentController controller){
        this.controller = controller;
    }

    public LeyoutComponent() {
    }

    public LeyoutComponentController controller(){
        return controller;
    }

    public void setStrProperties(StringProperty stringProperty) {
        getStrProperties().add(stringProperty);
    }

    @Override
    public abstract String toString();

    public void setController(LeyoutComponentController controller) {
        this.controller = controller;
    }

    public ArrayList<IntegerProperty> getIntProperties() {
        return controller().getIntProperties();
    }

    public ArrayList<StringProperty> getStrProperties() {
        return controller().getStrProperties();
    }
}
