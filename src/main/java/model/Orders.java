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

    public double agrEmployerTime(Employer employer){                                                                                    //Сумма продуктивности. Не указано что это.
        double result =.0;
        update();
        for (Order order : orders) {
            result += order.employerTime(employer);
        }
        return result;
    }

    public double agrEmployerTimeToShift(Employer employer, int shift){                                                                             //Сумма мощности за смену. Нет комментария с формулой
        return Math.ceil(agrEmployerTime(employer) * 10 / 8) / 10;
    }

    public String  tableRecords(Employer employer){                                                                                    //формирует таблицу Материал - Количество - Еталонное время - Продуктивность % - Время необходимое работнику
        update();
        String result = "";
        if (employer != null) {
            for (Order order: orders) {
                result = result + order.orderRecord(employer);
            }
        }
        if (result.equals("")) result = "/n Замовлення відсутні";
        return result;
    }

    public String orderSummaryBlock(Employer employer){
        String result = "";
        result += "\n Сумарний час потужності: " + totalEtalonTimeToShift(480) + " змін" ;
        result += "\n Сумарний робочий час: " + agrEmployerTimeToShift(employer, 480) + " змін" ;
        return result;
    }

    public void update(){

    }
}
