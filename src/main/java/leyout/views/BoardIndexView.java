package leyout.views;

import javafx.scene.shape.Rectangle;
import leyout.controllers.LeyoutComponentController;


public class BoardIndexView extends LeyoutComponentView {
    int limit;
    Rectangle r1, r2;
    public BoardIndexView (LeyoutComponentController controller){
        super(controller);
        limit = 0;
        r1 = new Rectangle(5, 20*limit/100);
        r2 = new Rectangle(5,20*(100-limit)/100);
        addActiveElements(r1, r2);
    }

    @Override
    public void paint() {
//        limit = ((BoardIndexController)controller()).getProc();
        r1.setStyle("-fx-fill: LIME");
//        r1.setXY(0.5,18.5);
        r1.relocate(0.5,0.5 + 20*(100-limit)/100);
        r2.setStyle("-fx-fill: RED");
//        r2.setXY(0.5,18.5 + 20*limit/100);
        r2.relocate(0.5,0.5);
    }


    @Override
    public void repaint() {
        r1.setHeight(20*limit/100);
        r1.relocate(0.5,0.5 + 20*(100-limit)/100);
        r2.setHeight(20*(100-limit)/100);
    }

    public void setLimit(int limit) {
        this.limit = limit;
        repaint();
    }

}
