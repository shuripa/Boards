package graphics.leyout.views;

import graphics.leyout.controllers.KanbanLeafController;
import graphics.leyout.controllers.LeyoutComponentController;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Popup;

public class KanbanLeafView extends LeyoutComponentView {
    int maxCntOrd, fctCntOrd, maxCntOrdInSection;
    boolean horisontal;
    Popup popupHint;
    Text textHint;

    public KanbanLeafView(LeyoutComponentController controller) {
        super(controller);
        horisontal = true;
    }

    @Override
    public void paint() {

        maxCntOrd = ((KanbanLeafController)controller()).getMaxCountOrder();
        fctCntOrd = ((KanbanLeafController)controller()).getFactCountOrder();
        maxCntOrdInSection = ((KanbanLeafController)controller()).getMaxLeafCountOrder();

        Rectangle r = new Rectangle(0,0, maxCntOrdInSection *4 +15, 10);
        String mat = ((KanbanLeafController)controller()).getMaterial();
        if (mat.equals("") || mat .equals("\"\"")){
            r.setFill(Color.GRAY);
            r.setStroke(Color.BLACK);
        }

        addActiveElement(r);

        for (int i = 0; i < maxCntOrd; i++) {
            //Рисуем с конца
            Rectangle rect = new Rectangle((maxCntOrd+ maxCntOrdInSection)*2+3 - i*4, 3, 4, 4);
            rect.setStroke(Color.GREY);
            rect.setFill(Color.WHITE);

            int ordr = ((KanbanLeafController)controller()).ordered();
            int join = ((KanbanLeafController)controller()).joined();
            int free = ((KanbanLeafController)controller()).freed();
            if(free > i){
                if (free > i+ 1) rect.setFill(Color.SALMON);
                rect.setStroke(Color.RED);
                rect.setLayoutX(rect.getLayoutX() + 3);
            }else if(join > i-free){
                rect.setFill(Color.PALEGREEN);
                rect.setStroke(Color.GREEN);
            } else if(ordr > i-free-join){
                if (0 == i-free-join) {
                    rect.setFill(Color.WHITE);
                    if (((KanbanLeafController)controller()).orderIsStarted()){
                        rect.setFill(Color.PLUM);
                    }
                } else {
                    rect.setFill(Color.ROYALBLUE);
                }
                rect.setStroke(Color.BLUE);
                rect.setLayoutX(rect.getLayoutX() - 3);
            }

            //Старая реализация. Оставлено для примера.
            //если колич заказов равно 1, для всех кубиком с индексом меньше 1.
//            if(1 == fctCntOrd  &&  i < fctCntOrd)rect.setFill(Color.RED);
            //если количество заказов больше 1, для всех кубиков до индекса = количеству заказов.
//            if(1 < fctCntOrd && i < fctCntOrd ) rect.setFill(Color.GREEN);
            if(maxCntOrd == fctCntOrd) rect.setFill(Color.LIME);

            this.getChildren().add(rect);
        }
    }

    @Override
    public void repaint() {

    }
}
