package graphics.leyout.components;

import inout.CompositBuilder;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.IOException;

public class CompositConvier extends LeyoutComponent{
    private final static String TITLE_PROP_TITLE = "Canban title";
    private final static String TITLE_PROP_COUNTPOS = "Count pos";

    private StringProperty title;
    private IntegerProperty cntPos;

    Convier convier;
    CompositBoard[] boards;

    public CompositConvier () throws IOException {
        this.title = new SimpleStringProperty(this, TITLE_PROP_TITLE);
        this.cntPos = new SimpleIntegerProperty(this, TITLE_PROP_COUNTPOS);
        cntPos.set(6);
        recreateControllers();
    }

    public CompositConvier (int cntPos) throws IOException {
        this.title = new SimpleStringProperty(this, TITLE_PROP_TITLE);
        this.cntPos = new SimpleIntegerProperty(this, TITLE_PROP_COUNTPOS);
        this.cntPos.set(cntPos);
        recreateControllers();
    }

    public CompositConvier(CompositBuilder builder) throws IOException{
        this.title = new SimpleStringProperty(this, TITLE_PROP_TITLE);
        this.cntPos = new SimpleIntegerProperty(this, TITLE_PROP_COUNTPOS);
        this.title.set(builder.getTitle());
        this.cntPos.set(builder.getSections());

        recreateControllers();
    }

    @Override
    protected void recreateControllers() throws IOException {
        convier = new Convier(cntPos.get());
        addLeaf(convier);
        boards = new CompositBoard[cntPos.get()];
        int n = cntPos.get();
        for (int i = 0; i < n; i++) {
            CompositBoard b = new CompositBoard();
            b.setTitle("Pos " + (i + 1));
            boards[i] = b;
            addLeaf(b);
        }
        super.recreateControllers();
    }

    public void destroy(){
        delLeaf(convier);
        int n = boards.length;
        for (int i = 0; i < n; i++) {
            delLeaf(boards[i]);
            boards[i].destroy();
        }
        boards = null;
    }

    @Override
    public void update() {
        if (boards.length == cntPos.get()){
        }else {
            destroy();
            try {
                recreateControllers();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Convier getConvier() {
        return convier;
    }

    public CompositBoard getBoard (int i){
        return boards[i];
    }

//    Properties

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public int getCntPos() {
        return cntPos.get();
    }

    public IntegerProperty cntPosProperty() {
        return cntPos;
    }

    public void setCntPos(int cntPos) {
        this.cntPos.set(cntPos);
    }

    @Override
    public String toString() {
        return "";
    }
}