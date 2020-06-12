package graphics.leyout.components;

import sets.stock.Stock;

import java.util.ArrayList;

//Массив всех канбанов???

@Deprecated
public class KanbansStock extends LeyoutComponent{

    private Stock stock;

    private ArrayList<KanbanBoard> arrCanbans;

    public KanbansStock(){
        arrCanbans = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "";
    }
}
