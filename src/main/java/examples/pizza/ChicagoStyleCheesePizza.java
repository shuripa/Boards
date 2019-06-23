package examples.pizza;

public class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza(PizzaIngredientFactory ingredientFactory){
        super(ingredientFactory);
        name = "CH Style Deep Dish Cheese Pizza";
//        dough = "Extra Thick Crust Dough";
//        sauce = "Pulm Tomato Sauce";
        toppings.add("Sharedded Mozzarella Cheese");
    }

    @Override
    public void prepare() {

    }

    @Override
    public void cut(){
        System.out.println("Cutting the pizza into square slices");
    }
}
