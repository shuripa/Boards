package model;

public class Order {
    private int id;
    private Material material;
    private double etalonTime;
    private int count;

    public Order(int id, Material material, int count, double etalonTime) {
        this.id = id;
        this.material = material;
        this.etalonTime = etalonTime;
        this.count = count;
    }

    public Material getMaterial() {
        return material;
    }

    public String getTitle() {
        return material.getTitle();
    }

    public Integer getCount() {
        return count;
    }

    public Double getEtalonTime() {
        return etalonTime;
    }

    @Override
    public String toString() {
        return  "" + id +
                ", " + material.title +
                ", " + count +
                ", " + etalonTime;
    }
}
