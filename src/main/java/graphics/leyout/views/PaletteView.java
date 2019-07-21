package graphics.leyout.views;

import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import graphics.leyout.controllers.LeyoutComponentController;

public class PaletteView extends LeyoutComponentView {
    private String style;

    public PaletteView(LeyoutComponentController controller){
        super(controller);
//        this.style = "-fx-fill: RGBA(82,79,161,0.6)";
//        this.getStyleClass().add("style.css");
//        this.setId("style.css:");
        paint();
    }



    public void paint(){
        //Палета
        //rt1
        Rectangle rt1 = new Rectangle(30, 40);
        rt1.relocate(.5,.5);
        Line l1 = new Line (15.5, 0.5, 15.5, 40.5);
        Line l2 = new Line (0.5, 20.5, 30.5, 20.5);

        addActiveElements(rt1, l1, l2);
    }

    @Override
    public void repaint() {

    }


}
