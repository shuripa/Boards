package graphics.leftpanel.views;

import graphics.leftpanel.controllers.IndexButtonController;
import graphics.leyout.controllers.LeyoutComponentController;
import graphics.leyout.views.LeyoutComponentView;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class IndexButtonView extends LeyoutComponentView {

    Text text;
    Circle circle;

    public IndexButtonView(LeyoutComponentController controller) {
        super(controller);
        text = new Text();
    }

    @Override
    public void paint() {
        circle = new Circle(0, 0, 24);
        circle.setStyle("-fx-fill: RGBA(47,79,79,1.0); -fx-stroke: DarkGray; -fx-stroke-width: 0.7");
        text.setText("" + ((IndexButtonController)controller()).getIndex());
        text.setStyle("-fx-fill: LightGray; -fx-font-style: italic; -fx-font-size: 16; -fx-stroke: LightGray");
        addActiveElement(circle);
        addText(text);
    }

    @Override
    public void repaint() {
        circle.setRadius(controller().S());
        text.setText("" + ((IndexButtonController)controller()).getIndex());
        int size = (int) Math.ceil(3*controller().S()/6+5) ;
//        int size = 24;
        text.setStyle("-fx-fill: LightGray; -fx-font-size: "+ size +" ; -fx-stroke: LightGray");
        text.relocate(-controller().S()/2+2, -11 + controller().S()/4);
//        text.relocate(0, 0);
    }
}
