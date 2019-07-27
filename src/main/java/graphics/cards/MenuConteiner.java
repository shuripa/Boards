package graphics.cards;

import graphics.cards.controllers.PaneComponentController;
import graphics.cards.views.PaneComponentView;
import javafx.geometry.Bounds;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Popup;
import java.util.ArrayList;

/**
 * Основа для контексного меню.
 * Popup компонент, содержащий VBox
 */

public class MenuConteiner extends Popup {
    Shape msgBoard;
    Arc arc;
    Rectangle rect;

    public void setCards(ArrayList<PaneComponentView> cards) {
        this.cards = cards;
    }

    ArrayList<PaneComponentView> cards;
    VBox vb;
    Bounds bounds;
    PaneComponentController controller;

    public MenuConteiner(PaneComponentController controller){
        this.controller = controller;
        cards = new ArrayList<>();
        this.setAutoHide(true);
        this.setHideOnEscape(true);
        vb = new VBox();
        bounds = controller.view().localToScreen(controller.view().getBoundsInLocal());           //Границы текущего элемента
    }

    public void addCard(PaneComponentController card){
        cards.add(card.view());
    }

    public void showConteiner(int width){
        vb.getChildren().addAll(cards);
        if (cards.size()>0)
        setRight(width);
    }

    private void setRight(int width){
        arc = new Arc(width + 13, 5, 20, 20, 160, 40);
        arc.setType(ArcType.ROUND);
        rect = new Rectangle( -5, -5, width, (cards.size()-1)*17 + 25);
        msgBoard = Shape.union(arc, rect);
        msgBoard.setStyle("-fx-fill: RGBA(47,79,79,0.7); -fx-stroke: SlateGray; -fx-stroke-width: 0.5");
        this.getContent().addAll(msgBoard, vb);
        super.show(controller.view(), bounds.getMinX()-width -5, bounds.getMinY() + 5);
    }

    public void setLeft(){

    }
}
