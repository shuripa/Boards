package graphics.cards.controllers;

import graphics.GraphicsController;
import graphics.cards.views.ComponentMenuCardView;
import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.controllers.LeyoutComponentController;
import model.Skill;
import sets.SetCompositControllers;

import java.io.IOException;

public class CompositMenuCardController extends PaneComponentController{

    public CompositMenuCardController(LeyoutComponent component, LeyoutComponent sender) {
        super(component, sender);
        setView(new ComponentMenuCardView(this));
    }

    @Override
    public void viewEvents() {
        super.viewEvents();

        view().setOnMouseClicked(mouseEvent -> {
            component().logining(((Skill)sender()).getEmployer());
        });

        view().setOnMouseExited(mouseEvent -> {
            view().exited();
//            boardUnselect();      Не ясно чи потрібно
        });

        view().setOnMouseEntered(mouseEvent -> {
            view().entered();
            boardSelect();
        });
    }

    private void boardSelect() {
        for (GraphicsController lcc: component().getObservers()) {
            lcc.select();
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



    @Override
    public void select() {

    }
}