package graphics.leyout.views;


import graphics.cards.Infoable;
import graphics.leyout.controllers.LeyoutComponentController;
import javafx.scene.layout.Region;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

import java.util.ArrayList;

public abstract class LeyoutComponentView extends Region implements Infoable{

    private LeyoutComponentController controller;
    private ArrayList <Text> texts;                 //Текстовые метки
    private ArrayList <Shape> activeElements;       //Активные елементы
    private ArrayList <Shape> bounderys;            //Элементы выделения границы
    private ArrayList <Shape> pasiveElements;       //Неактивные элементы

    private Boolean onActive;

    public LeyoutComponentView(LeyoutComponentController controller){
        this.controller = controller;
        texts = new ArrayList<>();
        bounderys = new ArrayList<>();
        activeElements = new ArrayList<>();
        pasiveElements = new ArrayList<>();
        disactivate();
    }

    /**General - общие методы для композит и Leaf*/

//    public void setController(LeyoutComponentController controller){
//        this.controller = controller;
//    }

    public LeyoutComponentController controller() {
        return controller;
    }


    public Boolean isActivate() {
        return onActive;
    }


    public void formatShape(int i){
        for (Shape s : activeElements) {
            s.setId("set" + i);
        }
    }

    public void formatText(int i){
        for (Text t: texts){
            t.setId("txt" + i);
        }
    }


    public void activate(){
        activate(1);
    }

    public void activate(int i) {
        onActive = true;
        formatShape(i);
        formatText (1);
    }

    public void disactivate(){
        onActive = false;
        exited(0);
    }

    public void entered(int i){
        formatShape(i);
        formatText(1);
    }

    public void exited(){
        exited(1);
    }

    public void exited(int i) {
        if (onActive == false) {
            formatShape(0);
        } else {
            formatShape(i);
        }
        formatText(0);
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

    public void addPassiveElement(Shape graph){
        graph.setId("blankgraphics");
        this.getChildren().add(graph);
    }

    public void addPassiveElements(Shape ... graphs){
        for (Shape g: graphs) {
            addPassiveElement(g);
        }
    }

    /** Sizes */

    public void update(){
        this.relocate(controller.X(), controller.Y());
        this.setRotate(controller.A());
        repaint();
    }


    public abstract void paint();        //Рисование у Leaf. Добавление и расположение элементов у Composit

    public abstract void repaint();

}
