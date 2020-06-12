package graphics.leyout.components;

import graphics.leyout.controllers.StockController;
import inout.CompositBuilder;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sets.stock.Stock;
import sets.stock.Store;

import java.io.IOException;

//Один отдельный канбан

public class KanbanBoard extends LeyoutComponent {
    private final static String TITLE_PROP_TITLE = "Kanban title";
    private final static String TITLE_PROP_COUNTSECTIONS = "Kount sections";
    private final static String TITLE_PROP_COUNTLEAVES = "Kount leaf";

        private StringProperty title;
        private IntegerProperty cntSections;
        private IntegerProperty cntLeafs;

        KanbansStock parent;
        KanbanSection[] leaves;

    //Конструктор для створення з кнопки
    public KanbanBoard() throws IOException {
        createProperty();
        this.cntSections.set(10);
        this.cntLeafs.set(6);
        create();
    }

    @Deprecated
    //Конструктор для створення з файлу. Створений для тестування. Орієнтовно буде видалений.
    public KanbanBoard(int cntSections, int cntLeafs) throws IOException {
        createProperty();
        this.cntSections.set(cntSections);
        this.cntLeafs.set(cntLeafs);
        create();
    }

    //Конструктор для завантаження з файлу і якщо буде реалізований CanbansStock
    public KanbanBoard(KanbansStock parent, int cntSections, int cntLeafs) throws IOException {
        createProperty();
        this.parent = parent;
        this.cntSections.set(cntSections);
        this.cntLeafs.set(cntLeafs);
        create();
    }

    public KanbanBoard(CompositBuilder builder) throws IOException {
        createProperty();
        this.cntSections.set(builder.getLeafs());
        this.cntLeafs.set(builder.getCards());
        this.setTitle(builder.getTitle());
        create();
    }

    private void createProperty() {
        this.title = new SimpleStringProperty(this, TITLE_PROP_TITLE, "");
        this.cntSections = new SimpleIntegerProperty(this, TITLE_PROP_COUNTSECTIONS, 0);
        this.cntLeafs = new SimpleIntegerProperty(this, TITLE_PROP_COUNTLEAVES, 0);
    }

    @Override
    protected void create() throws IOException {
        leaves = new KanbanSection[cntSections.get()];
        for (int i = 0; i < cntSections.get(); i++) {
            leaves[i] = new KanbanSection(this, cntLeafs.get());
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

    public int getCntSections() {
        return cntSections.get();
    }

    public IntegerProperty cntSectionsProperty() {
        return cntSections;
    }

    public void setCntSections(int cntSections) throws IOException {
        if (this.cntSections.get() != cntSections) {
            this.cntSections.set(cntSections);
            create();
        }
    }

    public void setEvents(){
    }

    public int getCountLeaves(){
        return cntSections.get();
    }

    public int getCntLeafs() {
        return cntLeafs.get();
    }

    public IntegerProperty cntLeafsProperty() {
        return cntLeafs;
    }

    public void setCntLeafs(int cntLeafs) throws IOException {
        if (this.cntLeafs.get() != cntLeafs) {
            this.cntLeafs.set(cntLeafs);
            create();
        }
    }

    public KanbanSection getLeaf(int i){
        return leaves[i];
    }

    @Override
    public void update () {
        if((leaves.length != cntSections.get()) || (getLeaf(1).getCardsLength() != cntLeafs.get())) {
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

    public int getLeafInd (KanbanSection leaf){
        int result = 0;
        for (int i = 0; i < getCntSections(); i++) {
            //Возвращает индекс позиции на реальном канбане, который начинается с 1, a не как в массиве, где он начинается с 0.
            // Если result останется равным 0 значит карта не содержится в массиве.
            if (leaves[i] == leaf) result = i+1;
        }
        return result;
    }

    public Store getStore(KanbanSection leaf, String a) {
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