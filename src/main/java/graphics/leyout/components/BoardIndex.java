package graphics.leyout.components;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import model.Employee;
import model.Orders;

public class BoardIndex extends LeyoutComponent {

    /**
     * BoardIndex - Indicator
     * Індикатор графічно відображає загальний час замовлень наявних в системі контролю і доступних
     * для виконання на дошці. і сам є активним графічним елементом. Реагує на зміну працівника на
     * робочому місці.
     * При відсутності працівника індикатор відображає еталонний час. При залогуванні час вираховується
     * відповідно до працівника.
     * Таким чином індикатор звязаний з поняттями набір замовлень
     * - система контролю - композитний елемент - дошка - умова дошки
     * - робоче місце - працівник - продуктивність.
     * - формула
     * Додаткова інформація доступна в текстовому вигляді при натисканні правої клавіші миші.
     * Формується таблиця зі списком замовлень і сумарними показниками
     * Таблиця
     *      Модуль - Кількість : Еталонний час (хв) * Продуктивність (%) = Час замовлення (год)
     * Підсумок
     *      Сумарний час потужності - 0.0 змін
     *      Сумарний робочий час - 0.0 змін
     *
     * Властивості:
     *      - заповненість дошки
     * Поля:
     * (Конструктор)
     * (Методи доступу)
     * (Оновлення)
     * (Інформаційний текст)
     * (Допоміжні процедури)
     */

    private final static String TITLE_PROP_COMPLETESHIFT = "Complete shift";    //Название свойства Завершение смещения //TODO: раздутость функциональности. Набор свойств нужно отделить.
    private final IntegerProperty completeShift;                                //Числовое свойтсо завершениеСмещения.  //TODO: собственно точное название будет значение(а не завершение) индикатора(а не смещения).


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
        super.update();
    }

    @Override
    public String toString(){
        update();
        String result = "Замовлення:";
        result += orders().tableRecords(employer());
        result += orders().orderSummaryBlock(employer());
        return result;
    }

    private Orders orders(){
        return ((CompositBoard)parent()).orders();
    }

    private Employee employer() {
        return ((CompositBoard) parent()).getEmployee();
    }
}