package graphics.leftpanel.views;

import graphics.leyout.controllers.LeyoutComponentController;
import graphics.leyout.views.LeyoutComponentView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class BindControlButtonView extends LeyoutComponentView {
    Rectangle r;
    Text t;
    String s;


    public BindControlButtonView(LeyoutComponentController controller) {
        super(controller);
    }

    @Override
    public void paint() {
        r = new Rectangle(0, 0, 10, 10);
        t = new Text("-");
        t.relocate(3, -5);
        addActiveElement(r);
        addTexts(t);
    }

    @Override
    public void repaint() {
        if (controller().component().isActive()) s = "-"; else s= "+";
        t.setText(s);
    }
}
