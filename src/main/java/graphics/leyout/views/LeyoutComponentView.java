package graphics.leyout.views;


import javafx.scene.layout.Region;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import graphics.cards.Infoable;
import graphics.leyout.controllers.LeyoutComponentController;

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
        disactivate();
        texts = new ArrayList<>();
        bounderys = new ArrayList<>();
        activeElements = new ArrayList<>();
        pasiveElements = new ArrayList<>();
    }

    /**General - общие методы для композит и Leaf*/

//    public void setController(LeyoutComponentController controller){
//        this.controller = controller;
//    }

    public LeyoutComponentController controller() {
        return controller;
    }

    public void activate(){
        onActive = true;
        for (Shape s : activeElements) {
            s.setId("active");
        }
        for (Text t: texts){
            t.setId("blanktxt");
            t.setText(controller.getText());
        }
    }

    public void disactivate(){
        onActive = false;
    }

    public void entered(){
        for (Shape s : activeElements) {
            s.setId("select");
        }
        for (Shape t: texts){
            t.setId("seltxt");
        }
        for (Shape b: bounderys) {
            b.setId("selbound");
        }
    }

    public void exited() {
        if (onActive == false) {
            for (Shape s : activeElements) {
                s.setId("blank");
            }
            for (Text t : texts) {
                t.setId("blanktxt");
            }
            for (Shape b : bounderys) {
                b.setId("blankbound");
            }
        } else {
            for (Shape s : activeElements) {
                s.setId("active");
            }
            for (Text t : texts) {
                t.setId("blanktxt");
            }
            for (Shape b : bounderys) {
                b.setId("blankbound");
            }
        }
    }

    /** Elements */

    public void addText(Text text) {
        text.setId("blanktxt");
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
            element.setId("blank");
        } else {
            element.setId("active");
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

    public void updateView(){
        this.relocate(controller.X(), controller.Y());
        this.setRotate(controller.A());
        repaint();
    }

    public abstract void paint();        //Рисование у Leaf. Добавление и расположение элементов у Composit

    public abstract void repaint();

}
