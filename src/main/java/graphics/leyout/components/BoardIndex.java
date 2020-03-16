package graphics.leyout.components;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import model.Employer;
import model.Orders;

public class BoardIndex extends LeyoutComponent {

    private final static String TITLE_PROP_COMPLETESHIFT = "Complete shift";                                            //Название свойства Завершение смещения //TODO: раздутость функциональности. Набор свойств нужно отделить.
    private final IntegerProperty completeShift;                                                                        //Числовое свойтсо завершениеСмещения.  //TODO: собственно точное название будет значение(а не завершение) индикатора(а не смещения).

    Orders _orders;

    public BoardIndex() {
        this.completeShift = new SimpleIntegerProperty(this, TITLE_PROP_COMPLETESHIFT, 0);
        setParent(null);
    }

    public BoardIndex(LeyoutComponent parent) {
        this.completeShift = new SimpleIntegerProperty(this, TITLE_PROP_COMPLETESHIFT, 0);
        setParent(parent);
    }

    /*CompleteShift property*/
    public int getProc() {
        return completeShift.get();
    }

    public void setProc(int proc){
        this.completeShift.setValue(proc);
    }

    public IntegerProperty procProperty() {
        return completeShift;
    }


    @Override
    public void update(){
        _orders = ((CompositBoard)parent()).orders();
        super.update();
    }

    /*Orders*/

    /*Employer for to get in a employer skill*/
    private Employer employer() {
        return ((CompositBoard) parent()).getEmployer();
    }

    @Override
    public String toString(){
        update();
        String result = "Замовлення:";
        result += _orders.tableRecords(employer());
        result += _orders.orderSummaryBlock(employer());
        return result;
    }
}
