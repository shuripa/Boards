package graphics.leyout.components;

import inout.CompositBuilder;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Material;
import sets.SetStockLeafs;
import sets.stock.*;

import java.io.IOException;

//Один отдельный канбан

public class KanbanBoard extends LeyoutComponent {
    private final static String TITLE_PROP_TITLE = "Kanban title";
    private final static String TITLE_PROP_COUNTSECTIONS = "Kount sections";
    private final static String TITLE_PROP_COUNTLEAVES = "Kount leaf";

    private StringProperty title;
    private IntegerProperty cntSections;
    private IntegerProperty cntLeafs;
    SetStockLeafs parent;    //TODO: использовать Stock вместо KanbansStock
    Stock stock;
    KanbanSection[] leaves;
    boolean isTitleEmpty;

    //Конструктор для створення з кнопки
    public KanbanBoard() {
        createCommonProperty();
        this.cntSections.set(7);
        this.cntLeafs.set(4);
        createLeafs();    //Нет названия канбана, создается канбан с пустыми узлами
        isTitleEmpty = true;
    }

    public KanbanBoard(CompositBuilder builder) {
        createCommonProperty();
        this.cntSections.set(builder.getSections());   //TODO: внести изменения в билдере лист стал секцией
        this.cntLeafs.set(builder.getLeafs());      //TODO: внести изменения в билдере карточка стала листом(лыжей)
        this.title.set(builder.getTitle());
        createLeafs();
    }

    private void createCommonProperty() {
        this.title = new SimpleStringProperty(this, TITLE_PROP_TITLE, "");
        this.cntSections = new SimpleIntegerProperty(this, TITLE_PROP_COUNTSECTIONS, 0);
        this.cntLeafs = new SimpleIntegerProperty(this, TITLE_PROP_COUNTLEAVES, 0);
    }

    private void createLeafs(){
        leaves = new KanbanSection[cntSections.get()];
        for (int i = 0; i < cntSections.get(); i++) {
            leaves[i] = new KanbanSection(this, cntLeafs.get(), new LeafAddress(title.getValue(), i));
        }
    }

    public void setTitle(String title) throws IOException {
        this.title.set(title);
        isTitleEmpty = false;
//        recreateControllers();
        createLeafs();
    }

    @Override
    protected void recreateControllers() throws IOException {
        createLeafs();
        super.recreateControllers();
    }

    // 1) Изменение название канбана
    // 2) Изменение количества секций
    // 3) Изменение количества узлов

    @Override
    public void update () {
//        if (leaves.length != cntSections.getValue()) System.out.println("1");
//        if ((getLeaf(1).getLeafsLength() != cntLeafs.getValue())) System.out.println("1");
        if(isTitleEmpty == false) {
            try {
//                createLeafs();
                recreateControllers();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            super.update();
        }
    }

    public void setCntSections(int cntSections) throws IOException {
        if (this.cntSections.get() != cntSections) {
            this.cntSections.set(cntSections);
            recreateControllers();
        }
    }

    public void setCntLeafs(int cntLeafs) throws IOException {
        if (this.cntLeafs.get() != cntLeafs) {
            this.cntLeafs.set(cntLeafs);
            recreateControllers();
        }
    }

    /*Propertise*/

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public int getCntSections() {
        return cntSections.get();
    }

    public IntegerProperty cntSectionsProperty() {
        return cntSections;
    }

    /*Getters and Setters*/

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public void setEvents(){
    }

    public int getCountLeaves(){
        return cntLeafsProperty().get();
    }

    public int getCntLeafs() {
        return cntLeafs.get();
    }

    public IntegerProperty cntLeafsProperty() {
        return cntLeafs;
    }

    public KanbanSection getLeaf(int i){
        return leaves[i];
    }


    @Override
    public String toString() {
        return "" + title.getValue() + " : " + getCntSections() + " : " + getCountLeaves();
    }

    public int getSectionInd(KanbanSection leaf){
        int result = 0;
        for (int i = 0; i < getCntSections(); i++) {
            //Возвращает индекс позиции на реальном канбане, который начинается с 1, a не как в массиве, где он начинается с 0.
            // Если result останется равным 0 значит карта не содержится в массиве.
            if (leaves[i] == leaf) result = i+1;
        }
        return result;
    }

    public KeyStore getStoreKey(KanbanSection section, KanbanLeaf leaf, Material material){
        String adres = "";
        String leafInd = "-" + section.getLeafInd(leaf);
        if (getTitle().length()==1 && getSectionInd(section)<10) {
            adres = "" + getTitle() + "0" + getSectionInd(section) + leafInd;
        } else {
            adres = "" + getTitle() + getSectionInd(section) + leafInd;
        }

        return new KeyStore("F5", "", material.getTitle());
    }

    //TODO: Чудо происходит здесь. Мы получаем склад и весь материал который в нем хранится.
    public Reserve getStore(KanbanSection section, String a) {
        String adres = "";
        if (getTitle().length()==1 && getSectionInd(section)<10) {
                adres = "" + getTitle() + "0" + getSectionInd(section) + a;
        } else {
            adres = "" + getTitle() + getSectionInd(section) + a;
        }

        Stock stock = null;
        stock = StockSet.getInstance().getStock("F5");
        return stock.getReserve(adres);
    }

    public String getStockTitle() {
        return "F5";
    }

    public String getAddres(KanbanSection section, KanbanLeaf leaf) {
        String addres = "";
        String leafInd = "-" + (section.getLeafInd(leaf)+1);
        if (getTitle().length()==1 && getSectionInd(section)<10) {
            addres = "" + getTitle() + "0" + (getSectionInd(section)+1) + leafInd;
        } else {
            addres = "" + getTitle() + (getSectionInd(section)+1) + leafInd;
        }

        return addres;
    }
}