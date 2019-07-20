package examples.pizza;

public class Client {
    public static void main(String[] args) {
        /**Created two instance pizzaStore. */
        PizzaStore ny = new NYStylePizzaStore();
        PizzaStore ch = new ChicagoStylePizzaStore();
        /** One to Itan's order */
        ny.orderPizza("cheese");
        /** Two to Joel's order */
        ch.orderPizza("cheese");
    }
}
