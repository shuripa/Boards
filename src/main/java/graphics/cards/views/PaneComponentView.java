package graphics.cards.views;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import graphics.leyout.components.LeyoutComponent;
import graphics.cards.controllers.PaneComponentElement;

import java.util.ArrayList;

public abstract class PaneComponentView extends Group {

    private PaneComponentElement controller;
    private ArrayList <Shape> activeElements;       //Активные елементы
    private ArrayList <Shape> priorityElements;       //Активные елементы с приоритетами

    private ArrayList<Text> texts;                 //Текстовые метки
    private ArrayList<Node> nodes;                 //ImageView
    private Boolean onActive;

    public PaneComponentView(PaneComponentElement controller){
        this.controller = controller;
        disactivate();
        activeElements = new ArrayList<>();
        priorityElements = new ArrayList<>();
        texts = new ArrayList<>();
        nodes = new ArrayList<>();
        setComponentProperties();
//        components().addControllerObserver(this);
    }

    public void activate(){
        onActive = true;
        for (Shape s : activeElements) {
            s.setId("set1");
        }
        for (Shape t: texts){
            t.setId("txt0");
        }
    }

    public void disactivate(){
        onActive = false;
    }

    public PaneComponentElement controller() {
        return controller;
    }

    public void entered (){
        entered(1);
    }

    public void entered (int i){
        for (Shape s : activeElements) {
            s.setId("set" +i);
        }
        for (Shape t: texts){
            t.setId("txt1");
        }
    }

    public void exited (){
        if (onActive == false) {
            for (Shape s : activeElements) {
                s.setId("set0");
            }
            for (Text t : texts) {
                t.setId("txt0");
            }
        } else {
            for (Shape s : activeElements) {
                s.setId("set1");
            }
            for (Text t : texts) {
                t.setId("txt1");
            }
        }
    }

    /** Elements */

    public void addText(Text text) {
        text.setId("txt0");
        texts.add(text);
        this.getChildren().add(text);
    }

    public void addTexts(Text ... texts){
        for (Text t: texts){
            addText(t);
        }
    }

    public void addActiveElement(Shape element) {
        if (onActive == false) {
            element.setId("set0");
        } else {
            element.setId("set1");
        }
        this.activeElements.add(element);
        this.getChildren().add(element);
    }

    public void addActiveElements(Shape ... el){
        for (Shape e: el) {
            addActiveElement(e);
        }
    }

    public void addPriorityElement(int priority, Shape element) {
        if (onActive == false) {
            element.setId("set" + priority);
        } else {
            element.setId("set1");
        }
        this.priorityElements.add(element);
        this.getChildren().add(element);
    }

    public void addPriorityElements(int priority, Shape ... el){
        for (Shape e: el) {
            addPriorityElement(priority, e);
        }
    }


    public void addNode(Node element) {
        this.nodes.add(element);
        this.getChildren().add(element);
    }

    public void updateView(){
        this.relocate(controller.X(), controller.Y());
        this.setRotate(controller.A());
        repaint();
    }

    public abstract void paint(); //Рисование у Leaf. Добавление и расположение элементов у Composit

    public abstract void repaint();

    public abstract void setComponentProperties();

    protected LeyoutComponent component(){
        return controller.component();
    }

    public abstract void setViewProperties();
}
