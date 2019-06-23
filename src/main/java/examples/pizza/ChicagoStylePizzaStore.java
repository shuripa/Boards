package examples.pizza;

public class ChicagoStylePizzaStore extends PizzaStore {


    @Override
    protected Pizza createPizza(String type) {

        Pizza pizza = null;

        if (type.equals("cheese")){
            pizza = new ChicagoStyleCheesePizza(new NYPizzaIngredientFactory());
        } else if (type.equals("pepperoni")){
            pizza = new ChicagoStylePepperoniPizza(new CHPizzaIngredientFactory());
        } else if (type.equals("clam")){
            pizza = new ChicagoStyleClamPizza(new NYPizzaIngredientFactory());
        } else if (type.equals("veggie")){
            pizza = new ChicagoStyleVeggiePizza(new CHPizzaIngredientFactory());
        }

        return pizza;
    }
}
