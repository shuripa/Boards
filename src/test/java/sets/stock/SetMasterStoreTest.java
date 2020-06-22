package sets.stock;

import org.junit.Test;

import static org.junit.Assert.*;

public class SetMasterStoreTest {

    @Test
    public void getInstance() {
    }

    @Test
    public void add() {
    }

    @Test
    public void get() {
        SetMasterStore set = SetMasterStore.getInstance();
//        System.out.println(set.get("F1", "X56-5", "910000853"));
        KeyStore key = new KeyStore("F1", "X56-5", "910000853");
        set.add(key, new MasterStore("910000853", 2, 25));
        assertEquals(set.getMasterStore(key).toString(), "orders: 2; definition: 25");
    }
}