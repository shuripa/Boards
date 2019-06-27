package leyout.controllers;

import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import leyout.components.CompositBoard;
import leyout.components.LeyoutComponent;
import leyout.views.CompositBoardView;
import leyout.views.LeyoutComponentView;

public class CompositBoardController extends LeyoutComponentController {
    //Leaf
    HumanController hc;
    BoardController bc;
    BoardIndexController bic;
    GridController gc;

    public CompositBoardController(CompositBoard cBoard){
        super(cBoard);
        hc = new HumanController(cBoard.getHuman());
        bc = new BoardController(cBoard.getBoard());
        gc = new GridController(cBoard.getGrid());
        bic = new BoardIndexController(cBoard.getBoardIndex());

        setView(new CompositBoardView(this));
    }

    public LeyoutComponentView getHumanShape() {
        return hc.view();
    }

    public LeyoutComponentView getBoardShape() {
        return bc.view();
    }

    public LeyoutComponentView getBoardIndex(){
        return bic.view();
    }

    public LeyoutComponentView getGridShape() {
        return gc.view();
    }

    public LeyoutComponentController getGridController(){
        return gc;
    }

    public LeyoutComponentController getHumanController() {
        return hc;
    }

    public LeyoutComponentController getBoardController() { return bc; }

    public Node getView() {
        return view();
    }

    public Integer getID() {
        return bc.getId();
    }

    public String getTitle() {
        return bc.getTitle();
    }

    public String getCondition(){
        return ((BoardController)getBoardController()).getCondition();
    }

    public LeyoutComponent getCompositBoard() {
        return component();
    }

    @Override
    protected void setComponentProperties() {

    }

    @Override
    protected void setEventTonExt(MouseButton button) {

    }

    @Override
    public void updateData() {

    }
}