package model;

import java.util.ArrayList;

public class Orders {
    private ArrayList<Order> orders;

    public Orders() {
        orders = new ArrayList<>();
    }

    public void addOrder(Order order){
        this.orders.add(order);
    }

    public double totalEtalonTime(){
        double result = 0;
        update();
        for (Order o: orders) {
            result += o.totalEtalonTime();
        }
        return result;
    }

    public double totalEtalonTimeToShift(int shift){
        return Math.ceil(totalEtalonTime() / 6 / 8) / 10;                                                                 //рассчитывает общую мощность рабочего места за смену
    }

    public double agrEmployerTime(Employee employee){                                                                                    //Сумма продуктивности. Не указано что это.
        double result =.0;
        update();
        for (Order order : orders) {
            result += order.employerTime(employee);
        }
        return result;
    }

    public double agrEmployerTimeToShift(Employee employee, int shift){                                                                             //Сумма мощности за смену. Нет комментария с формулой
        return Math.ceil(agrEmployerTime(employee) * 10 / 8) / 10;
    }

    public String  tableRecords(Employee employee){                                                                                    //формирует таблицу Материал - Количество - Еталонное время - Продуктивность % - Время необходимое работнику
        update();
        String result = "";
        if (employee != null) {
            for (Order order: orders) {
                result = result + order.orderRecord(employee);
            }
        }
        if (result.equals("")) result = "/n Замовлення відсутні";
        return result;
    }

    public String orderSummaryBlock(Employee employee){
        String result = "";
        result += "\n Сумарний час потужності: " + totalEtalonTimeToShift(480) + " змін" ;
        result += "\n Сумарний робочий час: " + agrEmployerTimeToShift(employee, 480) + " змін" ;
        return result;
    }

    public void update(){

    }
}
