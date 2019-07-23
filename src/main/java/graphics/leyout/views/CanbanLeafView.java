package graphics.leyout.views;

import graphics.leyout.controllers.CanbanCardController;
import graphics.leyout.controllers.CanbanLeafController;
import graphics.leyout.controllers.LeyoutComponentController;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class CanbanLeafView extends LeyoutComponentView {

    CanbanCardView[] canbanCardViews;
    Line hLine;
    Text textNo;
    int maxCntOrd;
    int maxLeafCntOrd;

    public CanbanLeafView(LeyoutComponentController controller) {
        super(controller);
    }

    @Override
    public void paint() {
//        Rectangle r = new Rectangle(0,0, countCards()*5 +2, 10);
//        addActiveElement(r);

        maxLeafCntOrd = ((CanbanLeafController)controller()).getMaxLeafCountOrder();
        CanbanCardController cardController;

        for (int i = 0; i < countCards(); i++) {
            cardController = ((CanbanLeafController)controller()).getCardController(i);
            maxCntOrd = cardController.getMaxCountOrder();
//            cardNo = new Text (-2, 10*i+10, ""+ (countCards()-i));
//            addText(cardNo);
            hLine = new Line (0, 10*i, (maxCntOrd+maxLeafCntOrd)*2+3, 10*i);
            addActiveElements(hLine);
            this.getChildren().add(cardController.view());
        }

    }

    @Override
    public void repaint() {

    }

    public int countCards(){
        return ((CanbanLeafController)controller()).countCards();
    }
}
