package graphics.leyout.views;

import graphics.leyout.components.KanbanBoard;
import graphics.leyout.controllers.KanbanBoardController;
import graphics.leyout.controllers.KanbanSectionController;
import graphics.leyout.controllers.LeyoutComponentController;
import javafx.scene.text.Text;

public class KanbanBoardView extends LeyoutComponentView {

    int countSection, countLeafs;
    Text leafNo, sectNo, title;

    public KanbanBoardView(LeyoutComponentController controller) {
        super(controller);
    }

    @Override
    public void paint() {
        KanbanSectionController leafController;
        leafController = ((KanbanBoardController)controller()).getLeafController(0);
        countSection = ((KanbanBoardController)controller()).countLeaves();
        countLeafs = leafController.countLeafs();
        title = new Text(0, 0, ((KanbanBoardController)controller()).getTitle());
        title.setStyle("-fx-font-size: 8");
        addActiveElement(title);
        for (int i = 0; i < countLeafs; i++) {
            leafNo = new Text(0, 10*i+10, ""+ (countLeafs -i));
            leafNo.setStyle("-fx-font-size: 8");
            addActiveElement(leafNo);
        }
        int maxLeafCountOrder;
        for (int i = 0; i < countSection; i++) {
            maxLeafCountOrder = ((KanbanBoard)controller().component()).getLeaf(i).getMaxLeafCountOrder();
            if (countSection > 10 && i < 9) {
                sectNo = new Text((maxLeafCountOrder * 4 + 15) * (i + 1) - 10, 0, "0" + (i + 1) + "-");
            } else{
                sectNo = new Text((maxLeafCountOrder * 4 + 15) * (i + 1) - 6, 0, "" + (i + 1) + "-");
            }
            sectNo.setStyle("-fx-font-size: 8");
            this.addActiveElement(sectNo);
            leafController = ((KanbanBoardController)controller()).getLeafController(i);
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
