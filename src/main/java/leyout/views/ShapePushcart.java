package leyout.views;

import javafx.scene.input.MouseButton;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;

//Pushcart тележка, ручная тележка, детский стул на колесах
public class ShapePushcart extends LeyoutComponentView {
    public ShapePushcart(){
        super();
        paint();
    }

    @Override
    protected void setEventTonExt(MouseButton button) {

    }

    protected void paint() {
        Polyline p = new Polyline(new double[]{
                3,  0,
                3, -4,
                27,-4,
                27, 0,
                23, 20,
                7,  20,
                3,  0,
                27, 0,
                22, 5,
                19, 16,
                11, 16,
                8,  5,
                3, 0
        });

        Line l0 = new Line(8, 5, 22, 5);

        Line l1 = new Line(15, 0, 15,20);
        Line l2 = new Line(6, 10, 24,10);

        Line l3 = new Line(8, 3, 8,7);
        Line l4 = new Line(22, 3, 22,7);
        Line l5 = new Line(11, 14, 11,18);
        Line l6 = new Line(19, 14, 19,18);
        p.setStrokeWidth(0.2);
        l0.setStrokeWidth(0.2);
        l1.setStrokeWidth(0.2);
        l2.setStrokeWidth(0.2);
        l3.setStrokeWidth(1.2);
        l4.setStrokeWidth(1.2);
        l5.setStrokeWidth(1.2);
        l6.setStrokeWidth(1.2);
        this.getChildren().addAll(p, l0, l1, l2, l3, l4, l5, l6);
    }

    @Override
    public void setSize(int size) {

    }

    @Override
    public void reset() {

    }

    @Override
    public void showInfo() {

    }
}
