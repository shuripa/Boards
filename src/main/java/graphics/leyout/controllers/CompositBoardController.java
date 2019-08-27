package graphics.leyout.controllers;

import graphics.GraphicsController;
import graphics.leyout.components.CompositBoard;
import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.components.WorkPlacedComposit;
import graphics.leyout.views.CompositBoardView;
import graphics.leyout.views.LeyoutComponentView;
import inout.CompositBuilder;
import javafx.scene.Node;
import model.Condition;
import model.Employer;

import java.io.IOException;
import java.util.ArrayList;

public class CompositBoardController extends LeyoutWorkPlacedController {
    //Leaf
    WorkPlaceController wc;
    BoardController bc;
    BoardIndexController ic;
    GridController gc;

    public CompositBoardController(CompositBoard cBoard) throws IOException {
        super(cBoard);
        leafs(cBoard);
//        setWorkPlace(wc);
        setView(new CompositBoardView(this));
        //Набор контроллеров композитов
//        SetCompositControllers scc = SetCompositControllers.getInstance();
//        scc.addComponentController(this);

//        cBoard.getWorkPlace().addControllerObserver(ic);
    }

    public CompositBoardController(LeyoutComponent cBoard, CompositBuilder cBuilder) throws IOException {
        super((WorkPlacedComposit)cBoard);
        leafs((CompositBoard) cBoard);
        setView(new CompositBoardView(this));
        setXYAS(cBuilder.getX(), cBuilder.getY(), cBuilder.getA(), cBuilder.getS());
    }

    private void leafs(CompositBoard cBoard) throws IOException {
        bc = new BoardController(cBoard.getBoard(), this);
        wc = new WorkPlaceController(cBoard.getWorkPlace(), this);
        gc = new GridController(cBoard.getGrid());
        ic = new BoardIndexController(cBoard.getBoardIndex());
        setLeaves(bc, gc, wc, ic);
    }

    public void SetComponent (CompositBoard cBoard) {
        super.setComponent(cBoard);
    }

    public LeyoutComponentView getHumanView() {
        return wc.view();
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

    public LeyoutComponentController getWorkPlaceController() {
        return wc;
    }

    public LeyoutComponentController getBoardController() {
        return bc;
    }

    public LeyoutComponentController getBoardIndexController() {
        return ic;
    }

    public LeyoutComponent getComponentLeafs(int ind) {
        return component().getLeaf(ind);
    }

    public ArrayList<LeyoutComponentView> getViews(int leafInd) {
        ArrayList<LeyoutComponentView> lcv = new ArrayList<>();
//        Слушатели компонента пока ограничиваются слушателеями лейаута. Если появятся другие слушатели, нужно будет
//        сделать общий интерфейс, заменить в LeyoutCompontnt клас массива observers и тут тип переменной lcc на тип
//        сoзданного общего интерфейса.
        for (GraphicsController lcc : getComponentLeafs(leafInd).getObservers()) {
            if (lcc.getClass().getName().equals(GraphicsController.class.getName())) {
                lcv.add(((LeyoutComponentController)lcc).view());
            }
        }
        return lcv;
    }

    public Node getView() {
        return view();
    }

    public String getId() {
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
//        for (IntegerProperty prop: wc.getIntProperties()) { setIntProperty(prop); }
//        for (StringProperty prop: wc.getStrProperties()) { setStrProperty(prop); }
//        for (IntegerProperty prop: gc.getIntProperties()) { setIntProperty(prop); }
//        for (StringProperty prop: gc.getStrProperties()) { setStrProperty(prop); }
//        for (IntegerProperty prop: ic.getIntProperties()) { setIntProperty(prop); }
//        for (StringProperty prop: ic.getStrProperties()) { setStrProperty(prop); }

        setStrProperty((((CompositBoard)component()).getBoard()).idProperty());
        setStrProperty((((CompositBoard)component()).getBoard()).titleProperty());
        setStrProperty((((CompositBoard)component()).getBoard()).conditionProperty());
//        setIntProperty((((CompositBoard)component()).getWorkPlace()).idProperty());
//        setStrProperty((((CompositBoard)component()).getWorkPlace()).nameProperty());
//        setStrProperty((((CompositBoard)component()).getWorkPlace()).phoneProperty());
        setIntProperty((((CompositBoard)component()).getBoardIndex()).procProperty());
    }


    @Override
    public ArrayList<Condition> getConditions() {
        return component().getConditions();
    }


    @Override
    public double getSumEffectivity() {
        return ((CompositBoard)component()).getBoardIndex().getEffectivityShift();
    }

    @Override
    public void selectWhithPriority(Employer empoloyer) {
        select(((WorkPlacedComposit)component()).getPriorityToEmployer(empoloyer));
    }
}