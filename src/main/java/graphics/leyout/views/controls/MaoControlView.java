package graphics.leyout.views.controls;

import graphics.leyout.controllers.LeyoutComponentController;
import javafx.scene.shape.Rectangle;

public class MaoControlView extends ControlView {

    Rectangle pc1, pc2;

    public MaoControlView(LeyoutComponentController controller){
        super(controller);
    }

    @Override
    public void paint() {
        //Комп’ютер
        pc1 = new Rectangle(25, 4);           //Монитор
        pc1.setArcWidth(8);
        pc1.setArcHeight(4);
        pc1.relocate(0, 2);
        pc2 = new Rectangle(10, 8);           //Подножка
        pc2.relocate(7, 0);
        addActiveElements(pc2, pc1);
    }

    @Override
    public void repaint() {

    }


}
