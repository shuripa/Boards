package sets.stock;

import inout.StockLoader;

import java.util.HashMap;

/**
 * Список всех складов F2, F5, N1 и т.д.
 * {@code getStock()} возвращает объект {@code Stock} по его имени, например F5.
 */


public class StockSet {
    private static StockSet instance;
    private HashMap<String, Stock> arrStocks = new HashMap<>();

    private StockSet(){
        instance = this;
    }

    public static StockSet getInstance(){
        if (instance == null) {
            instance = new StockSet();
            StockLoader.getInstance();
        }
        return instance;
    }

    public Stock getStock(String stock){
        if (arrStocks.containsKey(stock)){
            return arrStocks.get(stock);
        }else{
            arrStocks.put(stock,new Stock(stock));
            return arrStocks.get(stock);
        }
    }

    //TODO: Переписати ??? як саме переписати i де використовуэться?

    public HashMap<String, Double> getCountOnStocks(String unit){
        HashMap<String, Double> result = new HashMap<>();
        Double sumstock = .0;
        for (String s: arrStocks.keySet()) {
            if (arrStocks.get(s).getUnitCount(unit) != 0.0) {
                System.out.println(s + ": " + arrStocks.get(s).getUnitCount(unit));
                result = new HashMap<>();
                result.put(unit, arrStocks.get(s).getUnitCount(unit));
                sumstock = sumstock + arrStocks.get(s).getUnitCount(unit);
            }
        }
        System.out.println("sum Stoks: " + sumstock);
        return result;
    }
}
