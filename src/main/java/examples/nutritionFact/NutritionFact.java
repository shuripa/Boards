package examples.nutritionFact;

public class NutritionFact {
    private final int servingSize;
    private final int serveings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        //Необходиміе параметры
        private final int serveingSize;
        private final int servings;

        // Необъязательные параметры –
        // инициализированы значениями по умолчанию
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder (int servingSize, int servings){
            this.serveingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val){
            calories = val;
            return this;
        }

        public Builder fat(int val){
            fat = val;
            return this;
        }

        public Builder sodium(int val){
            sodium = val;
            return this;
        }

        public Builder carbohydrate(int val){
            carbohydrate = val;
            return this;
        }

        public NutritionFact build(){
            return new NutritionFact(this);
        }
    }

    private NutritionFact(Builder builder){
        servingSize = builder.serveingSize;
        serveings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    @Override
    public String toString() {
        return "NutritionFact{" +
                "servingSize=" + servingSize +
                ", serveings=" + serveings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbohydrate=" + carbohydrate +
                '}';
    }

    public static void main(String[] args) {
        NutritionFact fact = new NutritionFact.Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();
        System.out.println(fact.toString());
    }
}
