package graphics.cards.views;

import graphics.cards.controllers.PaneComponentElement;
import graphics.cards.controllers.SkillMenuCardElement;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.Skill;

public class SkillMenuCardView extends PaneComponentView{

    Text tmod, tprod;

    public SkillMenuCardView(PaneComponentElement controller){
        super(controller);
    }

    @Override
    public void paint() {

        Rectangle r = new Rectangle(125, 15);
        tmod = new Text(((Skill)component()).getMaterialBlank());
        tmod.relocate(5, -2);
        tprod = new Text(""+ ((SkillMenuCardElement)controller()).getSkillProd());
        tprod.relocate(90, -2);
        addActiveElements(r);
        addTexts(tmod, tprod);
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
