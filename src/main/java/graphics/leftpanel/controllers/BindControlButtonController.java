package graphics.leftpanel.controllers;

import graphics.leftpanel.views.BindControlButtonView;
import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.controllers.LeyoutComponentController;

import java.io.IOException;

public class BindControlButtonController extends LeyoutComponentController {

    public BindControlButtonController(LeyoutComponent component) throws IOException {
        super(component);
        setView(new BindControlButtonView(this));
    }

    public Boolean isActive(){
        return component().isActive();
    }

    @Override
    public void viewEvents() throws IOException {
        super.viewEvents();
        view().setOnMouseClicked(mouseEvent -> {
            component().setActive(!component().isActive());
            update();
        });
    }

    @Override
    protected void setComponentProperties() {

    }


}
