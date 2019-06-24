package leyout.component;

import leyout.controllers.CompositBoardController;

public class CompositBoard extends LeyoutComponent {

    public CompositBoard(CompositBoardController controller) {
        super(controller);
    }

    @Override
    public String toString() {
        return "Composit Board";
    }
}
