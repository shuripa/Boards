package graphics.cards.views;

import graphics.cards.controllers.PaneComponentController;
import graphics.leyout.components.CompositBoard;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class ComponentMenuCard extends PaneComponentView {
    Text tid, tdesc;

    public ComponentMenuCard(PaneComponentController controller) {
        super(controller);
    }

    @Override
    public void paint() {
        Rectangle r = new Rectangle(100, 15);
        tid = new Text("" + (((CompositBoard)component()).getBoard()).getId());
        tid.relocate(5, -2);
        tdesc = new Text(""+ ((CompositBoard)component()).getTitle());
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
