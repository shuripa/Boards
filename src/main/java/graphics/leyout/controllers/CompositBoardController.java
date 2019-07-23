package graphics.leyout.controllers;

import graphics.leyout.components.CompositBoard;
import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.views.CompositBoardView;
import graphics.leyout.views.LeyoutComponentView;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import model.Condition;

import java.io.IOException;
import java.util.ArrayList;

public class CompositBoardController extends LeyoutComponentController {
    //Leaf
    WorkPlaceController hc;
    BoardController bc;
    BoardIndexController ic;
    GridController gc;

    public CompositBoardController() throws IOException {
        super();

        bc = new BoardController();
        hc = new WorkPlaceController();
        gc = new GridController();
        ic = new BoardIndexController();

        setView(new CompositBoardView(this));
    }

    public CompositBoardController(CompositBoard cBoard) throws IOException {
        super(cBoard);
        bc = new BoardController(cBoard.getBoard());
        hc = new WorkPlaceController(cBoard.getWorkPlace());
        gc = new GridController(cBoard.getGrid());
        ic = new BoardIndexController(cBoard.getBoardIndex());

        setView(new CompositBoardView(this));
    }

    public void SetComponent (CompositBoard cBoard) {
        super.setComponent(cBoard);
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
//        setIntProperty((((CompositBoard)component()).getWorkPlace()).idProperty());
//        setStrProperty((((CompositBoard)component()).getWorkPlace()).nameProperty());
//        setStrProperty((((CompositBoard)component()).getWorkPlace()).phoneProperty());
        setIntProperty((((CompositBoard)component()).getBoardIndex()).procProperty());
    }

    @Override
    protected void setEventTonExt(MouseButton button) {

    }

    @Override
    public ArrayList<Condition> getConditions() {
        return component().getConditions();
    }

    @Override
    public void updateViewData() {
        bc.update();
        hc.update();
        ic.update();
        gc.update();
    }

    @Override
    protected void setDragEvent() {

    }

    @Override
    public void select() {
        hc.select();
        bc.select();
        gc.select();
        ic.select();
    }

    @Override
    public void unselect(){
        hc.unselect();
        bc.unselect();
        gc.unselect();
        ic.unselect();
    }
}