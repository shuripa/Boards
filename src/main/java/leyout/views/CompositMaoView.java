package leyout.views;

import javafx.scene.input.MouseButton;
import javafx.scene.shape.Rectangle;
import leyout.controllers.CompositMaoController;

public class CompositMaoView extends LeyoutComponentView{

    public CompositMaoView(){
        super();
    }

    public CompositMaoView(CompositMaoController compositMaoController, int size, int x, int y, int a) {
        super (compositMaoController, size, x, y, a);
    }

    @Override
    public void paint() {
        //Комп’ютер
        Rectangle pc1 = new Rectangle(25, 4);           //Монитор
        pc1.setArcWidth(8);
        pc1.setArcHeight(4);
//        pc1.relocate(size / 2 - 7, 23.5);
        pc1.relocate(0, 2);
        Rectangle pc2 = new Rectangle(10, 8);           //Подножка
//        pc2.relocate(size / 2, 21.5);
        pc2.relocate(7, 0);
//        Rectangle prnt = new Rectangle(10, 14);         //Принтер
//        prnt.relocate(size / 2 - 18, 18);
//        addActiveElements(pc1, pc2, prnt);
        addActiveElements(pc2, pc1);
    }

    @Override
    public void reset() {

    }

    @Override
    protected void setEventTonExt(MouseButton button) {

    }

    @Override
    public void showInfo() {

    }
}
