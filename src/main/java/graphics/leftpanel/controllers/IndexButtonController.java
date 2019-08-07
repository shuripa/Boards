package graphics.leftpanel.controllers;

import graphics.Hint;
import graphics.leftpanel.components.IndexButton;
import graphics.leftpanel.views.IndexButtonView;
import graphics.leyout.controllers.LeyoutComponentController;
import sets.SetCompositControllers;

import java.io.IOException;

public class IndexButtonController extends LeyoutComponentController{

    Hint hint;

    public IndexButtonController(IndexButton component) throws IOException {
        super(component);
        setView(new IndexButtonView(this));

//        Text t = new Text(component.getHint());
//        hint = new Popup();
//        hint.setAutoHide(true);
//        hint.getContent().add(t);
        setHint(component.getHint());
//
//        hint = new Hint(this, component.getHint());

        SetCompositControllers setCompositControllers = SetCompositControllers.getInstance();
        setCompositControllers.addObserver(this);
    }


    public String getIndex() {
        return ((IndexButton)component()).getIndexAsText();
    }

    @Override
    protected void setComponentProperties() {

    }



    public void viewEvents() throws IOException {
        super.viewEvents();
//        view().setOnMouseEntered(mouseEvent -> {
//            select();
////            hint.show(view(), X()+35, Y()-10);
//            //TODO подсказку можна перенести в суперкласс
//            hint.showhint();
//        });
//        view().setOnMouseExited(mouseEvent -> {
//            unselect();
//            hint.hide();
//        });
        view().setOnMouseClicked(mouseEvent -> {
//            ArrayList<Employer> arrEmployers = SetEmployers.getInstance().getEmployers();
            ((IndexButton)component()).action();
        });
    }

}
