package leyout.wievs;

import javafx.scene.input.MouseButton;
import leyout.LeyoutComponentWiev;
import leyout.controllers.HumanController;
import leyout.elements.Human;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;

public class ShapeHuman extends LeyoutComponentWiev {
    Text t;

    public ShapeHuman(HumanController controller){
        super(controller);
        t = new Text();
    }

    @Override
    protected void setEventTonExt(MouseButton button) {

    }

    @Override
    protected void getElements() {

    }

    @Override
    protected void emplacement(int size) {

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
        t = new Text(""+ ((Human)controller.element()).getLogined());
        t.relocate(20, -5 );
        addText(t);
    }

    @Override
    public void setSize(int size) { }

    public void reset(){
        t.setText("" + ((Human)controller.element()).getLogined());
    }

    @Override
    public void showInfo() {

    }
}