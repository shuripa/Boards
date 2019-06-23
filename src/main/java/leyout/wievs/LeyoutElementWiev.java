package leyout.wievs;


import leyout.controllers.LeyoutElementController;
import javafx.scene.Node;
import javafx.scene.layout.Region;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

import java.util.ArrayList;

public abstract class LeyoutElementWiev extends Region {

    private Boolean onActive;
    private ArrayList <Text> texts;        //Текстовые метки
    private ArrayList <Shape> activeElements;     //Активные елементы
    private ArrayList <Shape> bounderys;    //Елементы выделения границы
    private ArrayList <Shape> pasiveElements;     //Неактивные элементы
    private ArrayList <Node> nodes;         //Элементы управления
    protected LeyoutElementController controller;


    //TODO: Дублируется. Удалить после рефакторинга
    public LeyoutElementWiev(){
        disactivate();
        texts = new ArrayList<>();
        activeElements = new ArrayList<>();
        bounderys = new ArrayList<>();
        pasiveElements = new ArrayList<>();
        nodes = new ArrayList<>();
        this.getStylesheets().add("style.css");
        setsEvents();
        paint();
    }

    public LeyoutElementWiev(int size){
        disactivate();
        texts = new ArrayList<>();
        activeElements = new ArrayList<>();
        bounderys = new ArrayList<>();
        pasiveElements = new ArrayList<>();
        nodes = new ArrayList<>();
        this.getStylesheets().add("style.css");
        setsEvents();
        this.setSize(size);
        paint();
    }


    //Основной
    public LeyoutElementWiev(LeyoutElementController controller){
        this.controller = controller;

        disactivate();
        texts = new ArrayList<>();
        activeElements = new ArrayList<>();
        bounderys = new ArrayList<>();
        pasiveElements = new ArrayList<>();
        nodes = new ArrayList<>();
        this.getStylesheets().add("style.css");
        setsEvents();
        paint();
    }

    //Основной
    public LeyoutElementWiev(LeyoutElementController controller, int size){
        this.controller = controller;
        this.setSize(size);
        disactivate();
        texts = new ArrayList<>();
        activeElements = new ArrayList<>();
        bounderys = new ArrayList<>();
        pasiveElements = new ArrayList<>();
        nodes = new ArrayList<>();
        this.getStylesheets().add("style.css");
        setsEvents();
        paint();
    }

    public LeyoutElementController getController() {
        return controller;
    }

    private void setsEvents(){
        this.setOnMouseEntered(mouseEvent -> {
            entered();
        });

        this.setOnMouseExited(mouseEvent -> {
            exited();
        });

        this.setOnMouseClicked(mouseEvent -> {
//            ShapeInfo shapInfo = new ShapeInfo(new Text("so far nothing"), 60);
            new ShapeInfo(controller);
        });

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

    public Text getTexts(int i) {
        return texts.get(i);
    }

    public void addText(Text text) {
        text.setId("blanktxt");
        texts.add(text);
        this.getChildren().add(text);
    }

    public void remText(Text text) {
        this.getChildren().remove(text);
        texts.remove(text);
    }

    public void addTexts(Text ... texts){
        for (Text t: texts){
            addText(t);
        }
    }

    public Shape getActiveElement(int i) {
        return activeElements.get(i);
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

    public void addNode (Node node){
        this.nodes.add(node);
        this.getChildren().add(node);
    }

    public Shape getBounderys(int i) {
        return bounderys.get(i);
    }

    public void setBounderys(Shape boundery) {
        boundery.setId("blankbound");
        this.bounderys.add(boundery);
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

    protected void exited() {
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

    protected abstract void paint();

    public abstract void setSize(int size);

    public void setController(LeyoutElementController controller){
        this.controller = controller;
    };

    public abstract void reset();

}
