package graphics.leyout.controllers;

import graphics.leyout.components.CompositPushcart;
import graphics.leyout.views.CompositPushcartView;
import javafx.scene.input.MouseButton;

import java.io.IOException;

public class CompositPushcartController extends LeyoutComponentController {

    PushcartController pushcartController;
    WorkPlaceController workPlaceController;

    public CompositPushcartController(CompositPushcart component) throws IOException {
        super(component);
        pushcartController = new PushcartController(((CompositPushcart)component()).getPushcart());
        workPlaceController = new WorkPlaceController(((CompositPushcart)component()).getWorkPlace());
        setView(new CompositPushcartView(this));
    }

    public PushcartController getPushcartController() {
        return pushcartController;
    }

    public WorkPlaceController getWorkPlaceController() {
        return workPlaceController;
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


    @Override
    public void updateViewData() {
        pushcartController.update();
        workPlaceController.update();
    }

    @Override
    public void select() {
        pushcartController.select();
        workPlaceController.select();
    }

    @Override
    public void unselect() {
        pushcartController.unselect();
        workPlaceController.unselect();
    }
}
