package graphics.leyout.components;

import model.Material;
import model.Order;

import java.util.ArrayList;

public class CanbanCard extends LeyoutComponent {
    String title;
    CanbanLeaf parent;

    int maxCountOrder;
    ArrayList<Order> orders;        //TODO: Нужно бы использовать очередь
    Material material;

//    @Deprecated
//    public CanbanCard(){            //TODO: Тестирование, конструктор по идее не нужен
//        this.maxCountOrder = 2;
//        orders = new ArrayList<>();
//        Order order = new Order(1252, new Material(""), 25, 20.0);
//        order = new Order(1253, new Material(""), 20, 20.0);
//        orders.add(order);
//        this.title = "";
//        this.parent = null;
//        this.material = new Material("");
//    }

    public CanbanCard(CanbanLeaf parent, String title){
        orders = new ArrayList<>();
        this.maxCountOrder = 2;
        this.title = title;
        this.parent = parent;
        this.material = new Material("");
    }

    public void setCountOrder(int countOrder) {
        this.maxCountOrder = countOrder;
    }

    public void setMaterial(Material material){
        this.material = material;
    }

    @Override
    public String toString() {
        return "";
    }

    public int getMaxCountOrder() {
        return maxCountOrder;
    }

    public int getFactCountOrder(){
        return orders.size();
    }
}
