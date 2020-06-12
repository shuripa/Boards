package inout;

import graphics.leyout.controllers.MaterialController;
import model.Material;
import sets.stock.Stock;
import graphics.leyout.controllers.StockController;
import sets.stock.Store;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <p>{@code LSLANR[0]} - склад
 * <p>{@code LSLORT[1]} - позиція на канбані
 * <p>{@code LSTENR[2]} - тайленомер
 * <p>{@code TEBEZ1[3]} - описание
 * <p>{@code TEBEZ2[4]} - машинный код MachCode
 * <p>{@code LSLGBE[5]} - количество
 * <p><b>Принцип работы:</b>
 * <p>- получить инстанс
 * <p>- запустить {@code reader()}
 * <p>- создается синглттон {@code StocList}, который содержит все склады и их наполнение {@code content}
 * <p>- TODO: далее нужно оформить связь канбанов с позициями.
 * <p>- TODO: или же {@code reader()} мог бы собой вернуть {@code StokList} для использования. {@code StockController} может оставаться синглтоном.
 * <p>- TODO: что если {@code XPPSStockLoader} будет запущен повторно? Пересоздаст ли он стоклист?
 * example record: "F5","02F6-1","3FD0219670016","LTG 196083       03BL00565","103357.01,907647.01",109.00,"3",13.26,1.4453,""
 */

public class StockLoader {
    private static StockLoader instance;
    final String file = "q14xpps.csv";
    String LSLANR, LSLORT, LSTENR, TEBEZ1, TEBEZ2, TEBEZ;

    Integer TEPDIM, TEWKSF;
    Double LSLGBE, TEINPR, WERT;
    StockController stockController;
    Stock stock;
    MaterialController matCon;
    Material mat;

    private StockLoader(){
        instance = this;
        try {
            reader();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StockLoader getInstance(){
        if (instance == null)
            instance = new StockLoader();

        return instance;
    }

    public void reader()throws IOException {
        BufferedReader inputf = new BufferedReader(new InputStreamReader(new FileInputStream("src\\main\\resources\\" + file), "UTF-8"));
        String line;
        while ((line = inputf.readLine()) != null) {          //Цикл чтения строк их файла
            String[] tokens = line.split(",");          //разделение на строки
            LSLANR = tokens[0].substring(1,tokens[0].length()-1);
            LSLORT = tokens[1].substring(1,tokens[1].length()-1);
            LSTENR = tokens[2].substring(1,tokens[2].length()-1);
            LSLGBE = Double.parseDouble(tokens[tokens.length-5]);
            TEBEZ = tokens[3]+tokens[4];
            for (int i = 5; i < tokens.length-5; i++) {
                TEBEZ = TEBEZ+tokens[i];
            }
            String[] tokens1 = TEBEZ.split("\"");
            TEBEZ1 = tokens1[1];
            TEBEZ2 = tokens1[3];
//                System.out.println(LSLANR + "; " + LSLORT+ "; " + LSTENR + "; " + LSLGBE + "; " + TEBEZ1 + "; " + TEBEZ2 + "; " + tokens.length);

            stock = StockController.getInstance().getStock(LSLANR);
//            stock.setStore(LSTENR, LSLORT, LSLGBE);
            Store store = stock.setStore(LSTENR, LSLORT, LSLGBE);
            matCon = MaterialController.getInstance();
            mat = matCon.getMaterial(LSTENR);
            mat.setKnotsExt(LSLORT);
        }
        inputf.close();
    }
}
