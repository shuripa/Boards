package sets.stock;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <b>Склад - Набір позиций<b/>
 * Матеріал може бути позиційним безпозиційним, з позицiэю на канбанi, або з позицією на робочому місці)
 * <p>{@code Stock}     - Склад - складається з набору всіх можливих позицій
 * <p>{@code Store}     - Позиція - поняття яке включає матеріал-фізичне розміщення(канбан)- кількість
 * <p>{@code String descript1}
 * <p>{@code String descript2}
 * <p>{@code Transaction action}
 * <p>{@code HashMap<String, Double> stores}
 * <p>{@code HashMap<String, Transactions> transactions}
 * <p>{@code Double getUnitCount(String unit)}
 * <p>{@code void setUnitCount(String unit, Double count)}
 * <p>{@code void setUnitAction(String unit, Integer date, Integer time, Double amt, Double rst, String kod, String user)}
 *
 * Задачи
 * 1) Материал - количество.
 * 2) Набор всех существующих позиций для материала(Storage)
 * При создании заполняется массив reserve (материал, количество) и массив storages (ключ, позиция) из StockLoader
 * Далее каждый инструмент создает свои специфицеские storage и заменяет имеющиеся собственными. Специфичность storage
 * состоит в типе, которые определяет различное поведение: подсчет остатка материала, восполнение недостающих начальных
 * данных. Stock может выдать только общее количество материала на складе. Количество материала в конкретном месте может
 * вернуть только само это место (storage).
 */



public class Stock {
    //TODO: Пока не понятно когда это должно заполняться.
    private static final Logger logger = Logger.getLogger("MainApp");

    private String title;
    //material: count
    private HashMap<String, Double> counting;
    //address: count
    private HashMap<String, Reserve> reserves;
    //position : material
    private HashMap<String, Storage> storages;

    Transactions actions;
    //TODO: String заменить на CompositUnit
    private HashMap<String, Transactions> transactions = new HashMap<>();

    public Stock(String title){
        this.title = title;
        reserves = new HashMap<>();
        storages = new HashMap<>();
        counting = new HashMap<>();
    }

    /*Методы для хранилища*/


    public void setCount(String material, Double count){
        counting.put(material, count);
    }


    public Double getCount(String material){
        if (counting.containsKey(material)) {
            return counting.get(material);
        } else {
            return .0;
        }
    }

    public Double getCount (Storage storage) {
        return storage.getCount();
    }

    @Deprecated //Использовать getStorage(Storage, Material)
    public Reserve getReserve(String titleStore) {
        if (reserves.containsKey(titleStore)){
            return reserves.get(titleStore);
        } else return null;
    }
    @Deprecated
    public Reserve getReserve(LeafAddress address) {
        if (reserves.containsKey(address.toString())){
            return reserves.get(address.toString());
        } else {
            logger.log(Level.FINE, "Адресс отсутствует store = null : " + address.toString());
            return null;
        }
    }


    public void setStorage(Storage storage){
        storages.put(storage.key(), storage);
    }

    public Storage getStorage(String position){
        for (String key: storages.keySet()) {
            if (key.subSequence(0, position.length()).equals(position)) return storages.get(key) ;
        }
        return null;
    }

    public Storage getStorage(String position, String material){
        Storage result = null;
        String key = position + ":" + material;
        if (storages.containsKey(key)){
            result = storages.get(key);
        }
        return result;
    }

    /* Методы для транзакций*/

    //Это хорошо для какого-то поиска, но для канбана например нужен другой механизм доступа
    public void setUnitAction (String unit, Integer date, Integer time, Double amt, Double rst, String kod, String user){
        if (transactions.containsKey(unit)){
            actions = transactions.get(unit);
            actions.setTransaction(date, time, amt, rst, kod, user);
        }else {
            actions = new Transactions();
            transactions.put(unit, actions);
            actions.setTransaction(date, time, amt, rst, kod, user);
        }
    }

    public Double getUnitCount (String unit){
        for (Reserve u: reserves.values()) {
            if (unit.equals(u.getMaterial())){
                return u.getCount();
            }
        }
        return 0.0;
    }

    public Reserve setReserve(String material, String locationStore, Double count ){

        //Если значение существует, оно не перезапишется.
        //TODO Тайленомера никак не связаны пока с мастердатой.
        //TODO Unit пока String a не Material поэтому некуда записать описания и machcod.
        Reserve result = new Reserve(material, count);
        reserves.put(locationStore, result);

        if (transactions.containsKey(material)){
            actions = transactions.get(material);
        }else {
            actions = new Transactions();
            transactions.put(material, actions);
        }
        return result;
    }

    public String getMaterial(String titleStore) {
        if (reserves.containsKey(titleStore)){
            Reserve res = reserves.get(titleStore);
            return res.material;
        } return "";
    }
}
