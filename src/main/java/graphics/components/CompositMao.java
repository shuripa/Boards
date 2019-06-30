package graphics.components;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Order;

import java.util.ArrayList;

public class CompositMao extends LeyoutComponent{

    private final static String TITLE_PROP_NAME = "MAO title";
    private final StringProperty title;
    ArrayList<String> conditions;
    ArrayList<Order> orders;

    /** General */

    public CompositMao() {
        this.title = new SimpleStringProperty(this, TITLE_PROP_NAME, "MAO");
        conditions = new ArrayList<>();
        orders = new ArrayList<>();
//        getStrProperties().add(title);
    }

    /** Property */

    public void setTitle(String title) {
        this.title.set(title);
        update();
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
        update();
    }

    /** Orders */

    public void addOrder (Order order){
        update();
        orders.add(order);
    }

    @Override
    public String toString() {
        String result = title.get();

        for (String s: conditions) {
        }

        for (int i = 0; i < leafsLenght(); i++) {
            if (getLeaf(i) != null) {
                result = result + "\n  Дошка " + (i + 1) + " - " + (((CompositBoard)getLeaf(i)).getTitle());
                result = result + "\n    Умова " + (((CompositBoard)getLeaf(i)).getCondition());
            }
        }
        return result;
    }

}
