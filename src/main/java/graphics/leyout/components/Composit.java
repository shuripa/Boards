package graphics.leyout.components;

import model.Employee;
import model.Order;

import java.util.ArrayList;

public interface Composit {

    ArrayList<Order> getOrders();

    Employee getEmployer();
}
