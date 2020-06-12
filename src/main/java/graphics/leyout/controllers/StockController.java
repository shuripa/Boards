package graphics.leyout.controllers;

import inout.StockLoader;
import sets.stock.Stock;

import java.io.IOException;
import java.util.HashMap;

/**
 * Список всех складов F2, F5, N1 и т.д.
 * {@code getStock()} возвращает объект {@code Stock} по его имени, например F5.
 */

public class StockController {
    private static StockController instance;
    private HashMap<String, Stock> arrStocks = new HashMap<>();
    private static HashMap<String, Double> countByStock;

    private StockController(){
        instance = this;
        StockLoader loader = StockLoader.getInstance();
    }

    public static StockController getInstance() throws IOException {
        if (instance == null) {
            instance = new StockController();

        }
        return instance;
    }

    public Stock getStock(String stock){
        if (arrStocks.containsKey(stock)){
            return arrStocks.get(stock);
        }else{
            arrStocks.put(stock,new Stock());
            return arrStocks.get(stock);
        }
    }

    //TODO: Переписати
    public HashMap<String, Double> getUnitCount (String unit){
        Double sumstock = .0;
        for (String s: arrStocks.keySet()) {
            if (arrStocks.get(s).getUnitCount(unit) != 0.0) {
                System.out.println(s + ": " + arrStocks.get(s).getUnitCount(unit));
                countByStock = new HashMap<>();
                countByStock.put(unit, arrStocks.get(s).getUnitCount(unit));
                sumstock = sumstock + arrStocks.get(s).getUnitCount(unit);
            }
        }
        System.out.println("sum Stoks: " + sumstock);
        return countByStock;
    }
}
