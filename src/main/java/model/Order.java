package model;

public class Order {
    private int id;
    private String title;
    private double etalonTime;
    private int count;

    @Override
    public String toString() {
        return  "" + id +
                ", " + title +
                ", " + count +
                ", " + etalonTime;
    }

    public Order(int id, String name, int count, double etalonTime) {
        this.id = id;
        this.title = name;
        this.etalonTime = etalonTime;
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public Integer getCount() {
        return count;
    }

    public Double getEtalonTime() {
        return etalonTime;
    }
}
