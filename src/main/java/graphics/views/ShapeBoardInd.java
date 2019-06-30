package graphics.views;

import javafx.geometry.Bounds;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.Order;

import java.util.ArrayList;

//TODO класс на удаление. Уже есть BoardIndexView
public class ShapeBoardInd extends Region {

    short proc;
    int realproc;

    private ArrayList<Order> orders;

    public ArrayList<Order> getOrd() {
        return orders;
    }
    public void setOrd(ArrayList<Order> ord) {
        this.orders = ord;
    }

    public ShapeBoardInd(int i){
        setProc(i);
        this.setOnMouseClicked(mouseEvent -> {
            ShapeInfo shinfo= new ShapeInfo(new Text(this.toString()), 40);
            Bounds bounds = this.localToScreen (this.getBoundsInLocal());           //Границы текущего элемента
            shinfo.show(this, bounds.getMaxX(), bounds.getMinY() -10);    //
        });
    }

    public void setProc(int i){
        realproc = i;
        if (i >=0 && i<100)
            proc =(short) i;
        else if (i < 0) proc = (short)0;
        else proc = (short)100;
        paint();
    }

    public void paint() {
        //r1
        Rectangle r1 = new Rectangle(5, 20 * proc / 100);
        r1.setStroke(javafx.scene.paint.Color.WHITE);
        if (realproc >= 100){
//            r1.setStyle("-fx-fill: Crimson");
            r1.setStyle("-fx-fill: LIME");
        } else{
            r1.setStyle("-fx-fill: SeaGreen");
        }
        r1.setStrokeWidth(0.5);
        r1.relocate(0.5,18.5);
        //r2
        Rectangle r2 = new Rectangle(5,20*(100-proc)/100);
        r2.setStroke(javafx.scene.paint.Color.WHITE);
        r2.setStyle("-fx-fill: RED");
//        r2.setStyle("-fx-fill: Gainsboro");
        r2.setStrokeWidth(0.5);
        r2.relocate(0.5,18.5 + 20*proc/100);

        this.getChildren().addAll(r1,r2);
    }

    @Override
    public String toString(){
        String res = "Список замовлень:";
        if (!(orders == null)) {
            for (Order o : orders) {
                res = res + "\n" + o;
            }
        }
        return res;
    }
}
