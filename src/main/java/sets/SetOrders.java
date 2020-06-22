package sets;

import inout.OrderLoader;
import sets.stock.Order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SetOrders {
    private static final Logger logger = Logger.getLogger("MainApp");
    private static SetOrders instance;
    private TreeMap<String, List<Order>> set;

    private SetOrders(){
        set = new TreeMap<>();
    }

    public static SetOrders getInstance(){
        if (instance == null){
            instance = new SetOrders();
            create();
        }
        return instance;
    }

    private static void create() {
        Date start = new Date();
        logger.log(Level.FINE, "Start load master store: start = " + start);
        OrderLoader loader = new OrderLoader();
        loader.load();
        Date end = new Date();
        double res = (end.getTime() - start.getTime())/1000;
        logger.log(Level.INFO, "End load master store: start = " + start + "; end = " + end + "; result = " + res);
    }

    public void add(Order order) {
        String key = order.getMaterialAsStr();
        if (set.containsKey(key)){
            set.get(key).add(order);
        } else {
            ArrayList<Order> orders = new ArrayList<>();
            orders.add(order);
            set.put(key, orders);
        }
    }

    public List<Order> getOders(String stock, String material){
        String key = material;
        if (set.containsKey(key)) {
            logger.log(Level.FINE, "To key : " + stock + " :" + material + " : " + "orders is present");
            return set.get(key);
        } else {
            logger.log(Level.FINE, "To key : " + stock + " :" + material + " : " + "orders is missing");
            return new ArrayList<Order>();
        }
    }
}
