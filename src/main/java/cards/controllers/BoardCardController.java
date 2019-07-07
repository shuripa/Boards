package cards.controllers;

import graphics.Layout;
import graphics.components.CompositBoard;
import graphics.controllers.CompositBoardController;
import graphics.controllers.LeyoutComponentController;
import cards.views.BoardCardView;

import java.io.IOException;

import static graphics.Layout.getInstace;

public class BoardCardController extends PaneComponentController {

    public BoardCardController(String board){
        super();
        setView(new BoardCardView(this));
    }


    @Override
    protected LeyoutComponentController createLeyoutComponent(double x, double y) throws IOException {
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
}
