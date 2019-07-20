package graphics.leyout.components;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import model.Order;
import sets.MAOSystem;

import java.util.ArrayList;

public class BoardIndex extends LeyoutComponent {

    private final static String TITLE_PROP_COMPLETESHIFT = "Complete shift";
    private final IntegerProperty completeShift;
    private final static String TITLE_PROP_EFFECTIVITYSHIFT = "Effectivity shift";

    private final DoubleProperty effectivityShift;

    ArrayList<Order> orders;

    Double sumProductivity;
    Double sumCapacity;
    Double sumProductivityShift;
    Double sumCapacityShift;
    String orderStr;

    public BoardIndex() {
        this.completeShift = new SimpleIntegerProperty(this, TITLE_PROP_COMPLETESHIFT, 0);
        this.effectivityShift = new SimpleDoubleProperty(this, TITLE_PROP_EFFECTIVITYSHIFT, 0);
        setParent(null);
        orders = new ArrayList<>();
    }

    public BoardIndex(LeyoutComponent parent) {
        this.completeShift = new SimpleIntegerProperty(this, TITLE_PROP_COMPLETESHIFT, 0);
        this.effectivityShift = new SimpleDoubleProperty(this, TITLE_PROP_EFFECTIVITYSHIFT, 0);
        setParent(parent);
        orders = new ArrayList<>();
    }

    public int getProc() {
        return completeShift.get();
    }

    public void setProc(int proc){
        this.completeShift.setValue(proc);
    }

    public IntegerProperty procProperty() {
        return completeShift;
    }

    public double getEffectivityShift() {
//        updateData();
        return effectivityShift.get();
    }

    public DoubleProperty effectivityShiftProperty() {
        return effectivityShift;
    }

    public void setEffectivityShift(double effectivityShift) {
        this.effectivityShift.set(effectivityShift);
    }

    public void addOrder(Order order) {
        orders.add(order);
        updateData();
    }

    public void updateData(){
        sumProductivity = 0.0;
        sumCapacity = 0.0;
        orderStr = "";
        updateOrders();

        Employer e = employer();

        for (Order o: orders) {
            Double t = (o.getCount() * o.getEtalonTime() / (e.getProductivity(o.getMaterial())/100));  //Время в минутах
            Double time = Math.ceil(t/0.6)/100;                                                                 //Время в часы
            sumProductivity = sumProductivity + time;
            sumCapacity = sumCapacity + o.getCount() * o.getEtalonTime();
            orderStr = orderStr + "\n" + o.getMaterial() + " - " + o.getCount() + " : "
                    + o.getEtalonTime() + " * " + employer().getProductivity(o.getMaterial()) + "% = "
                    + time + " год";
        }

        sumCapacityShift = Math.ceil(sumCapacity/6/8)/10;
        sumProductivityShift = Math.ceil(sumProductivity*10/8)/10;
        effectivityShift.setValue(Math.ceil(sumCapacityShift/sumProductivityShift*100*10)/10);

        update();
    }

    public void updateOrders() {
        //        Orders
        MAOSystem maosys = MAOSystem.getInstance();
        CompositMao mao = maosys.getMaoWithBoard((CompositBoard)getParent());
        this.orders = mao.getOrders(((CompositBoard)getParent()).getBoard().getConditions());
    }

    private Employer employer() {
        //        Получение скилов рабочего
        WorkPlace wp = ((CompositBoard)getParent()).getWorkPlace();
//        SetEmployers setEmployers = SetEmployers.getInstance();
//        return setEmployers.getEmployer(h.getLogined());
        return wp.getEmployer();
    }


    @Override
    public String toString(){
        updateData();
        String result = "Замовлення:";
        result = result + orderStr;
        result = result + "\n Сумарний час потужності: " + sumCapacityShift + " змін" ;
        result = result + "\n Сумарний робочий час: " + sumProductivityShift + " змін" ;
        result = result + "\n Ефективність використання р/м: " + effectivityShift.get() + "%";
        return result;
    }
}
