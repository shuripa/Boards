package graphics.leyout.components;

import graphics.leyout.controllers.StockController;
import inout.CompositBuilder;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import stock.Stock;
import stock.Store;

import java.io.IOException;

public class CanbanBoard extends LeyoutComponent {
        private final static String TITLE_PROP_TITLE = "Canban title";
        private final static String TITLE_PROP_COUNTLEAVES = "Count leaves";
        private final static String TITLE_PROP_COUNTCARDS = "Count cards";

        private StringProperty title;
        private IntegerProperty cntLeaves;
        private IntegerProperty cntCards;

        CanbansStock parent;
        CanbanLeaf[] leaves;

    //Конструктор для створення з кнопки
    public CanbanBoard() throws IOException {
        createProperty();
        this.cntLeaves.set(10);
        this.cntCards.set(6);
        create();
    }

    @Deprecated
    //Конструктор для створення з файлу. Створений для тестування. Орієнтовно буде видалений.
    public CanbanBoard(int cntLeaves, int cntCards) throws IOException {
        createProperty();
        this.cntLeaves.set(cntLeaves);
        this.cntCards.set(cntCards);
        create();
    }

    //Конструктор для завантаження з файлу і якщо буде реалізований CanbansStock
    public CanbanBoard(CanbansStock parent, int cntLeaves, int cntCards) throws IOException {
        createProperty();
        this.parent = parent;
        this.cntLeaves.set(cntLeaves);
        this.cntCards.set(cntCards);
        create();
    }

    public CanbanBoard(CompositBuilder builder) throws IOException {
        createProperty();
        this.cntLeaves.set(builder.getLeafs());
        this.cntCards.set(builder.getCards());
        this.setTitle(builder.getTitle());
        create();
    }

    private void createProperty() {
        this.title = new SimpleStringProperty(this, TITLE_PROP_TITLE, "");
        this.cntLeaves = new SimpleIntegerProperty(this, TITLE_PROP_COUNTLEAVES, 0);
        this.cntCards = new SimpleIntegerProperty(this, TITLE_PROP_COUNTCARDS, 0);
    }

    @Override
    protected void create() throws IOException {
        leaves = new CanbanLeaf[cntLeaves.get()];
        for (int i = 0; i < cntLeaves.get(); i++) {
            leaves[i] = new CanbanLeaf(this, cntCards.get());
        }
        super.create();
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public int getCntLeaves() {
        return cntLeaves.get();
    }

    public IntegerProperty cntLeavesProperty() {
        return cntLeaves;
    }

    public void setCntLeaves(int cntLeaves) throws IOException {
        if (this.cntLeaves.get() != cntLeaves) {
            this.cntLeaves.set(cntLeaves);
            create();
        }
    }

    public void setEvents(){
    }

    public int getCountLeaves(){
        return cntLeaves.get();
    }

    public int getCntCards() {
        return cntCards.get();
    }

    public IntegerProperty cntCardsProperty() {
        return cntCards;
    }

    public void setCntCards(int cntCards) throws IOException {
        if (this.cntCards.get() != cntCards) {
            this.cntCards.set(cntCards);
            create();
        }
    }

    public CanbanLeaf getLeaf(int i){
        return leaves[i];
    }

    @Override
    public void update () {
        if((leaves.length != cntLeaves.get()) || (getLeaf(1).getCardsLength() != cntCards.get())) {
            try {
                create();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            super.update();
        }
    }

    @Override
    public String toString() {
        return "";
    }

    public int getLeafInd (CanbanLeaf leaf){
        int result = 0;
        for (int i = 0; i < getCntLeaves(); i++) {
            //Возвращает индекс позиции на реальном канбане, который начинается с 1, a не как в массиве, где он начинается с 0.
            // Если result останется равным 0 значит карта не содержится в массиве.
            if (leaves[i] == leaf) result = i+1;
        }
        return result;
    }

    public Store getStore(CanbanLeaf leaf, String a) {
        String adres = "";
        if (getTitle().length()==1 && getLeafInd(leaf)<10) {
                adres = "" + getTitle() + "0" + getLeafInd(leaf) + a;
        } else {
            adres = "" + getTitle() + getLeafInd(leaf) + a;
        }

        Stock stock = null;
        try {
            stock = StockController.getInstance().getStock("F5");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stock.getStore(adres);
    }
}