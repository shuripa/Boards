package graphics.leyout.controllers;

import graphics.leyout.components.CompositTestTable;
import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.controllers.component.WorkPlaceController;
import graphics.leyout.views.CompositTestView;
import inout.CompositBuilder;

import java.io.IOException;

public class CompositTestTableController extends LeyoutWorkPlacedController {
    TestTableController ttableController;
    WorkPlaceController wplaceController;
    PaletteController paletteController;
    TestWorkTableController wtableController;
    TestCanbanController canbanController;

    public CompositTestTableController(CompositTestTable component) throws IOException {
        super(component);
        leafs(component);
        setView(new CompositTestView(this));
//        SetCompositControllers scc = SetCompositControllers.getInstance();
//        scc.addComponentController(this);

    }

    public CompositTestTableController(LeyoutComponent component, CompositBuilder builder) throws IOException {
        super((CompositTestTable)component);
        leafs((CompositTestTable) component);
        setView(new CompositTestView(this));
        setXYAS(builder.getX(), builder.getY(), builder.getA(), builder.getS());
    }

    private void leafs(CompositTestTable component) throws IOException {
        ttableController = new TestTableController(component.getTestTable());
        wplaceController = new WorkPlaceController(component.getWorkPlace());
        paletteController = new PaletteController(component.getPalette());
        wtableController = new TestWorkTableController(component.getWorkTable());
        canbanController = new TestCanbanController(component.getTestCanban());
        setLeaves(ttableController, wplaceController, paletteController, wtableController, canbanController);
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
