package sets.stock;

import java.util.ArrayList;

//Store очень похоже на Order так как содержит материал и количество, однако Order содержит и другую информацию
//Store не может быть заказом или частью заказа так как заказ неделим а Store содержит операцию убавления.
//Order становится Store, когда перемещается с канбана на позицию.

//Store используется как компонент передачи связки данных {Material, Integer} а надо эту связку передавать.
//Я просто спрашиваю вот тебе материал скажи сколько его есть? и получаю результат.

//Количество чего либо
public class Reserve {            //достаток, клажа, припас, склад, запас, крамниця
    //TODO: изменить тип на Material
    String material;
    Double count;
    //TODO: Запас должен содержать набор от 1 до 4... заказов. Продолжить мысль позже.
    //    Заказ должен быть очередью
    ArrayList<Order> orders;

    public Reserve(String material, Double count){
        this.material = material;
        this.count = count;
    }

    public String getMaterial() {
        return material;
    }

    public Double getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "" + material + " " + count;
    }

    public void degCount() {
        count--;
    }
}
