package examples.pizza;

import java.util.ArrayList;

public abstract class Pizza {
    String name;
    Dough dough;    // тип основы
    Sauce sauce;    // соус
    Cheese cheese;  // сыр
    Clams clam;     // мидии
    ArrayList<String> toppings = new ArrayList();   // набор добавок
    PizzaIngredientFactory ingredientFactory;

    public Pizza(PizzaIngredientFactory ingredientFactory){
        this.ingredientFactory = ingredientFactory;
    }

    public abstract void prepare();
//    {
//        System.out.println("Preparing ....." + name);
//        System.out.println("Tossing dough ." + dough);
//        System.out.println("Adding sauce .." + sauce);
//        System.out.println("Adding toppings:");
//        for (String t: toppings) {
//            System.out.println("   - " + t);
//        }
//    }

    public void bake(){
        System.out.println("Bake for 25 minutes at 350 degree");
    }

    public void cut(){
        System.out.println("Cutting the pezza into diagonal slices");
    }

    public void box(){
        System.out.println("Place pizza in official PizzaStore box");
        System.out.println("");
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
     this.name = name;
    }
}
