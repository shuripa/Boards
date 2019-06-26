package leyout.views;

import javafx.scene.shape.Rectangle;
import leyout.controllers.BoardIndexController;


public class BoardIndexView extends LeyoutComponentView {


    @Override
    public void paint() {
        int limit = ((BoardIndexController)controller()).getProc();
        Rectangle r1 = new Rectangle(5, 20*limit/100);
        r1.setStyle("-fx-fill: LIME");
//        r1.setXY(0.5,18.5);
        r1.relocate(0.5,18.5 + 20*(100-limit)/100);
        Rectangle r2 = new Rectangle(5,20*(100-limit)/100);
        r2.setStyle("-fx-fill: RED");
//        r2.setXY(0.5,18.5 + 20*limit/100);
        r2.relocate(0.5,18.5);
        addActiveElements(r1, r2);
    }

}
