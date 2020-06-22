package sets.stock;

import model.Material;

/* Хранение заказов:
* - Загрузка*/

public class Order {
    private String orderNo;
    private String stock;
    private Material material;
    private Integer count;       //Количество
    private Integer rest;
    private String srtD;
    private String endD;
    private String status;

    public Order(Material material, Integer count) {
        this.material = material;
        this.count = count;
        orderNo = "";
        stock = "";
        rest = 0;
    }

    public Order (String orderNo, Material material, String stock,  int count, int rest, String srtD, String endD, String status){
        this.material = material;
        this.stock = stock;
        this.orderNo = orderNo;
        this.count = count;
        this.rest = rest;
        this.srtD = srtD;
        this.endD = endD;
        this.status = status;
    }


    public String getOrderNo() {
        return orderNo;
    }

    public String getStock() {
        return stock;
    }

    public Material getMaterial() {
        return material;
    }

    public String getMaterialAsStr() {
        return material.getTitle();
    }

    public Integer getCount() {
        return count;
    }

    public Integer getRest() {
        return rest;
    }

    public String getSrtD() {
        return srtD;
    }

    public String getEndD() {
        return endD;
    }

    public String getStatus() {
        return status;
    }

    public boolean isStarted(){
        return status.equals("1") || status.equals("9");
    }

    @Override
    public String toString() {
        return "Ord: " + orderNo + "; Stk: " + stock + "; Mat: " + material.toString() + "; Cnt: " + count + "; Rst: " + rest;
    }
}
