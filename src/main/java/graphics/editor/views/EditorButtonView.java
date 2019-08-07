package graphics.editor.views;

import graphics.cards.views.PaneComponentView;
import graphics.editor.controllers.EditorButtonController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class EditorButtonView extends PaneComponentView {

    Rectangle r;
    int h;
//    Circle r;
    Image im;
    ImageView imv;

    public EditorButtonView(EditorButtonController controller) {
        super(controller);
        if (controller().S() < 150) h = 50; else h = 100;
        r = new Rectangle(2, 2, controller().S(), h);
        r.setArcHeight(10);
        r.setArcWidth(10);
//        r = new Circle(controller.S()/2, 25, 25);
        r.setStrokeWidth(2);
        im = new Image(controller.getImageUrl(), controller().S(), h, false, false);
        imv = new ImageView(im);
        imv.relocate(2, 2);
    }

    @Override
    public void paint() {
        addActiveElement(r);
        getChildren().add(imv);
    }

    @Override
    public void repaint() {
        r.setWidth(controller().S());
        r.setStrokeWidth(2);

    }

    @Override
    public void setComponentProperties() {

    }

    @Override
    public void setViewProperties() {

    }
}
