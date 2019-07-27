package graphics.cards.views;

import graphics.cards.controllers.LoginCardController;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class LoginCardView extends PaneComponentView{

    Text tid, tdesc, tprod;
    int priority;

    public LoginCardView(LoginCardController controller) {
        super(controller);
//        this.fillPriority = fillPriority;
        tid = new Text("" + ((LoginCardController)controller()).getId());
        tdesc = new Text(""+ ((LoginCardController)controller()).getTitle());
        tprod = new Text(""+ ((LoginCardController)controller()).getProductivity());
//        tprod = new Text("-");
        priority = ((LoginCardController)controller()).getPriority();
    }

    @Override
    public void paint() {
        Rectangle r = new Rectangle(120, 15);
//        r.setId("select" + priority);
        tid.relocate(5, -2);
        tdesc.relocate(40, -2);
        tprod.relocate(100, -2);
//        addActiveElement(r);
        addPriorityElement(priority, r);
        addTexts(tid, tdesc, tprod);
    }

    @Override
    public void repaint() {
        tprod.setText(""+ ((LoginCardController)controller()).getProductivity());
    }

    @Override
    public void setComponentProperties() {

    }

    @Override
    public void setViewProperties() {

    }
}
