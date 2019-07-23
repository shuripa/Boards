package graphics.leyout.components;

import stock.Stock;

import java.util.ArrayList;

public class CanbansStock extends LeyoutComponent{

    private Stock stock;
    private ArrayList<CanbanBoard> arrCanbans;

    public CanbansStock (){
        arrCanbans = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "";
    }
}
