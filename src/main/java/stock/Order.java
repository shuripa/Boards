package stock;

public class Order {
    private String material;        //TODO: Материал, – пока просто unit. Изправить позже
    private Double count;       //Количество

    public Order(String material, Double count) {
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