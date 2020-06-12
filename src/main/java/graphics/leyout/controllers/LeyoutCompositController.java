package graphics.leyout.controllers;

import graphics.Layout;
import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.views.LeyoutComponentView;
import inout.CompositBuilder;
import sets.SetCompositControllers;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Класс для отделения особенностей композитных компонент лейаута от особенностей компонент вообще
 * Задачи:
 * Работа с листовыми элементами.
 * Вид регистрируется на лейауте.
 * Процедуры create, destroy.
 * Динамическое изменение количества листов.
 * Удаление вида из лейаута.
 */

public abstract class LeyoutCompositController extends LeyoutComponentController {

    private ArrayList<LeyoutComponentController> leaves;

    public LeyoutCompositController(LeyoutComponent component) throws IOException {
        super(component);
        leaves = new ArrayList<>();
        SetCompositControllers scc = SetCompositControllers.getInstance();
        scc.addComponentController(this);
    }

    public LeyoutCompositController(LeyoutComponent component, CompositBuilder builder) throws IOException {
        super(component, builder);
        leaves = new ArrayList<>();
        SetCompositControllers scc = SetCompositControllers.getInstance();
        scc.addComponentController(this);
    }

    @Override
    public void setView(LeyoutComponentView view) throws IOException {
        Layout layout = Layout.getInstace();
        if (!(layout.isContainsView(view))) {
            layout.addView(view);
        }
        super.setView(view);
    }

    public void delView(LeyoutComponentView view) {
        Layout layout = Layout.getInstace();
        if (layout.isContainsView(view)) {
            layout.delView(view());
        }
    }

    public void addLeaf(LeyoutComponentController leaf){
        leaf.setParent(this);
        leaves.add(leaf);
    }

    public LeyoutComponentController getLeaf (int ind){
        return leaves.get(ind);
    }

    public void setLeaves(LeyoutComponentController... leaves){
        for (LeyoutComponentController l : leaves) {
            l.setParent(this);
            this.leaves.add(l);
        }
    }

    @Override
    public void select(int i){
        //0 - Прозрачный белый, 1 серый цвет
            if (leaves.size() != 0) {
                for (LeyoutComponentController l : leaves) {
                    l.select(i);
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

    //Для простых композитов при обновлении достаточно изменить размеры.
    //Но для более сложных композитов(CanbanBoard, CompositConvier), при изменении ключевых свойств
    //(cntLeaves, cntCards, cntPos)изменяется количество объектов поэтому нужно пересоздание.
    //В таких комозитах метод create() должен быть переопределен.

    public void create() throws IOException {}

    public void destroy(){}

}
