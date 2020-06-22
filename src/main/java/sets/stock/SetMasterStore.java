package sets.stock;

import inout.MasterStoreLoader;
import model.Material;

import java.util.Date;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SetMasterStore {
    private static final Logger logger = Logger.getLogger("MainApp");
    private static SetMasterStore instance;
    private TreeMap<KeyStore, MasterStore> set;
    private TreeMap<String, KeyStore> keys;

    private SetMasterStore() {
        set = new TreeMap<>();
        keys = new TreeMap<>();
    }

    public static SetMasterStore getInstance(){
        if (instance == null) {
            instance = new SetMasterStore();
            create();
        }
        return instance;
    }

    private static void create() {
        Date start = new Date();
        logger.log(Level.FINE, "Start load master store: start = " + start);
        MasterStoreLoader loader = new MasterStoreLoader();
        loader.load();
        Date end = new Date();
        double res = (end.getTime() - start.getTime())/1000;
        logger.log(Level.INFO, "End load master store: start = " + start + "; end = " + end + "; result = " + res);
    }


    public void add(KeyStore key, MasterStore master){
        //TODO: неправильно организованы ключ
        if (key.stock.equals("F5")) {
            keys.put(key.store, key);
        }
        set.put(key, master);
    }

    public MasterStore getMasterStore(KeyStore key){
        return set.get(key);
    }

    public MasterStore getMasterStore(String stock, String store, String material){
        return set.get(new KeyStore(stock, store, material));
    }
    //TODO: Работает только для канбанов
    //TODO: нельзя использовать для множественной позиции типа KOMIS, AUDI, KM_087, W1
    //TODO: название склада также излишне, буквы на складах не повторяются.
    public MasterStore getMasterStore(LeafAddress leafAddress){
        String addres = leafAddress.toString();
        logger.log(Level.FINE, "Address : "  + addres);
        KeyStore key = null;
        MasterStore result = null;

        if (keys.containsKey(addres)){
            key  = keys.get(addres);
            logger.log(Level.FINE, "Key : "  + key.toString());
        }
        if (key != null && set.containsKey(key)) {
            result = set.get(key);
            logger.log(Level.FINE, "Master store: " + leafAddress.toString() + " : " + result.toString());
        }
        return result;
    }

    public Material getMateril(LeafAddress leafAddress){
        Material result;
        String addres = leafAddress.toString();
        if (keys.containsKey(addres)) {
            String material = keys.get(addres).material;
            result = new Material(material);
            logger.log(Level.FINE, "" + leafAddress.toString() + " not out in keys ");
        } else result = new Material("");
        logger.log(Level.FINE, "" + leafAddress.toString() + " : " + result.toString());
        return result;
    }
}
