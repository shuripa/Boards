package graphics.leyout.controllers;

import graphics.leyout.components.CanbanCard;
import graphics.leyout.components.CanbanLeaf;
import graphics.leyout.views.CanbanLeafView;

import java.io.IOException;

public class CanbanLeafController extends LeyoutComponentController {
    CanbanCardController[] canbanCardControllers;

    public CanbanLeafController(CanbanLeaf canbanLeaf) throws IOException {
        super(canbanLeaf);
        canbanCardControllers = new CanbanCardController[countCards()];
        for (int i = 0; i < countCards(); i++) {
            CanbanCard canbanCard = ((CanbanLeaf)component()).getCard(i);
            canbanCardControllers[i] = new CanbanCardController(canbanCard);
            canbanCardControllers[i].setXY(0, (countCards()-i-1)*10);
        }
        setView(new CanbanLeafView(this));
    }

    public int countCards(){
        return ((CanbanLeaf)component()).getCountCard();
    }

    public CanbanCardController getCardController (int i){
        return canbanCardControllers[i];
    }

    public int getMaxLeafCountOrder() {
        return ((CanbanLeaf)component()).getMaxLeafCountOrder();
    }

    @Override
    protected void setComponentProperties() {

    }

    @Override
    public void update() {
        for (int i = 0; i < countCards(); i++) {
            canbanCardControllers[i].update();
        }
        super.update();
    }

    @Override
    public void select() {
        for (int i = 0; i < countCards(); i++) {
            canbanCardControllers[i].select();
        }
    }

    @Override
    public void unselect(){
        for (int i = 0; i < countCards(); i++) {
            canbanCardControllers[i].unselect();
        }
    }


}
