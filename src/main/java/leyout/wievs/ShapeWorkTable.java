package leyout.wievs;


import javafx.scene.input.MouseButton;
import javafx.scene.shape.Rectangle;
import leyout.LeyoutComponentWiev;

public class ShapeWorkTable extends LeyoutComponentWiev {
//    private String style;

    public ShapeWorkTable(){
        super();
//        this.style = "-fx-fill: RGBA(82,79,161,0.6)";
        paint();
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

    protected void paint() {
        //rc1
        Rectangle wt = new Rectangle(15, 20);
//        wt.setStroke(javafx.scene.paint.Color.WHITE);
//        wt.setStyle(style);
        wt.setStrokeWidth(0.5);
        wt.relocate(.5,.5);
        wt.setId("blank");

        this.getChildren().addAll(wt);
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
