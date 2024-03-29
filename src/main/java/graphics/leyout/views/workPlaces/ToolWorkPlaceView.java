package graphics.leyout.views.workPlaces;

import graphics.leyout.controllers.LeyoutComponentController;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;

public class ToolWorkPlaceView extends ToolPositionView {
    Text t;

    public ToolWorkPlaceView(LeyoutComponentController controller){
        super(controller);
        t = new Text();
    }

    public void setText(String t) {
        this.t.setText(t);
    }

    @Override
    public void paint() {
        Circle h = new Circle(10, 6, 5);                //head
        Ellipse b = new Ellipse(10, 6, 8, 4);       //body
        Ellipse lh = new Ellipse(3, 10, 1.85, 5);   //left hand
        Ellipse lw = new Ellipse(3.5, 15, 2, 2);    //left wrist
        Ellipse rh = new Ellipse(17, 10, 1.85, 5);  //right hand
        Ellipse rw = new Ellipse(16.5, 15, 2, 2);   //right wrist
        addActiveElements(lh, lw, rh, rw, b, h);
//        t = new Text(""+ ((WorkPlace)controller().components()).getLogined());
        t.relocate(-7, -13);
        addText(t);
    }

    @Override
    public void repaint() {

    }
}