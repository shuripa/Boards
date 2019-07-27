package graphics.leyout.controllers;

import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.components.LeyoutComposit;
import model.Employer;
import sets.SetCompositControllers;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Класс для отделения особенностей композитных компонент лейаута от особенностей компонент вообще
 */

public abstract class LeyoutCompositController extends LeyoutComponentController{
    private ArrayList<LeyoutComponentController> leaves;

    public LeyoutCompositController(LeyoutComponent component) throws IOException {
        super(component);
        leaves = new ArrayList<>();
        SetCompositControllers scc = SetCompositControllers.getInstance();
        scc.addComponentController(this);
    }

    //Подсветить все рабочие места для рабочего
    public void selectWhithPriority(Employer empoloyer){
        select(getPriority(empoloyer));
    }

    public int getPriority(Employer employer) {
        return ((LeyoutComposit)component()).getPriorityToEmployer(employer);
    }

    public void addLeaf(LeyoutComponentController leaf){
        leaf.setParent(this);
        leaves.add(leaf);
    }

    public LeyoutComponentController getLeaf (int ind){
        return leaves.get(ind);
    }

    public void setLeaves(LeyoutComponentController ... leaves){
        for (LeyoutComponentController l : leaves) {
            l.setParent(this);
            this.leaves.add(l);
        }
    }

    @Override
    public void select(int i){
        if (i > 0){                     //0 - не выделять, 9 серый цвет
            if (leaves.size() != 0) {
                for (LeyoutComponentController l : leaves) {
                    l.select(i);
                }
            }
        }
    }

    @Override
    public void unselect() {
        if (leaves.size()!=0){
            for (LeyoutComponentController l : leaves) {
                l.unselect();
            }
        }
    }

    @Override
    public double getSumEffectivity() {
        return component().getWorkPlace().isLogined() ? 100 : 0;
    }


}
