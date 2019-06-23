package leyout.wievs;


import javafx.scene.input.MouseButton;
import javafx.scene.shape.Circle;
import leyout.Infoable;
import leyout.LeyoutComponentWiev;
import leyout.Point;

import java.util.ArrayList;


public class ShapeNode extends LeyoutComponentWiev {

    Infoable owner;

    Point p;
    ArrayList<ShapeNode> arNodes;
    public Infoable getOwner() {
        return owner;
    }

    public Point getP() {
        return p;
    }

    public ArrayList<ShapeNode> getArNodes() {
        return arNodes;
    }

    public ShapeNode(Infoable owner){
        super();
        this.owner = owner;
        arNodes = new ArrayList<>();
        setClicked();
//        paint();
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
        Circle point = new Circle(3, 3, 3);
        point.setId("blank");
        addActiveElement(point);
//        getChildren().add(point);
    }

    @Override
    public void setSize(int size) {

    }

    @Override
    public void reset() {

    }

    public void setClicked(){
//        this.setOnMouseClicked(mouseEvent -> {
//            Bounds bounds = this.localToScreen (this.getBoundsInLocal());
//            Bounds bounds1 = this.localToScene(this.getBoundsInParent());
//            Bounds bounds2 = this.localToScene(this.getLayoutBounds());
//
//            p = new Point(bounds2.getCenterX(), bounds2.getCenterY());
//            Границы текущего элемента
//            Text text = new Text("LocalCentr – X: " + bounds.getCenterX() + "; Y: " + bounds.getCenterY() + "\n" +
//                    "Parent – X: " + bounds1.getCenterX() + "; Y: " + bounds1.getCenterY() + "\n" +
//                    "Leyout – X: " + bounds2.getCenterX() + "; Y: " + bounds2.getCenterY() + "\n" +
//                    "LocalMax – X: " + bounds.getMaxX() + "; Y: " + bounds.getMinY() + "\n"
//            );
//            ShapeInfo info = new ShapeInfo(text);
//            info.show(this, bounds.getMaxX(), bounds.getMinY() -10);

//        });
    }

    public Point getPoint(){
        return p;
    }

    public void addNode (ShapeNode sNode){
        arNodes.add(sNode);
    }

    public double getX(){
//        Bounds b = this.getBoundsInLocal();
//        return localToScene(b).getCenterX();
//        return 100;
        return this.localToScene(this.getBoundsInLocal()).getMinX() + 3 ;
    }

    public double getY(){
//        return 100;
        return this.localToScene(this.getBoundsInLocal()).getMinY() + 3;
    }

    @Override
    public void showInfo() {

    }
}
