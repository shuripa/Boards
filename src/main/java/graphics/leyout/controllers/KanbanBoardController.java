package graphics.leyout.controllers;

import graphics.leyout.components.KanbanBoard;
import graphics.leyout.components.KanbanSection;
import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.views.KanbanBoardView;
import inout.CompositBuilder;

import java.io.IOException;

public class KanbanBoardController extends LeyoutCompositController {

    KanbanSectionController[] kanbanSectionControllers;

    public KanbanBoardController(LeyoutComponent component) throws IOException {
        super(component);
        component.addRecreateObservers(this);
        create();
    }

    public KanbanBoardController(LeyoutComponent component, CompositBuilder builder) throws IOException {
        super(component);
        component.addRecreateObservers(this);
        create();
        setXYAS(builder.getX(), builder.getY(), builder.getA(), builder.getS());
    }

    public void create() throws IOException {

        int n = countLeaves();

        kanbanSectionControllers = new KanbanSectionController[n];
        int space = 3;

        for (int i = 0; i < n; i++) {
            KanbanSection kanbanSection = ((KanbanBoard)component()).getLeaf(i);
            kanbanSectionControllers[i] = new KanbanSectionController(kanbanSection);
            int max = Math.max(kanbanSection.getMaxLeafCountOrder(), 2);
//            System.out.println( "" + max + " : " + kanbanSection.getMaxLeafCountOrder());
//            kanbanSectionControllers[i].setXY( 3+(max*4+15)*i, 2);
            kanbanSectionControllers[i].setXY( space, 2);
            space = space + max*4 +15;
        }

        setView(new KanbanBoardView(this));
//        view().update();
    }

    public int countLeaves(){
        return ((KanbanBoard)component()).getCntSections();
    }

    public String getTitle(){
        return ((KanbanBoard)component()).getTitle();
    }

    public KanbanSectionController getLeafController(int i){
        return kanbanSectionControllers[i];
    }

    @Override
    protected void setComponentProperties() {
        setStrProperty(((KanbanBoard)component()).titleProperty());
        setIntProperty(((KanbanBoard)component()).cntSectionsProperty());
        setIntProperty(((KanbanBoard) component()).cntLeafsProperty());
    }

    @Override
    public void update(String propertyName) {
        if ((propertyName == "Count leaves") || (propertyName == "Count cards") ) {
            if (((KanbanBoard)component()).cntSectionsProperty().get() !=0 && ((KanbanBoard)component()).cntLeafsProperty().get() !=0){
            delView(view());
            component().update();
            view().relocate(X(), Y());
            }
        }
        super.update();
    }

    @Override
    public void update() {
        int n = countLeaves();
        for (int i = 0; i < n; i++) {
            kanbanSectionControllers[i].update();
        }
        super.update();
    }

    @Override
    public void select() {
        int n = countLeaves();
        for (int i = 0; i < n; i++) {
            kanbanSectionControllers[i].select();
        }
    }

    @Override
    public void unselect(){
        int n = countLeaves();
        for (int i = 0; i < n; i++) {
            kanbanSectionControllers[i].unselect();
        }
    }
}