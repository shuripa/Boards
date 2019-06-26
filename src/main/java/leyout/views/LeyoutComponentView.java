package leyout.views;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Region;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import leyout.Infoable;
import leyout.controllers.LeyoutComponentController;
import panes.PropertyPane;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class LeyoutComponentView extends Region implements Infoable{

//    TODO: разделить методы относящиеся к Leaf и Composit и сделать для них реализацию по умолчанию
//    Предположительно методы paint() setSize() и reset() относятся только к Leaf
//    Методы getElements() и emplacement() относятся только к Composit

    private Boolean onActive;
    private ArrayList <Text> texts;        //Текстовые метки
    private ArrayList <Shape> activeElements;     //Активные елементы
    private ArrayList <Shape> bounderys;    //Елементы выделения границы
    private ArrayList <Shape> pasiveElements;     //Неактивные элементы
    private ArrayList <Node> nodes;         //Элементы управления

//    private ArrayList <IntegerProperty> intProperties;

    private final static String TITLE_PROP_X = "X";
    private final static String TITLE_PROP_Y = "Y";
    private final static String TITLE_PROP_A = "A";
    private final static String TITLE_PROP_S = "S";
    private final IntegerProperty X;
    private final IntegerProperty Y;
    private final IntegerProperty A;
    private final IntegerProperty S;
    // TODO: переместить класс в папку с контроллерами и сделать контроллер protected

    public LeyoutComponentController controller;
    public int size;
    int x;
    int y;
    double a;
    public ShapeNode nEnt;                     //Точка старта (входа)
    public ShapeNode nExt;                     //Точка выхода

    //TODO: Дублируется. Удалить после рефакторинга
    public LeyoutComponentView(){
        disactivate();
        texts = new ArrayList<>();
        activeElements = new ArrayList<>();
        bounderys = new ArrayList<>();
        pasiveElements = new ArrayList<>();
        nodes = new ArrayList<>();
//        intProperties = new ArrayList<>();
        this.getStylesheets().add("style.css");
        setsEvents();
        paint();
        X = new SimpleIntegerProperty(this, TITLE_PROP_X, 0);
        Y = new SimpleIntegerProperty(this, TITLE_PROP_Y, 0);
        A = new SimpleIntegerProperty(this, TITLE_PROP_A, 0);
        S = new SimpleIntegerProperty(this, TITLE_PROP_S, 0);
    }

    public LeyoutComponentView(int size){
        disactivate();
        texts = new ArrayList<>();
        activeElements = new ArrayList<>();
        bounderys = new ArrayList<>();
        pasiveElements = new ArrayList<>();
        nodes = new ArrayList<>();
//        intProperties = new ArrayList<>();
        this.getStylesheets().add("style.css");
        setsEvents();
        this.setSize(size);
        paint();
        X = new SimpleIntegerProperty(this, TITLE_PROP_X, 0);
        Y = new SimpleIntegerProperty(this, TITLE_PROP_Y, 0);
        A = new SimpleIntegerProperty(this, TITLE_PROP_A, 0);
        S = new SimpleIntegerProperty(this, TITLE_PROP_S, 0);
    }

    //Основной
    public LeyoutComponentView(LeyoutComponentController controller){
        this.controller = controller;

        disactivate();
        texts = new ArrayList<>();
        activeElements = new ArrayList<>();
        bounderys = new ArrayList<>();
        pasiveElements = new ArrayList<>();
        nodes = new ArrayList<>();
//        intProperties = new ArrayList<>();
        this.getStylesheets().add("style.css");
        setsEvents();
        paint();
        X = new SimpleIntegerProperty(this, TITLE_PROP_X, 0);
        Y = new SimpleIntegerProperty(this, TITLE_PROP_Y, 0);
        A = new SimpleIntegerProperty(this, TITLE_PROP_A, 0);
        S = new SimpleIntegerProperty(this, TITLE_PROP_S, 0);
    }


    //Основной
    public LeyoutComponentView(LeyoutComponentController controller, int size){
        this.controller = controller;
        this.setSize(size);
        disactivate();
        texts = new ArrayList<>();
        activeElements = new ArrayList<>();
        bounderys = new ArrayList<>();
        pasiveElements = new ArrayList<>();
        nodes = new ArrayList<>();
//        intProperties = new ArrayList<>();
        this.getStylesheets().add("style.css");
        setsEvents();
        paint();
        X = new SimpleIntegerProperty(this, TITLE_PROP_X, 0);
        Y = new SimpleIntegerProperty(this, TITLE_PROP_Y, 0);
        A = new SimpleIntegerProperty(this, TITLE_PROP_A, 0);
        S = new SimpleIntegerProperty(this, TITLE_PROP_S, 0);

    }

    //Основной для паттерна Composit
    public LeyoutComponentView(LeyoutComponentController controller, int size, int x, int y, int a){
        this.controller = controller;
        this.setSize(size);
        this.x = x;
        this.y = y;
        this.a = a;
        disactivate();
        createNodes();
        texts = new ArrayList<>();
        activeElements = new ArrayList<>();
        bounderys = new ArrayList<>();
        pasiveElements = new ArrayList<>();
        nodes = new ArrayList<>();
        this.getStylesheets().add("style.css");
        setsEvents();
        paint();

//        intProperties = new ArrayList<>();
        X = new SimpleIntegerProperty(this, TITLE_PROP_X, x);
        Y = new SimpleIntegerProperty(this, TITLE_PROP_Y, y);
        A = new SimpleIntegerProperty(this, TITLE_PROP_A, a);
        S = new SimpleIntegerProperty(this, TITLE_PROP_S, size);

        relocate(x, y, a);
    }

    public ArrayList<IntegerProperty> getIntProperties() {
        return controller.getIntProperties();
    }

    public ArrayList<StringProperty> getStrProperties() {
        return controller.getStrProperties();
    }


    /**General - общие методы для композит и Leaf*/

    public abstract void paint();        //Рисование у Leaf. Добавление и расположение элементов у Composit

    public abstract void reset();

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
            if (!(controller == null)) {
                PropertyPane pp = PropertyPane.getInstance();
                pp.addProperties(controller, getStrProperties(), getIntProperties());
            }
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

    public void setController(LeyoutComponentController controller){
        this.controller = controller;

    }

    public void setSize(int size){
        this.size = size;
    }

    public void relocate(int x, int y, double a){                             //Перемещение группы
        X.set(x);
        Y.setValue(y);
        A.setValue(a);
        this.relocate(X.getValue(), Y.getValue());
        this.setRotate(A.getValue());
    }

    public void refresh(){
        this.relocate(X.getValue(), Y.getValue(), A.getValue());
    };

    public void updateProperties(){
        getIntProperties().addAll(Arrays.asList(new IntegerProperty[]{X, Y, A, S}));
    }
}
