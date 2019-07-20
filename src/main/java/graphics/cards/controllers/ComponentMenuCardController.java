package graphics.cards.controllers;

import graphics.cards.views.ComponentMenuCard;
import graphics.leyout.components.CompositBoard;
import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.controllers.LeyoutComponentController;
import model.Skill;

import java.io.IOException;

public class ComponentMenuCardController extends PaneComponentController{
    public ComponentMenuCardController(LeyoutComponent component, LeyoutComponent sender) {
        super(component, sender);
        setView(new ComponentMenuCard(this));
    }

    @Override
    public void viewEvents() {
        super.viewEvents();

        view().setOnMouseClicked(mouseEvent -> {
            ((CompositBoard)component()).setLogining(((Skill)sender()).getEmployer());
            ((CompositBoard)component()).getBoardIndex().updateData();
        });

        view().setOnMouseEntered(mouseEvent -> {
            view().entered();
            boardSelect();
        });
    }

    private void boardSelect() {
        for (LeyoutComponentController lcc: component().getObservers()) {
            lcc.select();
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
}
