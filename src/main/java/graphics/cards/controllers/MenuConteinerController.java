package graphics.cards.controllers;

import graphics.cards.MenuConteiner;
import graphics.cards.views.PaneComponentView;
import graphics.leyout.controllers.LeyoutComponentController;

import java.io.IOException;
import java.util.ArrayList;

public class MenuConteinerController extends PaneComponentController {

    MenuConteiner menu;
    ArrayList<PaneComponentView> cards;

    public MenuConteinerController(PaneComponentController sender) {
        menu = new MenuConteiner(sender);
        cards = new ArrayList<>();
//        setView(new MenuConteinerView(this));
    }

    public void show(){
        menu.setCards(cards);
        menu.showConteiner(140);
    }

    public void addCard(PaneComponentController card){
        cards.add(card.view());
    }

    public ArrayList<PaneComponentView> cards() {
        return cards;
    }



    @Override
    protected LeyoutComponentController createLeyoutComponent(double x, double y) throws IOException {
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
