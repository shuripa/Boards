package graphics.leyout.views;

import graphics.leyout.controllers.KanbanLeafController;
import graphics.leyout.controllers.LeyoutComponentController;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Popup;

public class KanbanLeafView extends LeyoutComponentView {
    int maxCntOrd, fctCntOrd, maxLeafCntOrd;
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
        maxLeafCntOrd = ((KanbanLeafController)controller()).getMaxLeafCountOrder();;
        fctCntOrd = ((KanbanLeafController)controller()).getFactCountOrder();

        Rectangle r = new Rectangle(0,0, maxLeafCntOrd*4 +15, 10);
        addActiveElement(r);

        for (int i = 0; i < maxCntOrd; i++) {
            Rectangle rect = new Rectangle((maxCntOrd+maxLeafCntOrd)*2+3 - i*4, 3, 4, 4);
            rect.setStroke(Color.GREY);
            rect.setFill(Color.WHITE);
            if(i < fctCntOrd && 1 == fctCntOrd)rect.setFill(Color.RED);
            if(i < fctCntOrd && 1 < fctCntOrd) rect.setFill(Color.GREEN);
            if(maxCntOrd == fctCntOrd) rect.setFill(Color.LIME);
            this.getChildren().add(rect);
        }
    }

    @Override
    public void repaint() {

    }
}
