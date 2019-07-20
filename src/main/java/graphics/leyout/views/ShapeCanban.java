package graphics.leyout.views;

import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import graphics.leyout.controllers.CompositBoardController;

//Канбан для рабочего места
public class ShapeCanban extends LeyoutComponentView {
//    private String style;

    public ShapeCanban(CompositBoardController controller){
        super(controller);
//        this.style = "-fx-fill: RGBA(82,79,161,0.6)";
        paint();
    }


    public void paint(){
        //Тестувальний канбан
        //rc1
        Rectangle rc1 = new Rectangle(30, 30);
        rc1.setId("blank");
//        rc1.setStroke(javafx.scene.paint.Color.WHITE);
//        rc1.setStyle(style);
        rc1.setStrokeWidth(0.5);
        rc1.relocate(.5,.5);

        //l1
        Line l1 = new Line (10, 7, 10, 30);
        l1.setId("blankbound");
//        l1.setStroke(Color.WHITE);
        l1.setStrokeWidth(0.5);
//        l1.setStyle(style);

        Line l2 = new Line (20, 7, 20, 30);
        l1.setId("blankbound");
//        l2.setStroke(Color.WHITE);
        l2.setStrokeWidth(0.5);
//        l2.setStyle(style);

        this.getChildren().addAll(rc1, l1, l2);

    }

    @Override
    public void repaint() {

    }

}
