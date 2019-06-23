package leyout.wievs;

import leyout.controllers.LeyoutElementController;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;


public class ShapeGrid extends LeyoutElementWiev {

    private Integer size;
    private ArrayList<String> material;

    public ShapeGrid(Integer size)	{
        super(size);

//        this.setOnMouseClicked(mouseEvent -> {
//            Text t = new Text(controller.toString());
//            Integer i = Math.toIntExact((controller.toString().lines().count()) * 16 + 40);
//            ShapeInfo shinfo= new ShapeInfo(t, i);
//            Bounds bounds = this.localToScreen (this.getBoundsInLocal());           //Границы текущего элемента
//            shinfo.show(this, bounds.getMaxX(), bounds.getMinY() -10);    //
//        });

//        paint();
    }

    public ShapeGrid(LeyoutElementController controller, int size){
        super(controller, size);
    }

//    public ArrayList<String> getMaterials() {
//        return material;
//    }
//
//    public void setMaterials(ArrayList<String> material) {
//        this.material = material;
//    }

    @Override
    protected void paint(){
        Rectangle rb = new Rectangle(size,5);       //rectangle centr
        rb.relocate(.5,1.5);
        Rectangle rl = new Rectangle(5,7);      //rectangle left
        rl.relocate(5,.5);
        Rectangle rr = new Rectangle(5,7);      //rectangle right
        rr.relocate(size-10,.5);

        addActiveElements(rb, rl, rr);
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void reset() {

    }
}
