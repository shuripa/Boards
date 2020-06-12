package graphics.leyout.views.productStores;

import graphics.leyout.controllers.LeyoutComponentController;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

//Канбан для рабочего места
public class ToolProductStoreView extends ProductStoreView {
//    private String style;

    public ToolProductStoreView(LeyoutComponentController controller){
        super(controller);
//        this.style = "-fx-fill: RGBA(82,79,161,0.6)";
    }


    public void paint(){
        //Тестувальний канбан
        //rc1
        Rectangle rc1 = new Rectangle(18, 8);
//        rc1.setId("blank");
//        rc1.setStroke(javafx.scene.paint.Color.WHITE);
//        rc1.setStyle(style);
//        rc1.setStrokeWidth(0.5);
        rc1.relocate(.5,.5);

        //l1
        Line l1 = new Line (5, 0.5, 5, 6.5);
//        l1.setId("blankbound");
//        l1.setStroke(Color.WHITE);
//        l1.setStrokeWidth(0.5);
//        l1.setStyle(style);

        Line l2 = new Line (13, 0.5, 13, 6.5);
//        l1.setId("blankbound");
//        l2.setStroke(Color.WHITE);
//        l2.setStrokeWidth(0.5);
//        l2.setStyle(style);

        Line l3 = new Line (2, 1.5, 8, 1.5);
        Line l4 = new Line (2, 3.0, 8, 3.0);
        Line l5 = new Line (2, 4.5, 8, 4.5);
        Line l6 = new Line (2, 6.0, 8, 6.0);
        Line l7 = new Line (10, 1.5, 16, 1.5);
        Line l8 = new Line (10, 3.0, 16, 3.0);

        addActiveElements(rc1, l1, l2, l3, l4, l5, l6, l7, l8);
    }

    @Override
    public void repaint() {

    }

}
