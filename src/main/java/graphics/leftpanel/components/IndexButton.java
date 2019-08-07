package graphics.leftpanel.components;

import graphics.leyout.components.LeyoutComponent;
import sets.SetWorkPlacedComposits;

/**
 * IndexButton: Индекс, показатель, указатель, признак, алфавитный указатель, каталог, метка, показатель степени
 * Индикаторная кнопка на левой панели. Новое решение. IndicateButoon подходит больше но занято старой реализацией
 */

public abstract class IndexButton extends LeyoutComponent {
    private int index;
    private String hint;
    private String measure;

    public IndexButton (String hint, String measure){
        this.hint = hint;
        this.measure = measure;
        index = 0;
        SetWorkPlacedComposits.getInstance().addObserver(this);
    }

    public int getIndex(){
        return index;
    }

    public String getIndexAsText(){
        return "" + getIndex() + measure;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public abstract void action();

    @Override
    public String toString() {
        return hint;
    }
}
