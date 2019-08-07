package graphics.leyout.controllers;

import graphics.leyout.components.CompositTestTable;
import graphics.leyout.views.CompositTestView;

import java.io.IOException;

public class CompositTestTableController extends LeyoutWorkPlacedController{
    TestTableController ttableController;
    WorkPlaceController wplaceController;
    PaletteController paletteController;
    TestWorkTableController wtableController;
    TestCanbanController canbanController;

    public CompositTestTableController(CompositTestTable component) throws IOException {
        super(component);
        ttableController = new TestTableController(component.getTestTable());
        wplaceController = new WorkPlaceController(component.getWorkPlace());
        paletteController = new PaletteController(component.getPalette());
        wtableController = new TestWorkTableController(component.getWorkTable());
        canbanController = new TestCanbanController(component.getTestCanban());
        setLeaves(ttableController, wplaceController, paletteController, wtableController, canbanController);
        setView(new CompositTestView(this));
//        SetCompositControllers scc = SetCompositControllers.getInstance();
//        scc.addComponentController(this);

    }

    public TestTableController getTestTableController() {
        return ttableController;
    }

    public WorkPlaceController getWorkPlaceController() {
        return wplaceController;
    }

    public PaletteController getPaletteController() {
        return paletteController;
    }

    public TestWorkTableController getWorkTableController() {
        return wtableController;
    }

    public TestCanbanController getTestCanbanController() {
        return canbanController;
    }

    @Override
    protected void setComponentProperties() {

    }
    @Override
    public String toString() {
        return null;
    }


}
