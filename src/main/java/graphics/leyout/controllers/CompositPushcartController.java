package graphics.leyout.controllers;

import graphics.leyout.components.CompositPushcart;
import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.components.WorkPlacedComposit;
import graphics.leyout.views.CompositPushcartView;
import inout.CompositBuilder;

import java.io.IOException;

public class CompositPushcartController extends LeyoutWorkPlacedController {

    PushcartController pushcartController;
    WorkPlaceController workPlaceController;

    public CompositPushcartController(CompositPushcart component) throws IOException {
        super(component);
        leafs(component);
        setView(new CompositPushcartView(this));
    }

    public CompositPushcartController(LeyoutComponent component, CompositBuilder builder) throws IOException{
        super((WorkPlacedComposit) component);
        leafs((CompositPushcart) component);
        setView(new CompositPushcartView(this));
        setXYAS(builder.getX(), builder.getY(), builder.getA(), builder.getS());
    }

    private void leafs(CompositPushcart component) throws IOException{
        pushcartController = new PushcartController(component.getPushcart());
        workPlaceController = new WorkPlaceController(component.getWorkPlace());
        setLeaves(pushcartController, workPlaceController);
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
