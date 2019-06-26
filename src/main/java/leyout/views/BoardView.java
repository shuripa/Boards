package leyout.views;

import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class BoardView extends LeyoutComponentView {

    Text tt, ti;

    public void paint(){

        Rectangle rb = new Rectangle(controller().getS()-5,20);                                //Rectangle Board
            rb.relocate(.5,.5);
        Line l = new Line(1, 9.5, controller().getS()-6, 9.5);                         //Split line in board

        Text tt = new Text("");     //Text title
//            td.setXY(4,18);
        tt.setX(4);
        tt.setY(18);

        Text ti = new Text("");        //Text ID
//            ti.setXY(2, 8);
        ti.setX(2);
        ti.setY(8);

        addActiveElements(rb, l);
        addTexts(tt, ti);
    }



}