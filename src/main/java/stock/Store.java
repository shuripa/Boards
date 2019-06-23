package stock;

import java.util.ArrayList;

//количество чего либо имеющее местоположение
public class Store {            //достаток, клажа, припас, склад, запас, крамниця
    //TODO: изменить тип на Material
    String material;
    Double count;
    //TODO: Запас должен содержать набор от 1 до 4... заказов. Продолжить мысль позже.
    ArrayList<Order> orders;

    public Store(String material, Double count){
        this.material = material;
        this.count = count;
    }

    public String getMaterial() {
        return material;
    }

    public Double getCount() {
        return count;
    }
}
