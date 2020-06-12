package sets.stock;

import model.Material;

public class Order {
    private Material material;
    private Integer count;       //Количество

    public Order(Material material, Integer count) {
        this.material = material;
        this.count = count;
    }

    public Material getMaterial() {
        return material;
    }

    public Integer getCount() {
        return count;
    }
}
