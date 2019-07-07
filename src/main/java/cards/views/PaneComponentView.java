package cards.views;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import graphics.components.LeyoutComponent;
import cards.controllers.PaneComponentController;

import java.util.ArrayList;

public abstract class PaneComponentView extends Group {

    private PaneComponentController controller;
    private ArrayList <Shape> activeElements;       //Активные елементы
    private ArrayList<Text> texts;                 //Текстовые метки
    private ArrayList <Node> nodes;                 //ImageView
    private Boolean onActive;

    PaneComponentView(PaneComponentController controller){
        this.controller = controller;
        disactivate();
        activeElements = new ArrayList<>();
        texts = new ArrayList<>();
        nodes = new ArrayList<>();
        setComponentProperties();
//        components().addObserver(this);
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

    public PaneComponentController controller() {
        return controller;
    }

    public void entered (){
        for (Shape s : activeElements) {
            s.setId("select");
        }
        for (Shape t: texts){
            t.setId("seltxt");
        }
    }

    public void exited (){
        if (onActive == false) {
            for (Shape s : activeElements) {
                s.setId("blank");
            }
            for (Text t : texts) {
                t.setId("blanktxt");
            }
        } else {
            for (Shape s : activeElements) {
                s.setId("active");
            }
            for (Text t : texts) {
                t.setId("blanktxt");
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

    public void addNode(Node element) {
        this.nodes.add(element);
        this.getChildren().add(element);
    }

    public void updateView(){
        this.relocate(controller.getX(), controller.getY());
        this.setRotate(controller.getA());
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
