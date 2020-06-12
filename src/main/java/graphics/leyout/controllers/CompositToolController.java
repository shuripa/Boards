package graphics.leyout.controllers;

import graphics.GraphicsElement;
import graphics.leyout.components.CompositBoard;
import graphics.leyout.components.CompositTool;
import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.components.WorkPlacedComposit;
import graphics.leyout.controllers.component.MaterialStoreController;
import graphics.leyout.controllers.component.ProductStoreController;
import graphics.leyout.controllers.component.ToolController;
import graphics.leyout.controllers.component.ToolWorkPlaceController;
import graphics.leyout.views.LeyoutComponentView;
import graphics.leyout.views.composition.CompositToolView;
import inout.CompositBuilder;
import javafx.scene.Node;
import model.Condition;
import model.Employee;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class CompositToolController extends LeyoutWorkPlacedController {
    //Leaf
    ToolController tc;
    ToolWorkPlaceController wc;
    MaterialStoreController msc;
    ProductStoreController psc;
    InstructionsController insc;
    //    BoardIndexController ic;
    //    EffectivityIndexController ie;

    public CompositToolController(LeyoutComponent cTool, CompositBuilder builder) throws IOException {
        super((WorkPlacedComposit) cTool);
        leafs((CompositTool) cTool, builder);
        createView(builder.getCompositToolView());
        setXYAS(builder.getX(), builder.getY(), builder.getA(), builder.getS());
    }

    private void leafs(CompositTool cToll, CompositBuilder builder) throws IOException {
        tc = new ToolController(cToll.getTool(), this, builder.getToolViewType());
        wc = new ToolWorkPlaceController(cToll.getWorkPlace(), this, builder.getToolWorkPlaceType());
        msc = new MaterialStoreController(cToll.getMaterialStore(), builder.getMaterialStoreViewType());
        psc = new ProductStoreController(cToll.getProductStore(), builder.getProductStoreView());
        insc = new InstructionsController(cToll.getInstructions());
//        TODO: доавить индексы
//        ic = new BoardIndexController(cBoard.getBoardIndex());
//        ie = new EffectivityIndexController(cBoard.getEffectivityIndex());
        setLeaves(tc, msc, wc, psc, insc);
    }

    private void createView(String viewType){
        Class<?> view;
        Constructor<?> constructor;
        String className = "graphics.leyout.views.composition."+ viewType;
        try {
            view = Class.forName(className);
            try {
                constructor = view.getConstructor(LeyoutWorkPlacedController.class);
                try {
                    try {
                        setView((CompositToolView)constructor.newInstance(this));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void SetComponent (CompositBoard cTool) {
        super.setComponent(cTool);
    }

    public LeyoutComponentController getMaterialPlaceController() {
        return msc;
    }

    public LeyoutComponentController getWorkPlaceController() {
        return wc;
    }

    public LeyoutComponentController getToolController() {
        return tc;
    }



//    public LeyoutComponentController getBoardIndexController() {
//        return ic;

//    }
//    public LeyoutComponentController getEffectivityIndexController(){
//        return ie.controller();

//    }

    public LeyoutComponent getComponentLeafs(int ind) {
        return component().getLeaf(ind);
    }

    public ArrayList<LeyoutComponentView> getViews(int leafInd) {
        ArrayList<LeyoutComponentView> lcv = new ArrayList<>();
//        Слушатели компонента пока ограничиваются слушателеями лейаута. Если появятся другие слушатели, нужно будет
//        сделать общий интерфейс, заменить в LeyoutCompontnt клас массива observers и тут тип переменной lcc на тип
//        сoзданного общего интерфейса.
        for (GraphicsElement lcc : getComponentLeafs(leafInd).getObservers()) {
            if (lcc.getClass().getName().equals(GraphicsElement.class.getName())) {
                lcv.add(((LeyoutComponentController)lcc).view());
            }
        }
        return lcv;
    }

    public Node getView() {
        return view();
    }

    public String getId() {
        return tc.getId();
    }

    public String getTitle() {
        return tc.getTitle();
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

//        setStrProperty((((CompositTool)component()).getTool()).idProperty());
//        setStrProperty((((CompositTool)component()).getTool()).titleProperty());
//
//        setIntProperty((((CompositBoard)component()).getWorkPlace()).idProperty());
//        setStrProperty((((CompositBoard)component()).getWorkPlace()).nameProperty());
//        setStrProperty((((CompositBoard)component()).getWorkPlace()).phoneProperty());

//        setIntProperty((((CompositTool)component()).getBoardIndex()).procProperty());
    }

    @Override
    public ArrayList<Condition> getConditions() {
        return component().getConditions();
    }

    @Override
    public double getSumEffectivity() {
//        return ((CompositTool)component()).getEffectivityIndex().getTotalEffectivity();
        return .0;
    }

    @Override
    public void selectWhithPriority(Employee empoloyer) {
        select(((WorkPlacedComposit)component()).getPriorityToEmployer(empoloyer));
    }

    public ProductStoreController getProductionPlaceController() {
        return psc;
    }

    public LeyoutComponentController getInstructionsController() {
        return insc;
    }
}