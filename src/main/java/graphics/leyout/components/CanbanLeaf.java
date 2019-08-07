package graphics.leyout.components;

import stock.Store;

public class CanbanLeaf extends LeyoutComponent {
    CanbanCard[] cards;
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
        setParent(parent);
        this.cntCard = cntCard;
        cards = new CanbanCard[cntCard];
        for (int i = 0; i < cntCard; i++) {
            cards[i] = new CanbanCard(this, "");
        }
    }

    public int getCountCard(){
        return cntCard;
    }

    public int getCardsLength(){
        return cards.length;
    }

    public CanbanCard getCard(int i) {
        return cards[i];
    }

    public int getCardInd(CanbanCard card){
        int result = 0;
        for (int i = 0; i < getCardsLength(); i++) {
            //Возвращает индекс позиции на реальном канбане, который начинается с 1, a не как в массиве, где он начинается с 0.
            // Если result останется равным 0 значит карта не содержится в массиве.
            if (cards[i] == card) result = i+1;
        }
        return result;
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

    public Store getStore(CanbanCard card) {
        String adres = "-" + getCardInd(card);
        return ((CanbanBoard)parent()).getStore(this, adres);
    }
}
