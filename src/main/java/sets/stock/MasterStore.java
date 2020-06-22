package sets.stock;

public class MasterStore {
    private String material;
    private int orderCnt;
    private int masterDefinition;


    public MasterStore(String material, int orderCnt, int masterDefinition) {
        this.material = material;
        this.orderCnt = orderCnt;
        this.masterDefinition = masterDefinition;
    }

    public int getOrderCnt() {
        return orderCnt;
    }

    public int getMasterDefinition() {
        return masterDefinition;
    }

    public String getMaterialStr(){
        return material;
    }

    public void setMaterialStr(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return " orderCnt : " + orderCnt +"; definition: " + masterDefinition;
    }
}
