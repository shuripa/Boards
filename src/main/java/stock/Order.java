package stock;

@Deprecated
public class Order {
    private String material;        //TODO: Material is easy string. Fix later.
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
