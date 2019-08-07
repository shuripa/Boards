package graphics.leyout.controllers;

import graphics.leyout.components.CanbanBoard;
import graphics.leyout.components.CanbanLeaf;
import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.views.CanbanBoardView;

import java.io.IOException;

public class CanbanBoardController extends LeyoutCompositController {

    CanbanLeafController[] canbanLeafControllers;

    public CanbanBoardController(LeyoutComponent component) throws IOException {
        super(component);
        component.addRecreateObservers(this);
        create();
    }

    public void create() throws IOException {

        int n = countLeaves();

        canbanLeafControllers = new CanbanLeafController[n];

        for (int i = 0; i < n; i++) {
            CanbanLeaf canbanLeaf = ((CanbanBoard)component()).getLeaf(i);
            canbanLeafControllers[i] = new CanbanLeafController(canbanLeaf);
            canbanLeafControllers[i].setXY( 3+(canbanLeaf.getMaxLeafCountOrder()*4+15)*i, 2);
        }

        setView(new CanbanBoardView(this));
//        view().update();
    }

    public int countLeaves(){
        return ((CanbanBoard)component()).getCountLeaves();
    }

    public CanbanLeafController getLeafController(int i){
        return canbanLeafControllers[i];
    }

    @Override
    protected void setComponentProperties() {
        setStrProperty(((CanbanBoard)component()).titleProperty());
        setIntProperty(((CanbanBoard)component()).cntLeavesProperty());
        setIntProperty(((CanbanBoard) component()).cntCardsProperty());
    }

    @Override
    public void update(String propertyName) throws IOException {
        if ((propertyName == "Count leaves") || (propertyName == "Count cards") ) {
            if (((CanbanBoard)component()).cntLeavesProperty().get() !=0 && ((CanbanBoard)component()).cntCardsProperty().get() !=0){
            delView(view());
            ((CanbanBoard)component()).update();
            view().relocate(X(), Y());
            }
        }
        super.update();
    }

    @Override
    public void update() {
        int n = countLeaves();
        for (int i = 0; i < n; i++) {
            canbanLeafControllers[i].update();
        }
        super.update();
    }

    @Override
    public void select() {
        int n = countLeaves();
        for (int i = 0; i < n; i++) {
            canbanLeafControllers[i].select();
        }
    }

    @Override
    public void unselect(){
        int n = countLeaves();
        for (int i = 0; i < n; i++) {
            canbanLeafControllers[i].unselect();
        }
    }
}
