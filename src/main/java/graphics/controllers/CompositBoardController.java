package graphics.controllers;

import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import graphics.components.CompositBoard;
import graphics.components.LeyoutComponent;
import graphics.views.CompositBoardView;
import graphics.views.LeyoutComponentView;

import java.util.ArrayList;

public class CompositBoardController extends LeyoutComponentController {
    //Leaf
    HumanController hc;
    BoardController bc;
    BoardIndexController ic;
    GridController gc;

    public CompositBoardController(CompositBoard cBoard) {
        super(cBoard);
        bc = new BoardController(cBoard.getBoard());
        hc = new HumanController(cBoard.getHuman());
        gc = new GridController(cBoard.getGrid());
        ic = new BoardIndexController(cBoard.getBoardIndex());

        setView(new CompositBoardView(this));
    }

    public LeyoutComponentView getHumanView() {
        return hc.view();
    }

    public LeyoutComponentView getBoardView() {
        return bc.view();
    }

    public LeyoutComponentView getBoardIndexView() {
        return ic.view();
    }

    public LeyoutComponentView getGridShapeView() {
        return gc.view();
    }

    public LeyoutComponentController getGridController() {
        return gc;
    }

    public LeyoutComponentController getHumanController() {
        return hc;
    }

    public LeyoutComponentController getBoardController() {
        return bc;
    }

    public LeyoutComponentController getBoardIndexController() {
        return ic;
    }

    public LeyoutComponent getLeaf(int ind) {
        return component().getLeaf(ind);
    }

    public ArrayList<LeyoutComponentView> getViews(int leafInd) {
        ArrayList<LeyoutComponentView> lcv = new ArrayList<>();
//        Слушатели компонента пока ограничиваются слушателеями лейаута. Если появятся другие слушатели, нужно будет
//        сделать общий интерфейс, заменить в LeyoutCompontnt клас массива observers и тут тип переменной lcc на тип
//        сoзданного общего интерфейса.
        for (LeyoutComponentController lcc : getLeaf(leafInd).getObservers()) {
            if (lcc.getClass().getName().equals(LeyoutComponentController.class.getName())) {
                lcv.add(lcc.view());
            }
        }
        return lcv;
    }

    public Node getView() {
        return view();
    }

    public Integer getID() {
        return bc.getId();
    }

    public String getTitle() {
        return bc.getTitle();
    }

    public String getCondition() {
        return ((BoardController) getBoardController()).getCondition();
    }

    public LeyoutComponent getCompositBoard() {
        return component();
    }

    @Override
    protected void setComponentProperties() {

//        for (IntegerProperty prop: bc.getIntProperties()) { setIntProperty(prop); }
//        for (StringProperty prop: bc.getStrProperties()) { setStrProperty(prop); }
//        for (IntegerProperty prop: hc.getIntProperties()) { setIntProperty(prop); }
//        for (StringProperty prop: hc.getStrProperties()) { setStrProperty(prop); }
//        for (IntegerProperty prop: gc.getIntProperties()) { setIntProperty(prop); }
//        for (StringProperty prop: gc.getStrProperties()) { setStrProperty(prop); }
//        for (IntegerProperty prop: ic.getIntProperties()) { setIntProperty(prop); }
//        for (StringProperty prop: ic.getStrProperties()) { setStrProperty(prop); }

        setIntProperty((((CompositBoard)component()).getBoard()).idProperty());
        setStrProperty((((CompositBoard)component()).getBoard()).titleProperty());
        setStrProperty((((CompositBoard)component()).getBoard()).conditionProperty());
        setIntProperty((((CompositBoard)component()).getHuman()).idProperty());
        setStrProperty((((CompositBoard)component()).getHuman()).nameProperty());
        setStrProperty((((CompositBoard)component()).getHuman()).phoneProperty());
        setIntProperty((((CompositBoard)component()).getBoardIndex()).procProperty());
    }

    @Override
    protected void setEventTonExt(MouseButton button) {

    }

    @Override
    public void updateData() {
        bc.update();
        hc.update();
        ic.update();
        gc.update();
    }

}