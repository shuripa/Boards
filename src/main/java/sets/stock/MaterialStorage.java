package sets.stock;

import java.util.Set;

public class MaterialStorage extends Storage{
    static Set<MaterialStorage> allStore;
    double cnt;

    public MaterialStorage(String stock, String material, String position) {
        super(stock, material, position);
        cnt = 0;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    @Override
    public Double getCount() {
        return cnt;
    }
}
