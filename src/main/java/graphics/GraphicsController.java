package graphics;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class GraphicsController {
    final static String TITLE_PROP_X = "X";
    final static String TITLE_PROP_Y = "Y";
    final static String TITLE_PROP_A = "A";
    final static String TITLE_PROP_S = "S";
    final IntegerProperty X;
    final IntegerProperty Y;
    final IntegerProperty A;
    final IntegerProperty S;

    public GraphicsController(){
        X = new SimpleIntegerProperty(this, TITLE_PROP_X, 0);
        Y = new SimpleIntegerProperty(this, TITLE_PROP_Y, 0);
        A = new SimpleIntegerProperty(this, TITLE_PROP_A, 0);
        S = new SimpleIntegerProperty(this, TITLE_PROP_S, 60);
    }

    public int X(){
        return X.get();
    }
    public int Y(){
        return Y.get();
    }
    public int A(){
        return A.get();
    }
    public int S(){
        return S.get();
    }

    public IntegerProperty xProperty() {
        return X;
    }
    public IntegerProperty yProperty() {
        return Y;
    }
    public IntegerProperty aProperty() {
        return A;
    }
    public IntegerProperty sProperty() {
        return S;
    }

    public void setX(int x) {
        this.X.set(x);
    }
    public void setY(int y) {
        this.Y.set(y);
    }
    public void setA(int a) {
        this.A.set(a);
    }
    public void setS(int s) {
        this.S.set(s);
    }

    public abstract void update();

    public abstract void select();
}