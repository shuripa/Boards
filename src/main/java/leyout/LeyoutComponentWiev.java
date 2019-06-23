package leyout;


import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Region;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import leyout.wievs.ShapeInfo;
import leyout.wievs.ShapeNode;

import java.util.ArrayList;

public abstract class LeyoutComponentWiev extends Region implements Infoable{

//    TODO: разделить методы относящиеся к Leaf и Composit и сделать для них реализацию по умолчанию
//    Предположительно методы paint() setSize() и reset() относятся только к Leaf
//    Методы getElements() и emplacement() относятся только к Composit

    private Boolean onActive;
    private ArrayList <Text> texts;        //Текстовые метки
    private ArrayList <Shape> activeElements;     //Активные елементы
    private ArrayList <Shape> bounderys;    //Елементы выделения границы
    private ArrayList <Shape> pasiveElements;     //Неактивные элементы
    private ArrayList <Node> nodes;         //Элементы управления
    // TODO: переместить класс в папку с контроллерами и сделать контроллер protected
    public LeyoutComponentController controller;

    int size;
    int x;
    int y;
    double a;
    public ShapeNode nEnt;                     //Точка старта (входа)
    public ShapeNode nExt;                     //Точка выхода


    //TODO: Дублируется. Удалить после рефакторинга
    public LeyoutComponentWiev(){
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

    public LeyoutComponentWiev(int size){
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
    public LeyoutComponentWiev(LeyoutComponentController controller){
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
    public LeyoutComponentWiev(LeyoutComponentController controller, int size){
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

    //Основной для паттерна Composit
    public LeyoutComponentWiev(LeyoutComponentController controller, int size, int x, int y, double a){
        this.controller = controller;
        this.setSize(size);
        this.x = x;
        this.y = y;
        this.a = a;
        disactivate();
        getElements();
        emplacement(size);
        createNodes();
        texts = new ArrayList<>();
        activeElements = new ArrayList<>();
        bounderys = new ArrayList<>();
        pasiveElements = new ArrayList<>();
        nodes = new ArrayList<>();
        this.getStylesheets().add("style.css");
        setsEvents();
        relocate();
        paint();
    }


    /**General - общие методы для композит и Leaf*/


    /**Composit - методы относящиеся только к Composit*/

    private void createNodes() {
        //node start
        nEnt = new ShapeNode(this);
        nEnt.relocate(0, 16);
        nEnt.setOnMouseClicked(mouseEvent -> {
            MouseButton button = mouseEvent.getButton();
                setEventTonExt(button);
        });

        //node end
        nExt = new ShapeNode(this);
        nExt.relocate(size - 5, 16);
        this.getChildren().addAll(nEnt, nExt);

    }

    protected abstract void setEventTonExt(MouseButton button);

    public void relocate(){                             //Перемещение группы
        this.relocate(x, y);
        this.setRotate(a);
    }

    protected abstract void getElements();              //Добавление элементов

    protected abstract void emplacement(int size);      //Расположение элементов

    /**Leaf - методы относящиеся только к Leaf*/
    public LeyoutComponentController getController() {
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

    public void setSize(int size){
        this.size = size;
    }

    public void setController(LeyoutComponentController controller){
        this.controller = controller;
    };

    public abstract void reset();

}
