package leyout.views;

import javafx.scene.input.MouseButton;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class ShapePalete extends LeyoutComponentView {
    private String style;

    public ShapePalete(){
        super();
//        this.style = "-fx-fill: RGBA(82,79,161,0.6)";
//        this.getStyleClass().add("style.css");
//        this.setId("style.css:");
        paint();
    }

    @Override
    protected void setEventTonExt(MouseButton button) {

    }

    public void paint(){
        //Палета
        //rt1
        Rectangle rt1 = new Rectangle(30, 40);
//        rt1.setStroke(javafx.scene.paint.Color.WHITE);
//        rt1.setStyle(style);
        rt1.setStrokeWidth(0.5);
        rt1.relocate(.5,.5);
        rt1.setId("blank");
        //l1
        Line l1 = new Line (15.5, 0.5, 15.5, 40.5);
//        l1.setStroke(Color.WHITE);
        l1.setStrokeWidth(0.5);
//        l1.setStyle(style);
        l1.setId("blankbound");

        Line l2 = new Line (0.5, 20.5, 30.5, 20.5);
//        l2.setStroke(Color.WHITE);
        l2.setStrokeWidth(0.5);
//        l2.setStyle(style);
        l2.setId("blankbound");

        this.getChildren().addAll(rt1, l1, l2);

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