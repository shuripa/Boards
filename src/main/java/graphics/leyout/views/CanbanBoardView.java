package graphics.leyout.views;

import graphics.leyout.components.CanbanBoard;
import graphics.leyout.controllers.CanbanBoardController;
import graphics.leyout.controllers.CanbanLeafController;
import graphics.leyout.controllers.LeyoutComponentController;
import javafx.scene.text.Text;

public class CanbanBoardView extends LeyoutComponentView {

    int countLeaves, countCards;
    Text cardNo, leafNo;

    public CanbanBoardView(LeyoutComponentController controller) {
        super(controller);
    }

    @Override
    public void paint() {
        CanbanLeafController leafController;
        leafController = ((CanbanBoardController)controller()).getLeafController(0);
        countLeaves = ((CanbanBoardController)controller()).countLeaves();
        countCards = leafController.countCards();
        for (int i = 0; i < countCards; i++) {
            cardNo = new Text(0, 10*i+10, ""+ (countCards-i));
            cardNo.setStyle("-fx-font-size: 8");
            addActiveElement(cardNo);
        }
        int maxLeafCountOrder;
        for (int i = 0; i < countLeaves; i++) {
            maxLeafCountOrder = ((CanbanBoard)controller().component()).getLeaf(i).getMaxLeafCountOrder();
            if (i<9) {
                leafNo = new Text((maxLeafCountOrder*4+15)*(i+1)-12, 0, "-0" + (i+1));
            } else {
                leafNo = new Text((maxLeafCountOrder*4+15)*(i+1)-12, 0, "-" + (i+1));
            }
            leafNo.setStyle("-fx-font-size: 9");
            this.addActiveElement(leafNo);
            leafController = ((CanbanBoardController)controller()).getLeafController(i);
            this.getChildren().add(leafController.view());
        }
    }

    @Override
    public void repaint() {

    }

    public void delLeafView(LeyoutComponentView view) {
        this.getChildren().remove(view);
    }
}
