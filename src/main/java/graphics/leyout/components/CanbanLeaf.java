package graphics.leyout.components;

public class CanbanLeaf extends LeyoutComponent {
    CanbanCard[] cards;
    CanbanBoard parent;
    int cntCard;

//    @Deprecated
//    public CanbanLeaf(int cntCard){             //Конструктор для теста
//        this.parent = null;
//        this.cntCard = cntCard;
//        cards = new CanbanCard[cntCard];
//        for (int i = 0; i < cntCard; i++) {
//            cards[i] = new CanbanCard();
//        }
//    }

    public CanbanLeaf(CanbanBoard parent, int cntCard){
        this.parent = parent;
        this.cntCard = cntCard;
        cards = new CanbanCard[cntCard];
        for (int i = 0; i < cntCard; i++) {
            cards[i] = new CanbanCard(this, "");
        }
    }

    public int getCountCard(){
        return cntCard;
    }

    public CanbanCard getCard(int i) {
        return cards[i];
    }

    @Override
    public String toString() {
        return "";
    }

    public int getMaxLeafCountOrder() {
        int max = 0;
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].maxCountOrder > max) max = cards[i].maxCountOrder;
        }
        return max;
    }
}
