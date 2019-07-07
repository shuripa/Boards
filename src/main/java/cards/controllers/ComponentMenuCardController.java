package cards.controllers;

import cards.views.ComponentMenuCard;
import graphics.components.CompositBoard;
import graphics.components.LeyoutComponent;
import graphics.controllers.LeyoutComponentController;
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
        });
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
