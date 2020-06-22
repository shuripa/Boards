package inout;

import model.Material;
import sets.SetOrders;
import sets.stock.Order;

import java.util.logging.Logger;

public class OrderLoader{

    /*05.Offene.Fertigungsauftraege.csv Содержи:
* - [0](str)Номер заказа,                               WAAUNR
* - [1]Артикул,                                         WAAUAR
* - [2](str)Склад з якого зроблене замовлення           TEBELA
* - [3]Приоритет,                                       WAPRIO
* - [4](str)Материал                                    WATENR
* - [5](str)Дата старту                                 WASTTE
* - [6](str)Дата завершення                             WAENTE
* - [7](int)Розмiр замовлення                           WAFEMG
* - [8](int)Залишок до виготовлення,                    RESTMENGE
* - [9]Стан складу на момент вiдкриття замовлення       TELGBE
* - [10]Стан замовлення (пусто - тiльки вiдкрите, 1 вже було мельдування, 9 закрите) WATLKZ
* - [11]Статус (10, 30, 50 вiдповiдаэ станам пусто 1, 9, але може бути стан 9 а статус залишатись 30 з рiзних причин) WASTAT
* - [12]Робочий крок                                    AGAGNR
* - [13...]Опис операцiъ в робочому кроцi               AGAGBZ
* - [cnt-7]Час на виконання операцiъ на 100 одиниць продукцъъ AGSTZT
* - [cnt-6]Час на виготовлення залишковоъ кълькостъ     RESTZEIT
* - [cnt-5]Логън яким було въдкрито замовлення          WAANUS
* - [cnt-4]Робоче мъсце на якому виконуэться этап       AGMANR
* - [cnt-3]Дата останнього мельдування замовлення       WARMDA
* - [cnt-2]Мъсце зберъгання                             TEDINR
* - [cnt-1]Брак                                         ---
*  WAAUNR, WAAUAR,  TEBELA  WAPRIO  WATENR          WASTTE      WAENTE     WAFEMG  RESTMENGE   TELGBE  WATLKZ  WASTAT  AGAGNR  AGAGBZ                     AGSTZT    RESTZEIT WAANUS   AGMANR  WARMDA TEDINR
* 5435406,"01",    "F2",   0,       "3EJ12TUL50001", 20171013,   20171013,  96.00,  96.00,      .00,      "",   "10",   110,    "Assembly on single board",33.00,    31.6800,"ZAR01VIK","08652",0,    "UADI",.00
* 5500089,"01",    "",     0,       "1HV43G0509H0B", 20171102,   20171103,  352.00, 29.00,   254.00,     "1",   "30",   130,    "Packing Autarkics",      252.00,    73.0800,"ZAR01VIK","08919",20171126,"UADI",1.00
* 5499805,"01",    "F2",   0,       "1HV48V0509M0B", 20171031,   20171031,  200.00, 1.00,     96.00,     "1",   "30",   130,    "Packing Autarkics",        2.52,      .0252,"HAT01AND","08919",20171126,"UADI",4.00
*/

    private final String file = "05.Offene.Fertigungsauftraege.csv";
    private static final Logger logger = Logger.getLogger("MainApp");
    private static SetOrders set = SetOrders.getInstance();
    private CSVReader reader;
    private String[] tokens;

    public void load() {
        reader = new CSVReader("src\\main\\resources\\" + file, ",");
        if(reader.hasNext()) reader.next(); //Пропуск первой строки
        for(;reader.hasNext();){
            tokens = reader.next();
            int count = (int)Double.parseDouble(tokens[7]);
            int rest = (int)Double.parseDouble(tokens[8]);
            String matstr = tokens[4].substring(1, tokens[4].length()-1);
            String status = tokens[10].substring(1, tokens[10].length()-1);
            set.add(new Order(tokens[0], new Material(matstr), tokens[2], count, rest, tokens[5], tokens[6], status));
        }
    }


}
