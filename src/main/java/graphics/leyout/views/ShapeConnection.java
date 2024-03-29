package graphics.leyout.views;

import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;
import graphics.leyout.components.GroupLine;
import graphics.leyout.controllers.CompositBoardController;

@Deprecated
public class ShapeConnection extends LeyoutComponentView {
    double x1;
    double y1;
    double x2;
    double y2;
    double bx1;
    double by1;
    double bx2;
    double by2;


    public ShapeConnection(CompositBoardController controller, double x1, double y1, double x2, double y2){
        super(controller);

        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

        if (x2 > x1) {
            bx1 = x1 - 35;
            bx2 = x2 + 35;
        } else{
            bx1 = x1 + 35;
            bx2 = x2 - 35;
        }

        if (y2 > y1){
            by1 = y1 + 35;
            by2 = y2 - 35;
        } else {
            by1 = y1 - 35;
            by2 = y2 + 35;
        }

    }


    @Override
    public void paint() {
        CubicCurve c = new CubicCurve(
                x1,
                y1,
                bx1,
                by1,
                bx2,
                by2,
                x2,
                y2
        );
        c.toBack();
        GroupLine.getInstance().add(c);

        Line l = new Line(x1, y1, x2, y2);
    }

    @Override
    public void repaint() {

    }

}
