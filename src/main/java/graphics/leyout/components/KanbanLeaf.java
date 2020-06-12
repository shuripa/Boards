package graphics.leyout.components;

import model.Material;
import sets.stock.Store;

import java.util.PriorityQueue;
import java.util.Queue;

//Лыжа

public class KanbanLeaf extends LeyoutComponent {

    private String title;
    private Material material;
    private int definition;
    private int countCards;
    private Queue<KanbanCard> joinCards;
    private Queue<KanbanCard> freeCards;

    public KanbanLeaf(KanbanSection parent, String title){
        joinCards = new PriorityQueue<>();
        freeCards = new PriorityQueue<>();
        this.title = title;
        setParent(parent);          //TODO: Обязательна ли обратная связь?
        setCountCards(2);
        this.material = new Material("");
    }

    public void join (){
        freeCards.peek().join();
        joinCards.add(freeCards.poll());
    }

    public void free(){
        joinCards.peek().free();
        if (joinCards.size() + freeCards.size() > countCards) {
            joinCards.poll();
        } else {
            freeCards.add(joinCards.poll());
        }
    }

    public void setMaterial(Material material){
        this.material = material;
    }

    public void setDefinition(int definition) {
        this.definition = definition;
    }

    public int getDefinition() {
        return definition;
    }

    public void setCountCards(int countCards) {
        if (countCards > this.countCards) {
            for (int i = 0; i < (countCards - this.countCards); i++) {
                freeCards.add(new KanbanCard());
            }
            this.countCards = countCards;
        }
    }

    public int getCountCards() {
        return countCards;
    }

    public int getRestCards(){
        return joinCards.size();
    }

    public Store getStore() {
        return ((KanbanSection)parent()).getStore(this);
    }

    @Override
    public String toString() {
        return "";
    }
}
