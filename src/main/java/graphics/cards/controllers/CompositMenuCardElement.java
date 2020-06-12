package graphics.cards.controllers;

import graphics.GraphicsElement;
import graphics.cards.views.ComponentMenuCardView;
import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.components.WorkPlacedComposit;
import graphics.leyout.controllers.LeyoutComponentController;
import model.Skill;
import sets.SetCompositControllers;

import java.io.IOException;

public class CompositMenuCardElement extends PaneComponentElement {

    public CompositMenuCardElement(LeyoutComponent component, LeyoutComponent sender) {
        super(component, sender);
        setView(new ComponentMenuCardView(this));
    }

    @Override
    public void viewEvents() {
        super.viewEvents();

        view().setOnMouseClicked(mouseEvent -> {
            //Employee потрібно передати як параметр.
            ((WorkPlacedComposit)component()).logining(((Skill)sender()).getEmployee());
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
        for (GraphicsElement lcc: component().getObservers()) {
            lcc.select();
        }
    }

    public void boardUnselect() {
        for (LeyoutComponentController componentController: SetCompositControllers.getInstance().getComponentControllers()) {
            componentController.unselect();
        }
    }

    @Override
    protected LeyoutComponentController createLeyautComponent(double x, double y) throws IOException {
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
