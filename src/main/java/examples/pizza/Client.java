package examples.pizza;

public class Client {
    public static void main(String[] args) {
        //Создаем два объкта пицерий
        PizzaStore ny = new NYStylePizzaStore();
        PizzaStore ch = new ChicagoStylePizzaStore();
        //Используем один из них для выполнения заказа Итана
        ny.orderPizza("cheese");
        //А другой - для заказа Джоэла.
        ch.orderPizza("cheese");
    }
}
