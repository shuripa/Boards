package stock;

import java.util.HashMap;

/**
 * <b>Склад - Набір позиций<b/>
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
 */

//количество чего либо имеющее местопроисхождения
public class Stock {
    //TODO: Пока не понятно когда это должно заполняться.
    private Store store;
    private String descript1;
    private String descript2;
    //TODO: String зменить на CompositUnit
    Transactions actions;
    private HashMap<String, Store> stores = new HashMap<>();
    private HashMap<String, Transactions> transactions = new HashMap<>();

    //Это хорошо для какого-то поиска, но для канбана например нужен другой механизм доступа
    public Double getUnitCount (String unit){
        for (Store u: stores.values()) {
            if (unit.equals(u.getMaterial())){
                return u.getCount();
            }
        }
        return 0.0;
    }

    public Store setStore(String unit, String locationStore, Double count ){

        //Если значение существует, оно не перезапишется.
        //TODO Тайленомера никак не связаны пока с мастердатой.
        //TODO Unit пока String a не Material поэтому некуда записать описания и machcod.
            Store result = new Store(unit, count);
            stores.put(locationStore, result);

            if (transactions.containsKey(unit)){
                actions = transactions.get(unit);
            }else {
                actions = new Transactions();
                transactions.put(unit, actions);
            }
            return result;
    }

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

    public String getMaterial(String titleStore) {
        if (stores.containsKey(titleStore)){
            Store res = stores.get(titleStore);
            return res.material;
        } return "";
    }

    public Double getCount(String titleStore) {
        if (stores.containsKey(titleStore)) {
            Store res = stores.get(titleStore);
            return res.count;
        } else return 0D;
    }

    public Store getStore(String titleStore) {
        if (stores.containsKey(titleStore)){
            return stores.get(titleStore);
        } else return null;
    }
}
