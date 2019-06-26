package leyout.views;


import javafx.scene.shape.Rectangle;

public class ShapeWorkTable extends LeyoutComponentView {
//    private String style;

    public ShapeWorkTable(){
        super();
//        this.style = "-fx-fill: RGBA(82,79,161,0.6)";
        paint();
    }


    public void paint() {
        //rc1
        Rectangle wt = new Rectangle(15, 20);
//        wt.setStroke(javafx.scene.paint.Color.WHITE);
//        wt.setStyle(style);
        wt.setStrokeWidth(0.5);
        wt.relocate(.5,.5);
        wt.setId("blank");

        this.getChildren().addAll(wt);
    }


}
