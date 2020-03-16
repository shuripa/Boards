package examples.movies;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name){
        _name = name;
    }

    public void addRental(Rental arg){
        _rentals.addElement(arg);
    }

    public String get_name(){
        return _name;
    }

        //TODO Исполняемые методом задачи
        //TODO 1. Начисление бонусов
        //1.1 Определение бонусов (исправлено)
        //1.2 Зависимость бонусов от типа фильма (исправлено)
        //1.3 Подсчет суммы бонусов
        //TODO 2. Сумма заказа
        //TODO 3. Формирование отчета
        //Разработка HTML отчета
    public String statement(){
        Enumeration rentals = _rentals.elements();
        String result = "Прокат " + get_name() + "\n";

        while (rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();
            //Вывод результатов для каждого проката
            result += "\t" + each.get_movie().get_title() + "\t" +
                    String.valueOf(each.getCharge()) + "\n";
        }

        //Добавление колонтитула
        result += "Сумма задолженности: " +
                String.valueOf(getTotalCharge()) + "\n";
        result += "Вы заработали " + String.valueOf(getTotalFrequentRenterPoints()) +  " бонусных очков";
        return result;
    }

    public String htmlStatement(){
        Enumeration rentals = _rentals.elements();
        String result = "<H1>Прокат <EM>" + get_name() + "</EM></H1><P>\n";
        while (rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();
            result += each.get_movie().get_title() + ": " + String.valueOf(each.getCharge())+ "<BR>\n";
        }
        //Добавление колонтитула
        result += "<P> Сумма задолженности <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
        result += "Вы заработали <EM>" + String.valueOf(getTotalFrequentRenterPoints()) + "</EM> бонусных очков <P>";
        return result;
    }

    private double getTotalCharge(){
        //Начисление бонусных очков
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints(){
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

}
