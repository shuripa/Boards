package graphics.views;

import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import graphics.controllers.LeyoutComponentController;

public class BoardView extends LeyoutComponentView {

    Text tt, ti;        //Text title, Text Id
    Rectangle rb;
    Line l;

    public BoardView(LeyoutComponentController controller){
        super (controller);
        rb = new Rectangle(.5 ,.5, 55, 20);
        l = new Line(1, 9.5, 53, 9.5);
        ti = new Text(2, 8, "");
        tt = new Text(2, 19, "");
        addActiveElements(rb, l);
        addTexts(tt, ti);
    }

    @Override
    public void paint(){

    }

    @Override
    public void repaint() {
        rb.setWidth(controller().getS()-5);
        l.setEndX(controller().getS()-5);
    }

    public void setTt(String tt) {
        this.tt.setText(tt);
    }

    public void setTi(String ti) {
        this.ti.setText(ti);
    }
}