package graphics.cards.views;

import graphics.cards.controllers.PaneComponentController;
import graphics.leyout.components.WorkPlacedComposit;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class ComponentMenuCardView extends PaneComponentView {
    Text tid, tdesc;

    public ComponentMenuCardView(PaneComponentController controller) {
        super(controller);
    }

    @Override
    public void paint() {
        Rectangle r = new Rectangle(100, 15);
        tid = new Text("" + ((WorkPlacedComposit)component()).getId());
        tid.relocate(5, -2);
        tdesc = new Text(""+ ((WorkPlacedComposit)component()).getTitle());
        tdesc.relocate(40, -2);
        addActiveElements(r);
        addTexts(tid, tdesc);
    }

    @Override
    public void repaint() {

    }

    @Override
    public void setComponentProperties() {

    }

    @Override
    public void setViewProperties() {

    }
}
