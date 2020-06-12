package graphics.leyout.components;

import model.Material;
import stock.Store;

import java.util.ArrayList;

public class MaterialStore extends LeyoutComponent{
    ArrayList<Store> stores;

    public MaterialStore() {
        stores = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "";
    }

    public void setStores(Store store) {
        stores.add(store);
    }

    public void degCountMaterial(Material material){
        for (Store s: stores) {
            if (s.getMaterial().equals(material)){
                s.degCount();
            }
        }
    }
}
