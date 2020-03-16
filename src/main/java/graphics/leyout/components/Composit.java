package graphics.leyout.components;

import model.Employer;
import model.Order;

import java.util.ArrayList;

public interface Composit {

    ArrayList<Order> getOrders();

    Employer getEmployer();
}
