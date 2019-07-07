package cards;


import cards.controllers.PaneComponentController;
import cards.views.PaneComponentView;
import javafx.geometry.Bounds;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Popup;

import java.util.ArrayList;

public class BoardMenu extends Popup {
    Shape msgBoard;
    Arc arc;
    Rectangle rect;
    ArrayList<PaneComponentView> cardsInfo;
    VBox vb;
    Bounds bounds;
    PaneComponentController controller;

    public BoardMenu(PaneComponentController controller){
        this.controller = controller;
        cardsInfo = new ArrayList<>();
        this.setAutoHide(true);
        this.setHideOnEscape(true);
        vb = new VBox();
        bounds = controller.view().localToScreen(controller.view().getBoundsInLocal());           //Границы текущего элемента
    }

    public void addCard(PaneComponentController card){
        cardsInfo.add(card.view());
    }

    public void showBoard(int width){
        vb.getChildren().addAll(cardsInfo);
        if (cardsInfo.size()>0)
        setRight(width);
    }

    private void setRight(int width){
        arc = new Arc(width + 13, 5, 20, 20, 160, 40);
        arc.setType(ArcType.ROUND);
        rect = new Rectangle( -5, -5, width, (cardsInfo.size()-1)*17 + 25);
        msgBoard = Shape.union(arc, rect);
        msgBoard.setStyle("-fx-fill: RGBA(47,79,79,0.7); -fx-stroke: SlateGray; -fx-stroke-width: 0.5");
        this.getContent().addAll(msgBoard, vb);
        super.show(controller.view(), bounds.getMinX()-width -5, bounds.getMinY() + 5);
    }

    public void setLeft(){

    }
}
