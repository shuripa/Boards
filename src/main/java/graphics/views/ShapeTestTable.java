package graphics.views;

import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import graphics.controllers.LeyoutComponentController;
import graphics.controllers.TestTableController;

public class ShapeTestTable extends LeyoutComponentView {

    public ShapeTestTable(LeyoutComponentController controller){
        super(controller);
    }

    private int size;

    public void paint() {
        //Тестувальний стіл
        Rectangle rt1 = new Rectangle(size, 20);
        rt1.relocate(.5, .5);
        Rectangle rt2 = new Rectangle(size, 10);
        rt2.relocate(.5, 20.5);
        addActiveElements(rt1, rt2);

        //Комп’ютер
        Rectangle pc1 = new Rectangle(25, 4);           //Монитор
        pc1.setArcWidth(8);
        pc1.setArcHeight(4);
        pc1.relocate(size / 2 - 7, 23.5);
        Rectangle pc2 = new Rectangle(10, 8);           //Подножка
        pc2.relocate(size / 2, 21.5);
        Rectangle prnt = new Rectangle(10, 14);         //Принтер
        prnt.relocate(size / 2 - 18, 18);
        addPassiveElements(pc1, pc2, prnt);

        //Тексты
        Text td = new Text(4, 9, "" + (((TestTableController) controller()).getTitle()));   //description
        Text ti = new Text(size - 29, 18, "" + ((TestTableController) controller()).getId());    //ID
        addTexts(td, ti);
    }

    @Override
    public void repaint() {

    }

}