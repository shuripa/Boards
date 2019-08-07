package graphics;

import graphics.leyout.controllers.LeyoutComponentController;
import javafx.scene.text.Text;
import javafx.stage.Popup;


public class Hint extends Popup {
    LeyoutComponentController controller;
    Text t;

    public Hint (LeyoutComponentController controller, String s){
        this.controller = controller;
        t = new Text(s);
        setAutoHide(true);
        getContent().add(t);
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
