package graphics.leyout.views;

import graphics.leyout.controllers.KanbanLeafController;
import graphics.leyout.controllers.KanbanSectionController;
import graphics.leyout.controllers.LeyoutComponentController;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class KanbanSectionView extends LeyoutComponentView {

    KanbanLeafView[] kanbanLeafViews;
    Line hLine;
    Text textNo;
    int maxCntOrd;
    int maxLeafCntOrd;

    public KanbanSectionView(LeyoutComponentController controller) {
        super(controller);
    }

    @Override
    public void paint() {
//        Rectangle r = new Rectangle(0,0, countCards()*5 +2, 10);
//        addActiveElement(r);

        //Лыжа с максимальным заказом
        maxLeafCntOrd = ((KanbanSectionController)controller()).getMaxLeafCountOrder();
        KanbanLeafController leafController;

        for (int i = 0; i < countCards(); i++) {
            leafController = ((KanbanSectionController)controller()).getLeafController(i);
            //Количество заказов на лыже
            maxCntOrd = leafController.getMaxCountOrder();
//            cardNo = new Text (-2, 10*i+10, ""+ (countCards()-i));
//            addText(cardNo);
//            hLine = new Line (0, 10*i, (maxCntOrd+maxLeafCntOrd)*2+3, 10*i);
//            addActiveElements(hLine);
            this.getChildren().add(leafController.view());
        }

    }

    @Override
    public void repaint() {

    }

    public int countCards(){
        return ((KanbanSectionController)controller()).countLeafs();
    }
}
