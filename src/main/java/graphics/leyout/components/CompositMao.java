package graphics.leyout.components;

import inout.MaoQueryOrderLoader;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Condition;
import model.Order;

import java.io.IOException;
import java.util.ArrayList;

public class CompositMao extends LeyoutComponent{

    private final static String TITLE_PROP_NAME = "MAO title";
    private final StringProperty title;
    ArrayList<String> conditions;
    ArrayList<Order> orders;
    ArrayList<CompositBoard> boards;

    /** General */

    public CompositMao() {
        this.title = new SimpleStringProperty(this, TITLE_PROP_NAME, "MAO");
        conditions = new ArrayList<>();
        orders = new ArrayList<>();
        boards = new ArrayList<>();

//        getStrProperties().add(title);
    }

    /** Property */

    public void setTitle(String title) {
        this.title.set(title);
        update();
        try {
            MaoQueryOrderLoader qLoader = MaoQueryOrderLoader.getInstance();
            orders = qLoader.getOrders(title);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public ArrayList<Order> getOrders(ArrayList<Condition> conditions){
        ArrayList<Order> result = new ArrayList<>();
        for (Order o: orders) {
//            TODO: получение списка заказов соответствующих условию. Сделать проверку.
            for (Condition c: conditions) {
                if (c.Like(o.getMaterial().getTitle(), 110)) {
                    result.add(o);
                }
            }
        }
        return result;
    }

    /** Boards */

    public void addBoard(CompositBoard board) {
        boards.add(board);
    }

    public boolean isContainBoard (CompositBoard board) {
        boolean result = false;
        for (CompositBoard b: boards) {
            if (board == b){
                result = true;
            }
        }
        return result;
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

        for (Order o: orders) {
            result = result + "\n Order: " + o.toString();
        }

        for (CompositBoard b : boards) {
            result = result + "\n Board: " + b.getBoard().getId() + " " + b.getBoard().getTitle();
        }
        return result;
    }

}
