package graphics.cards.controllers;

import graphics.cards.BoardMenu;
import graphics.cards.views.SkillMenuCard;
import graphics.leyout.controllers.LeyoutComponentController;
import model.Condition;
import model.Skill;
import sets.SetComponentControllers;

import java.io.IOException;

public class SkillMenuCardController extends PaneComponentController {


    public SkillMenuCardController(Skill skill){
        super(skill);
        setView(new SkillMenuCard(this));
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
            BoardMenu boardMenu = new BoardMenu(this);
            SetComponentControllers set = SetComponentControllers.getInstance();
            for (LeyoutComponentController cont: set.getComponentControllers()) {
                for (Condition condition: cont.getConditions()) {
                    if (condition.isSuited((Skill)component())){
                        boardMenu.addCard(new ComponentMenuCardController(cont.component(), component()));
                    }
                }
            }
            boardMenu.showBoard(120);
        });
    }

    public void boardSelect() throws IOException {

            SetComponentControllers set = SetComponentControllers.getInstance();
            for (LeyoutComponentController controller: set.getComponentControllers()) {
                for (Condition condition: controller.getConditions()) {
                    if (condition.isSuited((Skill)component())){
                        controller.select();
                    }
                }
            }

    }

    public void boardUnselect() {
        for (LeyoutComponentController componentController: SetComponentControllers.getInstance().getComponentControllers()) {
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
}
