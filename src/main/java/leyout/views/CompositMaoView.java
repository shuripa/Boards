package leyout.views;

import javafx.scene.shape.Rectangle;
import leyout.controllers.LeyoutComponentController;

public class CompositMaoView extends LeyoutComponentView{

    Rectangle pc1, pc2;

    public CompositMaoView(LeyoutComponentController controller){
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
