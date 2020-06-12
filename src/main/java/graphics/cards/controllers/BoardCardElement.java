package graphics.cards.controllers;

import graphics.Layout;
import graphics.leyout.components.CompositBoard;
import graphics.leyout.controllers.CompositBoardController;
import graphics.leyout.controllers.LeyoutComponentController;
import graphics.cards.views.BoardCardView;

import java.io.IOException;

import static graphics.Layout.getInstace;

@Deprecated
public class BoardCardElement extends PaneComponentElement {

    public BoardCardElement(String board){
        super();
        setView(new BoardCardView(this));
    }


    @Override
    protected LeyoutComponentController createLeyautComponent(double x, double y) throws IOException {
        Layout layout = getInstace();
        CompositBoard cb = new CompositBoard();
        CompositBoardController cbc = new CompositBoardController(cb);
        cbc.setXYAS((int)x, (int)y, 0, 60);
        layout.addComponentController(cbc);
        return cbc;
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
