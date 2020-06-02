package graphics.leyout.components;

import inout.CompositBuilder;
import inout.MaoQueryOrderLoader;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Condition;
import model.Order;
import model.Orders;
import sets.MAOSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Требования:
 * <p>1. {@code id} номер состоит из 1000 для SB, 2000 для MB и 3000 для конвеера  + N фактический номер синглборда или мультиборда
 * <p>2. CompositMao содержит доски
 * <p>4. Условия для заказов хранятся в досках которые входят в МАОComponent
 * <p>5. Все {@code МАОComponent}-ы хрянятся в {@code MAOSystem}
 * <p>6. Компоненты на лейауте должны быть на переднем фронте
 */
public class CompositMao extends LeyoutComponent{

    private final static String TITLE_PROP_NAME = "MAO title";
    private final StringProperty title;
    //    ArrayList<String> conditions;
    //TODO: Разработан объек Orders использовать его
    ArrayList<Order> orders;
    @Deprecated //Использовать массив leafs из суперкласса
    ArrayList<CompositBoard> boards;
    private final Logger logger = Logger.getLogger("MainApp");
//            LoggerFactory.getLogger(CompositMao.class.getName());

    /* General */

    public CompositMao() {
        this.title = new SimpleStringProperty(this, TITLE_PROP_NAME, "MAO");
//        conditions = new ArrayList<>();
        orders = new ArrayList<>();
        boards = new ArrayList<>();
//        getStrProperties().add(title);
        logger.fine("Creating with default");
    }

    public CompositMao(CompositBuilder builder){
        this.title = new SimpleStringProperty(this, TITLE_PROP_NAME, "MAO");
        setTitle(builder.getTitle());
//        conditions = builder.getConditions();
        orders = new ArrayList<>();
        boards = new ArrayList<>();
        MAOSystem maoSystem = MAOSystem.getInstance();
        maoSystem.addCompositMao(this);
        logger.fine("Creating with builder");
    }

    /* Property */

    public void setTitle(String title) {
        this.title.set(title);
        update();
        try {
            MaoQueryOrderLoader qLoader = MaoQueryOrderLoader.getInstance();
            orders = qLoader.getOrders(title);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.fine("Title : " + title);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    /* Conditions */

//    public void addCondition(String condition){
//        conditions.add(condition);
//        update();
//    }

    /* Orders */

    public void addOrder (Order order){
        update();
        orders.add(order);
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public ArrayList<Order> orderToBoard(Condition condition){
        ArrayList<Order> result = new ArrayList<>();
        for (Order o: orders) {
//            TODO: получение списка заказов соответствующих условию. Сделать проверку.
            if (condition.isLike(o.getMaterial().getTitle(), 110)) {
                result.add(o);
            }
        }
        return result;
    }

    public Orders orders(Condition condition){
        Orders result = new Orders();
        for (Order o: orders) {
//            TODO: получение списка заказов соответствующих условию. Сделать проверку.
            if (condition.isLike(o.getMaterial().getTitle(), 110)) {
                result.addOrder(o);
            }
        }
        return result;
    }

    /* Boards */

    public void addBoard(CompositBoard board) {
        boards.add(board);
        addLeaf(board);
        logger.fine("Add board : " + this.getTitle() + " -> " + board.getTitle());
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

//        for (String s: conditions) {
//            result = result +"\n Умова: " + s;
//        }

        for (int i = 0; i < leafsLenght(); i++) {
            result = result;
                    
            if (getLeaf(i) != null) {
                result = result + "\n  Дошка " + (i + 1) + " - " + (((CompositBoard)getLeaf(i)).getTitle());
                result = result + "\n    Умова " + (((CompositBoard)getLeaf(i)).condition().getConditionAsString());
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