package graphics.leyout.components;

import sets.stock.Store;

//Отсек

public class KanbanSection extends LeyoutComponent {
    KanbanLeaf[] cards;
    int cntCard;

    public KanbanSection(KanbanBoard parent, int cntCard){
        setParent(parent);
        this.cntCard = cntCard;
        cards = new KanbanLeaf[cntCard];
        for (int i = 0; i < cntCard; i++) {
            cards[i] = new KanbanLeaf(this, "");
        }
    }

    public int getCountCard(){
        return cntCard;
    }

    public int getCardsLength(){
        return cards.length;
    }

    public KanbanLeaf getCard(int i) {
        return cards[i];
    }

    public int getCardInd(KanbanLeaf card){
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
            if (cards[i].countCards > max) max = cards[i].countCards;
        }
        return max;
    }

    public Store getStore(KanbanLeaf card) {
        String adres = "-" + getCardInd(card);
        return ((KanbanBoard)parent()).getStore(this, adres);
    }
}
