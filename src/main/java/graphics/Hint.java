package graphics;

import graphics.leyout.controllers.LeyoutComponentController;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Popup;


public class Hint extends Popup {

    LeyoutComponentController controller;
    Text t;
    Rectangle r;

    public Hint (LeyoutComponentController controller, String s){
        this.controller = controller;
        t = new Text(s);
        t.setStyle("-fx-background-color: yellow; -fx-opacity: 0.9;");
        String[] tokens = s.split("\n");
        int width = 15 + tokens.length*16;
        r = new Rectangle(-10, -20, 285, width);
        r.arcHeightProperty().setValue(5);
        r.arcWidthProperty().setValue(10);
        r.setStyle("-fx-fill: RGBA(147,179,179,1.0); -fx-stroke: SlateGray; -fx-stroke-width: 0.5; -fx-opacity : 0.8");
        setAutoHide(true);
        getContent().addAll(r, t);
    }

    public void showhint(){
        showhint(controller.X(), controller.Y());
    }


    public void showhint(double x, double y){
        if (t.getText() != "") {
                show(controller.view(), x +35 , y -10);
        }

    }

    public void setText(String s){
        t.setText(s);
    }


}
