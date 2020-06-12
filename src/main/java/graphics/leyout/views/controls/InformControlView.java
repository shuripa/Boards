package graphics.leyout.views.controls;

import graphics.leyout.controllers.LeyoutComponentController;
import javafx.scene.shape.Rectangle;

public class InformControlView extends ControlView {
    Rectangle rt1, rt2;

    public InformControlView(LeyoutComponentController controller) {
        super(controller);
        rt1 = new Rectangle(0, 0, 40, 15);
        rt2 = new Rectangle(0, 15, 40, 20);
    }

    @Override
    public void paint() {
        addActiveElements(rt1, rt2);
        //Комп’ютер
        Rectangle pc1 = new Rectangle(25, 4);           //Монитор
        pc1.setArcWidth(8);
        pc1.setArcHeight(4);
        pc1.relocate(20 - 7, 23.5);
        Rectangle pc2 = new Rectangle(10, 8);           //Подножка
        pc2.relocate(20, 21.5);
        Rectangle prnt = new Rectangle(10, 14);         //Принтер
        prnt.relocate(20 - 18, 18);
        addPassiveElements(pc1, pc2, prnt);
    }

    @Override
    public void repaint() {

    }
}
