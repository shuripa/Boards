package cards.views;

import graphics.components.LeyoutComponent;
import cards.controllers.PaneComponentController;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;


public class BoardCardView extends PaneComponentView {

    public BoardCardView (PaneComponentController controller){
        super (controller);
    }

    @Override
    public void paint() {
        this.setScaleX(0.95);
        this.setScaleY(0.95);

        Rectangle rc = new Rectangle(220, 50);
        rc.setId("blank");
        rc.setStrokeWidth(0.5);
        rc.relocate(.5, .5);
        addActiveElement(rc);

        Group grd = new Grd();
        grd.relocate(2, 2);
        Group brd = new Brd();
        brd.relocate(2, 27);
        Group hum = new Hum();
        hum.relocate(22, 10);

        getChildren().addAll(brd, hum, grd);
    }




    @Override
    public void repaint() {

    }

    @Override
    public void setComponentProperties() {

    }

    @Override
    protected LeyoutComponent component() {
        return null;
    }

    @Override
    public void setViewProperties() {

    }
}

class Hum extends Group{
    Hum(){
        Circle h = new Circle(10, 6, 5);                //head
        Ellipse b = new Ellipse(10, 6, 8, 4);       //body
        Ellipse lh = new Ellipse(3, 10, 1.85, 5);   //left hand
        Ellipse lw = new Ellipse(3.5, 15, 2, 2);    //left wrist
        Ellipse rh = new Ellipse(17, 10, 1.85, 5);  //right hand
        Ellipse rw = new Ellipse(16.5, 15, 2, 2);   //right wrist
        this.getChildren().addAll(lh, lw, rh, rw, b, h);
        for (Node s: this.getChildren()) {
            s.setStyle("-fx-fill: RGBA(255,255,255, 0.3); -fx-stroke: RGBA(0, 0, 0, 0.5)");
        }
    }
}

class Brd extends Group {
    Brd() {
        Rectangle rb = new Rectangle(.5, .5, 60, 20);
        Line l = new Line(1, 9.5, 58, 9.5);
        this.getChildren().addAll(rb, l);
        for (Node s : this.getChildren()) {
            s.setStyle("-fx-fill: RGBA(255,255,255, 0.3); -fx-stroke: RGBA(0, 0, 0, 0.5)");
        }
    }
}

class Grd extends Group{
    Grd() {
        Rectangle rg = new Rectangle(60, 5);       //rectangle centr
        rg.relocate(.5, 1.5);
        Rectangle rl = new Rectangle(5, 7);      //rectangle left
        rl.relocate(5, .5);
        Rectangle rr = new Rectangle(5, 7);      //rectangle right
        rr.relocate(50, .5);
        this.getChildren().addAll(rg, rl, rr);
        for (Node s : this.getChildren()) {
            s.setStyle("-fx-fill: RGBA(255,255,255, 0.3); -fx-stroke: RGBA(0, 0, 0, 0.5)");
        }
    }
}