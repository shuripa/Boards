package graphics.leyout.components;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import model.Employer;
import model.Order;
import java.util.ArrayList;

/**
 * Effectivity это показатель ефективности размещения работника на рабочем месте в %
 * Пример работы:
 * - Заказ1: модуль1, время ет. 6 минут, 10 штук = 60 минут. Продуктивность 90%. Еффективность 10*0,9 = 90 на протяжении 1 часа = 1/8 смены. Примерно 12%
 * - Заказ2: модуль2, время 12 минут, 20 штук = 320 минут. Продуктивность 80%. Еффективность 20*0,8 = 160 на протяжении 4 часов = 1/2 смены Примерно 80%
 * 1	2	3	4	5	6	7	8
 * 90	80	80	80	80	70	50	30
 * 90+320+70+50+30 = 560
 * 560/8 = 70% - общая эффективность размещения работника на рабочем месте.
 * Таким образом Общая Еффективность это сумма(Еффективность заказа*время выполнения)/время смены
 *
 */

public class EffectivityIndex extends LeyoutComponent {
    private final static String TITLE_PROP_EFFECTIVITY = "Complete shift";

    private final IntegerProperty effectivity;

    private Double totalEffectivity;

    public EffectivityIndex(LeyoutComponent parent) {
        this.effectivity = new SimpleIntegerProperty(this, TITLE_PROP_EFFECTIVITY, 0);
        this.totalEffectivity = .0;
        setParent(parent);
    }

    public void update(){
        totalEffectivity = totalEffectivity(480);
    }

    public double totalEffectivity(int shiftTime){
        double totalEmpOrdTime = 0;

        Employer e = ((CompositBoard)parent()).getWorkPlace().getEmployer();
        ArrayList<Order> orders = ((CompositBoard)parent()).getOrders();
        if (e != null)
            for(Order o: orders){
                // 100 * 6.4хв / 75% * 10 шт = 85хв
                int k = (int) ((shiftTime - totalEmpOrdTime) / o.getCount());           //Остаток от заказа на остаток рабочего времени
                double empOrderTime = 100 * o.getEtalonTime()/e.productivity(o.getMaterial())*k;
                totalEmpOrdTime += empOrderTime;
            }

        return totalEmpOrdTime;
    }

    public Double getTotalEffectivity() {
        return totalEffectivity;
    }

    public int getEffectivity() {
        return effectivity.get();
    }

    public IntegerProperty effectivityProperty() {
        return effectivity;
    }

    public void setEffectivity(int effectivity) {
        this.effectivity.set(effectivity);
    }

    @Override
    public String toString() {
        return "";
    }
}
