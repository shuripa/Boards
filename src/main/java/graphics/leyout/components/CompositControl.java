package graphics.leyout.components;

import inout.CompositBuilder;
import inout.MaoQueryOrderLoader;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Condition;
import model.Order;
import model.Orders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * Требования:
 * МАО, Control
 * <p>1. {@code id} номер состоит из 1000 для SB, 2000 для MB и 3000 для конвеера  + N фактический номер синглборда или мультиборда
 * <p>2. CompositMao содержит доски
 * <p>4. Условия для заказов хранятся в досках которые входят в МАОComponent
 * <p>5. Все {@code МАОComponent}-ы хрянятся в {@code MAOSystem}
 * <p>6. Компоненты на лейауте должны быть на переднем фронте
 */

//TODO: компонент не укладывается в схему он не WorkPlaced
public class CompositControl extends WorkPlacedComposit{

    private final static String TITLE_PROP_NAME = "MAO title";
    private final StringProperty title;
    //    ArrayList<String> conditions;
    //TODO: Разработан объек Orders использовать его
    ArrayList<Order> orders;
    @Deprecated //Использовать массив leafs из суперкласса
    ArrayList<CompositTool> tools;
    private final Logger logger = Logger.getLogger("MainApp");
//            LoggerFactory.getLogger(CompositMao.class.getName());

    /* General */

    Control control;

    public CompositControl() {
        this.title = new SimpleStringProperty(this, TITLE_PROP_NAME, "MAO");
//        conditions = new ArrayList<>();
        orders = new ArrayList<>();
        tools = new ArrayList<>();
//        getStrProperties().add(title);
        control = new Control();
        logger.fine("Creating with default");
    }

    public CompositControl(CompositBuilder builder){
        this.title = new SimpleStringProperty(this, TITLE_PROP_NAME, "MAO");
        setTitle(builder.getTitle());
//        conditions = builder.getConditions();
        orders = new ArrayList<>();
        tools = new ArrayList<>();
        control = new Control();
//        MAOSystem maoSystem = MAOSystem.getInstance();
//        maoSystem.addCompositMao(this);
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

    @Override
    public WorkPlace getWorkPlace() {
        return null;
    }

    @Override
    public int getCountFreeWorkPlace() {
        return 0;
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

    public void addTool(CompositTool tool) {
        tools.add(tool);
        addLeaf(tool);
        logger.fine("Add board : " + this.getTitle() + " -> " + tool.getTitle());
    }


    public LeyoutComponent getTool() {
        return control;
    }

    public boolean isContainTool(CompositTool tool) {
        boolean result = false;
        for (CompositTool t : tools) {
            if (tool == t){
                result = true;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String result = title.get();

        for (CompositTool t : tools) {
            result = result + "\n Дошка: \n" + t.getTool().getId() + " " + t.getTool().getTitle();
            result = result + "\n Умови: \n" + t.getInstructions().toString();
            for (Order o: orders) {
                result = result + "\n Замовлення: \n" + o.toString();
            }
        }
        return result;
    }
}