package sets.stock;

import org.jetbrains.annotations.NotNull;

public class KeyStore implements Comparable{
    String stock;
    String store;
    String material;

    public KeyStore(String stock, String store, String material) {
        this.stock = stock;
        this.store = store;
        this.material = material;
    }

    @Override
    public int compareTo(@NotNull Object key) {
        if (this.toString().compareTo(key.toString()) > 0) return 1;
        else if (this.toString().compareTo(key.toString()) < 0) return -1;
        return 0;
    }

    @Override
    public String toString() {
        return stock + store + material;
    }
}
