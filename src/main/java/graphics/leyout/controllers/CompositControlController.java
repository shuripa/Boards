package graphics.leyout.controllers;

import graphics.GraphicsElement;
import graphics.leyout.components.CompositControl;
import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.components.WorkPlacedComposit;
import graphics.leyout.controllers.component.ControlController;
import graphics.leyout.views.LeyoutComponentView;
import graphics.leyout.views.composition.CompositControlView;
import inout.CompositBuilder;
import javafx.scene.Node;
import model.Condition;
import model.Employee;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class CompositControlController extends LeyoutWorkPlacedController {
    //Leaf
//    RelocationController tc;
    ControlController cc;

    public CompositControlController(LeyoutComponent cTool, CompositBuilder builder) throws IOException {
        super((WorkPlacedComposit) cTool);
        leafs((CompositControl) cTool, builder);
        createView(builder.getCompositToolView());
        setXYAS(builder.getX(), builder.getY(), builder.getA(), builder.getS());
    }

    private void leafs(CompositControl cToll, CompositBuilder builder) throws IOException {
        cc = new ControlController(cToll.getTool(), this, builder.getToolViewType());
        setLeaves(cc);
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
                        setView((CompositControlView)constructor.newInstance(this));
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


    @Override
    protected void setComponentProperties() {
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

    public LeyoutComponentController getControlController() {
        return cc;
    }
}