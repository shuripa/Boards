package graphics.leyout.controllers;

import graphics.leyout.components.KanbanLeaf;
import graphics.leyout.components.KanbanSection;
import graphics.leyout.views.KanbanSectionView;

import java.io.IOException;

public class KanbanSectionController extends LeyoutComponentController {
    KanbanLeafController[] kanbanLeafControllers;

    public KanbanSectionController(KanbanSection kanbanSection) throws IOException {
        super(kanbanSection);
        kanbanLeafControllers = new KanbanLeafController[countLeafs()];
        for (int i = 0; i < countLeafs(); i++) {
            KanbanLeaf kanbanLeaf = ((KanbanSection)component()).getLeaf(i);
            kanbanLeafControllers[i] = new KanbanLeafController(kanbanLeaf);
            kanbanLeafControllers[i].setXY(0, (countLeafs()-i-1)*10);
        }
        setView(new KanbanSectionView(this));
    }

    public int countLeafs(){
        return ((KanbanSection)component()).getCountLeafs();
    }

    public KanbanLeafController getLeafController(int i){
        return kanbanLeafControllers[i];
    }

    public int getMaxLeafCountOrder() {
        return Math.max(((KanbanSection)component()).getMaxLeafCountOrder(),2);
    }

    @Override
    protected void setComponentProperties() {

    }

    @Override
    public void update() {
        for (int i = 0; i < countLeafs(); i++) {
            kanbanLeafControllers[i].update();
        }
        super.update();
    }

    @Override
    public void select() {
        for (int i = 0; i < countLeafs(); i++) {
            kanbanLeafControllers[i].select();
        }
    }

    @Override
    public void unselect(){
        for (int i = 0; i < countLeafs(); i++) {
            kanbanLeafControllers[i].unselect();
        }
    }


}
