package graphics.leyout.controllers;

import graphics.leyout.components.CompositPushcart;
import graphics.leyout.views.CompositPushcartView;

import java.io.IOException;

public class CompositPushcartController extends LeyoutWorkPlacedController {

    PushcartController pushcartController;
    WorkPlaceController workPlaceController;

    public CompositPushcartController(CompositPushcart component) throws IOException {
        super(component);
        pushcartController = new PushcartController(component.getPushcart());
        workPlaceController = new WorkPlaceController(component.getWorkPlace());
        setLeaves(pushcartController, workPlaceController);
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

}
