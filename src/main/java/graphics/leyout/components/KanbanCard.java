package graphics.leyout.components;

import java.util.Date;

public class KanbanCard {

    private int countMaterial;
    private int definition;
    private long openTime;
    private long freeTime;
    private long joinTime;

    public KanbanCard(){
        definition = 0;
        countMaterial = 0;
        freeTime = new Date().getTime();
    }

    public void setCountMaterial(int countMaterial) {
        this.countMaterial = countMaterial;
    }

    public int getCountMaterial() {
        return countMaterial;
    }

    public void free(){
        freeTime = new Date().getTime();
    }

    public void open(int definition){
        this.definition = definition;
        openTime = new Date().getTime();
    }

    public void join(){
        joinTime = new Date().getTime();
    }
}
