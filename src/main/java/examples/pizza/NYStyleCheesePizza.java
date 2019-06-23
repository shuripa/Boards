package examples.pizza;

public class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza(PizzaIngredientFactory ingredientFactory){
        super(ingredientFactory);
        name = "NY Style Sauce and Cheese Pizza";
//        dough = "Thin Crust Dough";
//        sauce = "Marinara Sauce";
        toppings.add("Grated Reggiano Cheese");
    }

    @Override
    public void prepare() {

    }
}
