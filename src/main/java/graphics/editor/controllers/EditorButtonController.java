package graphics.editor.controllers;

import graphics.cards.controllers.PaneComponentController;
import graphics.editor.components.EditorButton;
import graphics.editor.views.EditorButtonView;
import graphics.leyout.controllers.LeyoutComponentController;

import java.io.IOException;

public class EditorButtonController extends PaneComponentController {

    //TODO Аналіз.
                                    //Тут тип даних це просто обмеження
    public EditorButtonController(EditorButton component, int s) throws IOException {
        super(component);
        setS(s);
        setView(new EditorButtonView(this));
    }

    public String getClassName() {
        return component().getClass().getName();
    }

    public String getImageUrl() {
        return ((EditorButton)component()).getImageUrl();
    }

    @Override
    protected LeyoutComponentController createLeyautComponent(double x, double y) throws IOException {
                            //Тут тип даних це визначення суперкласу
        return ((EditorButton)component()).createLeyoutComponent(x, y);
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
