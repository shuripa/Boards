package leyout.components;

import model.Employer;
import model.Order;
import sets.SetEmployers;

import java.util.ArrayList;

public class BoardIndex extends LeyoutComponent {

    int proc;
    LeyoutComponent parent;
    ArrayList<Order> orders;

    public BoardIndex() {
        orders = new ArrayList<>();
    }

    public int getProc() {
        return proc;
    }

    public void setProc(int proc){
        this.proc = proc;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public String toString(){
        String result = "Замовлення:";
        Double sumProductivity = 0.0;
        Double sumCapacity = 0.0;
//        Получение скилов рабочего
        LeyoutComponent lgc = parent;
        Human h = ((CompositBoard)parent).getHuman();
        SetEmployers setEmployers = SetEmployers.getInstance();
        Employer e = setEmployers.getEmployer(h.getLogined());

        for (Order o: orders) {
            Double t = (o.getCount() * o.getEtalonTime() / (e.getProductivity(o.getTitle())/100));  //Время в минутах
            Double time = Math.ceil(t/0.6)/100;                                                     //Время в часы
            sumProductivity = sumProductivity + time;
            sumCapacity = sumCapacity + o.getCount() * o.getEtalonTime();
            result = result + "\n" + o.getTitle() + " - " + o.getCount() + " : "
                    + o.getEtalonTime() + " * " + e.getProductivity(o.getTitle()) + "% = "
                    + time + " год";
        }
        result = result + "\n Сумарний час потужності: " + Math.ceil(sumCapacity/6/8)/10 + " змін" ;
        result = result + "\n Сумарний робочий час: " + Math.ceil(sumProductivity*10/8)/10 + " змін" ;

        return result;
    }
}
