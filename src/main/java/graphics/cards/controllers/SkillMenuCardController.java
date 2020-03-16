package graphics.cards.controllers;

import graphics.cards.MenuConteiner;
import graphics.cards.views.SkillMenuCardView;
import graphics.leyout.controllers.LeyoutComponentController;
import model.Condition;
import model.Skill;
import sets.SetCompositControllers;

import java.io.IOException;

public class SkillMenuCardController extends PaneComponentController {

    public SkillMenuCardController(Skill skill){
        super(skill);
        setView(new SkillMenuCardView(this));
    }

    @Override
    public void viewEvents() {
        super.viewEvents();

        view().setOnMouseEntered(mouseEvent -> {
            view().entered();
            try {
                boardSelect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        view().setOnMouseExited(mouseEvent -> {
            view().exited();
            boardUnselect();
        });

        view().setOnMouseClicked(mouseEvent -> {
            MenuConteiner boardMenu = new MenuConteiner(this);
            SetCompositControllers set = SetCompositControllers.getInstance();
            for (LeyoutComponentController cont: set.getComponentControllers()) {
                for (Condition condition: cont.getConditions()) {
                    if (condition.Like((Skill)component())){
                        boardMenu.addCard(new CompositMenuCardController(cont.component(), component()));
                    }
                }
            }
            boardMenu.showConteiner(120);
        });
    }

    public void boardSelect() throws IOException {

            SetCompositControllers set = SetCompositControllers.getInstance();
            for (LeyoutComponentController controller: set.getComponentControllers()) {
                for (Condition condition: controller.getConditions()) {
                    if (condition.Like((Skill)component())){
                        controller.select();
                    }
                }
            }

    }

    public void boardUnselect() {
        for (LeyoutComponentController componentController: SetCompositControllers.getInstance().getComponentControllers()) {
            componentController.unselect();
        }
    }

    @Override
    protected LeyoutComponentController createLeyoutComponent(double x, double y) throws IOException {
        return null;
    }

    @Override
    public void updateData() {

    }

    @Override
    public String getText() {
        return null;
    }

    public Double getSkillProd(){
        return ((Skill)component()).getProductivity();
    }

    @Override
    public void select() {

    }
}
