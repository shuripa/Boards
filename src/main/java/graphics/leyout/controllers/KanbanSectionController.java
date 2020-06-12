package graphics.leyout.controllers;

import graphics.leyout.components.KanbanLeaf;
import graphics.leyout.components.KanbanSection;
import graphics.leyout.views.KanbanSectionView;

import java.io.IOException;

public class KanbanSectionController extends LeyoutComponentController {
    KanbanLeafController[] kanbanLeafControllers;

    public KanbanSectionController(KanbanSection kanbanSection) throws IOException {
        super(kanbanSection);
        kanbanLeafControllers = new KanbanLeafController[countCards()];
        for (int i = 0; i < countCards(); i++) {
            KanbanLeaf kanbanLeaf = ((KanbanSection)component()).getCard(i);
            kanbanLeafControllers[i] = new KanbanLeafController(kanbanLeaf);
            kanbanLeafControllers[i].setXY(0, (countCards()-i-1)*10);
        }
        setView(new KanbanSectionView(this));
    }

    public int countCards(){
        return ((KanbanSection)component()).getCountCard();
    }

    public KanbanLeafController getCardController (int i){
        return kanbanLeafControllers[i];
    }

    public int getMaxLeafCountOrder() {
        return ((KanbanSection)component()).getMaxLeafCountOrder();
    }

    @Override
    protected void setComponentProperties() {

    }

    @Override
    public void update() {
        for (int i = 0; i < countCards(); i++) {
            kanbanLeafControllers[i].update();
        }
        super.update();
    }

    @Override
    public void select() {
        for (int i = 0; i < countCards(); i++) {
            kanbanLeafControllers[i].select();
        }
    }

    @Override
    public void unselect(){
        for (int i = 0; i < countCards(); i++) {
            kanbanLeafControllers[i].unselect();
        }
    }


}
