package sets.stock;

public class Storage {
    private String material;
    private String position;
    private Stock stock;

    public Storage(String stock, String material, String position) {
        this.material = material;
        this.position = position;
        this.stock = StockSet.getInstance().getStock(stock);
    }

    protected void changeMaterial(String material){
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public String getPosition() {
        return position;
    }

    public Stock getStock(){
        return stock;
    }

    public Double getCount(){
        return .0;
    };

    public String key(){
        //Position:Material
        return position + ":" + material;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "material='" + material + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
