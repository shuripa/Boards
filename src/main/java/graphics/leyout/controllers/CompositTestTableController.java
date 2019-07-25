package graphics.leyout.controllers;

import graphics.leyout.components.CompositTestTable;
import graphics.leyout.views.CompositTestView;
import javafx.scene.input.MouseButton;
import sets.SetComponentControllers;

import java.io.IOException;

public class CompositTestTableController extends LeyoutComponentController {
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
        setView(new CompositTestView(this));
        SetComponentControllers scc = SetComponentControllers.getInstance();
        scc.addComponentController(this);

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
    protected void setDragEvent() {

    }

    @Override
    protected void setEventTonExt(MouseButton button) {

    }

//    @Override
//    public void update() {
//        ttableController.update();
//        wplaceController.update();
//        paletteController.update();
//        wtableController.update();
//        canbanController.update();
//    }

    @Override
    public void select() {
        ttableController.select();
        wplaceController.select();
        paletteController.select();
        wtableController.select();
        canbanController.select();
    }

    @Override
    public void unselect() {
        ttableController.unselect();
        wplaceController.unselect();
        paletteController.unselect();
        wtableController.unselect();
        canbanController.unselect();
    }



}
