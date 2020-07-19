package graphics.leyout.components;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class KanbanCard implements Comparable{

    private int priority;
    private int countMaterial;
    private int cardDefinition;
    private long openTime;
    private long freeTime;
    private long joinTime;


    public KanbanCard(int priority){
        this.priority = priority;
        cardDefinition = 0;
        countMaterial = 0;
        freeTime = new Date().getTime();
        openTime = 0;
        joinTime = 0;
    }

    public void setCountMaterial(int countMaterial) {
        this.countMaterial = countMaterial;
    }

    public void setCardDefinition(int cardDefinition) {
        this.cardDefinition = cardDefinition;
    }

    public int getCountMaterial() {
        return countMaterial;
    }

    public void free(int priority){
        freeTime = new Date().getTime();
        this.priority = priority;
    }

    public void open(int definition){
        this.cardDefinition = definition;
        openTime = new Date().getTime();
    }

    public void join(int priority) {
        joinTime = new Date().getTime();
        this.priority = priority;
    }

    public long lastOperation(){
        long maxTime = Math.max(openTime, joinTime);
        return Math.max(freeTime, maxTime);
    }

    public void decPriority(){
        priority --;
    }

    public int getPriority(){
        return priority;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        return 0;
    }

    public int getDefinition() {
        return cardDefinition;
    }
}
