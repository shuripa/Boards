package graphics.leyout.views;

import graphics.leyout.controllers.LeyoutComponentController;
import graphics.leyout.controllers.ManagerTableController;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import model.Profession;
import model.ProfessionColor;

public class ManagerTableView extends LeyoutComponentView {

    Shape tableL, tableR;

    public ManagerTableView(LeyoutComponentController controller) {
        super(controller);
    }

    @Override
    public void paint() {
        Profession p = ((ManagerTableController)controller()).getProfession();

        //left
        Arc arcL = new Arc(45, 57, 30, 27, 145, -45);
        arcL.setType(ArcType.ROUND);
        Rectangle rect1L = new Rectangle( 0, 0, 90, 40);
        Rectangle rect2L = new Rectangle( 40, 30, 50, 10);
        Shape tL = Shape.subtract(rect1L, rect2L);
        Shape tableL = Shape.subtract(tL, arcL);
        Rectangle rectProfL = new Rectangle(83, 0, 7, 30);
//        String pn = p.name();
//        ProfessionColor pc = ProfessionColor.valueOf(pn);
//        String s = pc.toString();
        System.out.println(p.name());
        System.out.println(ProfessionColor.valueOf(p.name()));
        rectProfL.setStyle("-fx-fill: " + ProfessionColor.valueOf(p.name()).toString() + ";");

        //right
        Arc arcR = new Arc(50, 57, 30, 27, 40, 50);
        arcR.setType(ArcType.ROUND);
        Rectangle rect1R = new Rectangle( 0, 0, 90, 40);
        Rectangle rect2R = new Rectangle( 0, 30, 50, 10);
        Shape tR = Shape.subtract(rect1R, rect2R);
        Shape tableR = Shape.subtract(tR, arcR);
        Rectangle rectProfR = new Rectangle(0, 0, 7, 30);
        rectProfR.setStyle("-fx-fill: " + ProfessionColor.valueOf(p.name()).toString() + ";");


        switch (((ManagerTableController)controller()).getSide()){
            case UP_LEFT: addActiveElements(tableL, rectProfL);  break;
            case UP_RIGHT: addActiveElements(tableR, rectProfR); break;
        }

    }

    @Override
    public void repaint() {

    }
}
