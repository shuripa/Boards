package sets.stock;

public class KanbanStorage extends Storage{
    private int countCard;
    private int definition;

    public KanbanStorage(String stock, String material, String position) {
        super(stock, material, position);
        Storage stockStorage;
        if (material == "") {
            stockStorage = getStock().getStorage(position);
            if (stockStorage != null)
                changeMaterial(stockStorage.getMaterial());
        }
        countCard = 0;
        definition = 0;
        getStock().setStorage(this);
    }

    public void setMaxCountCard(int countCard){
        this.countCard = countCard;
    }

    public void setDefinition(int definition){
        this.definition = definition;
    }

    @Override
    public Double getCount() {
        int count = (int)Math.floor(getStock().getCount(getMaterial())/definition);
        double result = Math.min(countCard, count);
        return (result * definition);
    }


}
