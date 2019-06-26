package leyout.views;

import javafx.scene.shape.Rectangle;

public class CompositMaoView extends LeyoutComponentView{


    @Override
    public void paint() {
        //Комп’ютер
        Rectangle pc1 = new Rectangle(25, 4);           //Монитор
        pc1.setArcWidth(8);
        pc1.setArcHeight(4);
        pc1.relocate(0, 2);
        Rectangle pc2 = new Rectangle(10, 8);           //Подножка
        pc2.relocate(7, 0);
        addActiveElements(pc2, pc1);
    }


}
