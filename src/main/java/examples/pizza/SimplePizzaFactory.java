package examples.pizza;

public class SimplePizzaFactory {
    public Pizza createPizza(String type){
        Pizza pizza = null;

        if (type.equals("cheese")){
            pizza = new CheesePizza(new NYPizzaIngredientFactory());
        } else if (type.equals("pepperoni")){
            pizza = new PepperoniPizza(new NYPizzaIngredientFactory());
        } else if (type.equals("clam")){
            pizza = new ClamPizza(new NYPizzaIngredientFactory());
        } else if (type.equals("veggie")){
            pizza = new VeggiePizza(new NYPizzaIngredientFactory());
        }

        return pizza;
    }
}
