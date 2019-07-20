package graphics.cards.views;

import graphics.cards.controllers.PaneComponentController;
import graphics.cards.controllers.SkillMenuCardController;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.Skill;

public class SkillMenuCard extends PaneComponentView{

    Text tmod, tprod;

    public SkillMenuCard(PaneComponentController controller){
        super(controller);
    }

    @Override
    public void paint() {

        Rectangle r = new Rectangle(125, 15);
        tmod = new Text(((Skill)component()).getMaterialBlank());
        tmod.relocate(5, -2);
        tprod = new Text(""+ ((SkillMenuCardController)controller()).getSkillProd());
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
