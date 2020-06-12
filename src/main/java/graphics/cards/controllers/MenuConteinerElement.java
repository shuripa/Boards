package graphics.cards.controllers;

import graphics.cards.MenuConteiner;
import graphics.cards.views.PaneComponentView;
import graphics.leyout.controllers.LeyoutComponentController;

import java.io.IOException;
import java.util.ArrayList;

public class MenuConteinerElement extends PaneComponentElement {

    MenuConteiner menu;
    ArrayList<PaneComponentView> cards;

    public MenuConteinerElement(PaneComponentElement sender) {
        menu = new MenuConteiner(sender);
        cards = new ArrayList<>();
//        setView(new MenuConteinerView(this));
    }

    public void show(){
        menu.setCards(cards);
        menu.showConteiner(140);
    }

    public void addCard(PaneComponentElement card){
        cards.add(card.view());
    }

    public ArrayList<PaneComponentView> cards() {
        return cards;
    }



    @Override
    protected LeyoutComponentController createLeyautComponent(double x, double y) throws IOException {
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
