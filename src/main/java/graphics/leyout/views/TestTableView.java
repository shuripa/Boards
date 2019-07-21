package graphics.leyout.views;

import graphics.leyout.controllers.LeyoutComponentController;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class TestTableView extends LeyoutComponentView {

    Rectangle rt1, rt2;
    Text tt, ti;

    public TestTableView(LeyoutComponentController controller){
        super(controller);
        rt1 = new Rectangle();
        rt2 = new Rectangle();
    }

    private int size;

    public void paint() {
        //Тестувальний стіл
        rt1.setWidth(controller().S());
        rt1.setHeight(20);
        rt1.relocate(.5, .5);
        rt2.setWidth(controller().S());
        rt2.setHeight(10);
        rt2.relocate(.5, 20.5);
        addActiveElements(rt1, rt2);

        //Комп’ютер
        Rectangle pc1 = new Rectangle(25, 4);           //Монитор
        pc1.setArcWidth(8);
        pc1.setArcHeight(4);
        pc1.relocate(controller().S() / 2 - 7, 23.5);
        Rectangle pc2 = new Rectangle(10, 8);           //Подножка
        pc2.relocate(controller().S() / 2, 21.5);
        Rectangle prnt = new Rectangle(10, 14);         //Принтер
        prnt.relocate(controller().S() / 2 - 18, 18);
        addPassiveElements(pc1, pc2, prnt);

        //Тексты
        tt = new Text(4, 9, "" );   //description
        ti = new Text( controller().S()- 29, 18, "" );    //ID
        addTexts(tt, ti);
    }

    @Override
    public void repaint() {
        rt1.setWidth(controller().S());
        rt2.setWidth(controller().S());
    }

    public void setTitleText(String titleText){
        tt.setText(titleText);
    }

    public void setIdText(String idText){
        ti.setText(idText);
    }
}