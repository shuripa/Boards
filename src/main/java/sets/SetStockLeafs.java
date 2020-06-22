package sets;

import graphics.leyout.components.KanbanBoard;
import sets.stock.Stock;

import java.util.ArrayList;

//Массив всех канбанов.

//Есть два варианта загрузки данных для канбанов.
// 1) При создании. Путем чтения из файла. Перебором каждый раз.
// 2) Путем создания массива данных канбанов.

@Deprecated
public class SetStockLeafs {

    private Stock stock;
    private ArrayList<KanbanBoard> arrCanbans;

    public SetStockLeafs(){
        arrCanbans = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "";
    }
}
