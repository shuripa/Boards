package leyout.components;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import leyout.controllers.CompositBoardController;
import leyout.controllers.LeyoutComponentController;
import model.Order;

import java.util.ArrayList;

public class CompositMao extends LeyoutComponent{

    private final static String TITLE_PROP_NAME = "Title";
    private final StringProperty title;

    ArrayList<String> conditions;
    ArrayList<Order> orders;

    /** General */

    public CompositMao() {
        conditions = new ArrayList<>();
        this.title = new SimpleStringProperty(this, TITLE_PROP_NAME, "MAO");
        getStrProperties().add(title);
    }

    public CompositMao(LeyoutComponentController compositMaoController) {
        super(compositMaoController);
        conditions = new ArrayList<>();
        this.title = new SimpleStringProperty(this, TITLE_PROP_NAME, "MAO");
        getStrProperties().add(title);
    }

    /** Property */

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    /** Conditions */

    public void addCondition(String condition){
        conditions.add(condition);
    }

    public void addOrder (Order order){
        orders.add(order);
    }

    @Override
    public String toString() {
        String result = title.get();

        for (String s: conditions) {
        }

        for (int i = 0; i < controller().leafsLenght(); i++) {
            if (controller().getLeaf(i) != null) {
                result = result + "\n  Дошка " + (i + 1) + " - " + ((CompositBoardController) controller().getLeaf(i)).getTitle();
                result = result + "\n    Умова " + ((CompositBoardController) controller().getLeaf(i)).getCondition();
            }
        }
        return result;
    }

}
