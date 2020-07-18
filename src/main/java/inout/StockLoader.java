package inout;

import model.Material;
import sets.stock.MaterialController;
import sets.stock.Stock;
import sets.stock.StockSet;

import java.io.IOException;

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
    final String file = "14.Lagerbestand.csv";

    String LSLANR, LSLORT, LSTENR, TEBEZ1, TEBEZ2, TEBEZ;

    Integer TEPDIM, TEWKSF;
    Double LSLGBE, TEINPR, WERT;
    StockSet stockSet;
    Stock stock;
    MaterialController matContr;
    Material mat;
    CSVReader reader;
    String[] tokens;

    private StockLoader(){
        instance = this;
        try {
            load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StockLoader getInstance(){
        if (instance == null)
            instance = new StockLoader();

        return instance;
    }

    public void load()throws IOException {
        reader = new CSVReader("src\\main\\resources\\14.Lagerbestand.csv", ",");
        if (reader.hasNext()) reader.next();
//        BufferedReader inputf = new BufferedReader(new InputStreamReader(new FileInputStream("src\\main\\resources\\14.Lagerbestand.csv"), "UTF-8"));
//        String line;
//        while ((line = inputf.readLine()) != null) {          //Цикл чтения строк их файла
            for (;reader.hasNext();) {
                tokens = reader.next();

//            String[] tokens = line.split(",");          //разделение на строки
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

            stock = StockSet.getInstance().getStock(LSLANR);
            //TODO: справедливо если весь материал поместить на канбан.
            //TODO: Хотя речь идет не о канбане а о складе, в таком случае зачем ему нужна позиция на канбане.
            stock.setReserve(LSTENR, LSLORT, LSLGBE);     //(тайленомер, позиція на канбані, количество)
            stock.setCount(LSTENR, LSLGBE);

            //Создание связей
            matContr = MaterialController.getInstance();    //Получить материалконтроллер
            mat = matContr.getMaterial(LSTENR);         //Получить материал с тайленомером
            mat.setKnotsExt(LSLORT);                    //Вписать позицию на канбане для создания линий-связей между канбаном и сеткой.
        }
//        inputf.close();
    }
}
