package graphics.leyout.views;

import graphics.leftPanel.LeftPanel;
import graphics.leyout.controllers.LeyoutComponentController;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.IOException;


public class BoardIndexView extends LeyoutComponentView {
    int limit;
    Rectangle r1, r2;
    Text text;
    public BoardIndexView (LeyoutComponentController controller){
        super(controller);
        limit = 0;
        r1 = new Rectangle(5, 20*limit/100);
        r2 = new Rectangle(5,20*(100-limit)/100);
        addActiveElements(r1, r2);
        text = new Text();
        text.setOnMouseEntered(mouseEvent -> {
            LeftPanel lp = null;
            try {
                lp = new LeftPanel();
            } catch (IOException e) {
                e.printStackTrace();
            }
            lp.show(this, 0, 0);
        });

        addText(text);
    }

    @Override
    public void paint() {
//        limit = ((BoardIndexController)controller()).getProc();
//        r1.setXY(0.5,18.5);
        text.relocate(0, 0);
        r1.relocate(25,15.5 + 20*(100-limit)/100);
        r2.setStyle("-fx-fill: RED");
//        r2.setXY(0.5,18.5 + 20*limit/100);
        r1.setStyle("-fx-fill: LIME");
        r2.relocate(25.5,15.5);

    }


    @Override
    public void repaint() {
        r1.setHeight(20*limit/100);
        r1.relocate(25,15.5 + 20*(100-limit)/100);
        r2.setHeight(20*(100-limit)/100);
    }

    public void setLimit(int limit) {
        this.limit = limit;
        repaint();
    }

    public void setText(String s){
        text.setText(s);
    }

}
