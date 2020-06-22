package graphics.leyout.components;

import model.Material;
import sets.stock.KeyStore;
import sets.stock.LeafAddress;
import sets.stock.Store;

//Отсек

public class KanbanSection extends LeyoutComponent {
    KanbanLeaf[] leafs;
    int cntLeafs;

    public KanbanSection(KanbanBoard parent, int cntLeafs, LeafAddress address){
        setParent(parent);
        this.cntLeafs = cntLeafs;
        leafs = new KanbanLeaf[cntLeafs];

        for (int i = 0; i < cntLeafs; i++) {
            LeafAddress addr = ((LeafAddress) address.clone());
            addr.setLeaf(i);
            leafs[i] = new KanbanLeaf(this, addr);
        }
    }

    public int getCountLeafs(){
        return cntLeafs;
    }

    public int getLeafsLength(){
        return leafs.length;
    }

    public KanbanLeaf getLeaf(int i) {
        return leafs[i];
    }

    public int getLeafInd(KanbanLeaf leaf){
        int result = 0;
        for (int i = 0; i < getLeafsLength(); i++) {
            //Возвращает индекс позиции на реальном канбане, который начинается с 1, a не как в массиве, где он начинается с 0.
            // Если result останется равным 0 значит карта не содержится в массиве.
            if (leafs[i] == leaf) result = i+1;
        }
        return result;
    }

    @Override
    public String toString() {
        return "" + cntLeafs;
    }

    public int getMaxLeafCountOrder() {
        int max = 2;   // минимальное количество заказов на лыже.
        for (int i = 0; i < leafs.length; i++) {
            if (leafs[i].cntCard() > max) max = leafs[i].cntCard();
        }
        return max;
    }

    public KeyStore getStoreKey(KanbanLeaf leaf, Material material){
        return ((KanbanBoard)parent()).getStoreKey(this, leaf, material);
    }

    public Store getStore(KanbanLeaf leaf) {
        String adres = "-" + getLeafInd(leaf);
        return ((KanbanBoard)parent()).getStore(this, adres);
    }

    public String getStock() {
        return ((KanbanBoard)parent()).getStockTitle();
    }

    public String getStockTitle() {
        return ((KanbanBoard)parent()).getStockTitle();
    }

    public String getAddres(KanbanLeaf leaf) {
        return ((KanbanBoard)parent()).getAddres(this, leaf);
    }
}
