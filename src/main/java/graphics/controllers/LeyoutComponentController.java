package graphics.controllers;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.input.MouseButton;
import graphics.components.LeyoutComponent;
import graphics.views.LeyoutComponentView;
import graphics.views.ShapeInfo;
import panes.PropertyPane;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class LeyoutComponentController {
    private LeyoutComponentController parent;
    private LeyoutComponentController controller;
    private LeyoutComponent component;
    private LeyoutComponentView view;

    private ArrayList<StringProperty> strProperties; // Строковые свойства
    private ArrayList<IntegerProperty> intProperties; // Строковые свойства
    private final static String TITLE_PROP_X = "X";
    private final static String TITLE_PROP_Y = "Y";
    private final static String TITLE_PROP_A = "A";
    private final static String TITLE_PROP_S = "S";
    private final IntegerProperty X;
    private final IntegerProperty Y;
    private final IntegerProperty A;
    private final IntegerProperty S;
    /**    General */


    public LeyoutComponentController(LeyoutComponent component) {
        this.controller = this;
        this.component = component;
        strProperties = new ArrayList<>();
        intProperties = new ArrayList<>();
        setComponentProperties();
        X = new SimpleIntegerProperty(this, TITLE_PROP_X, 0);
        Y = new SimpleIntegerProperty(this, TITLE_PROP_Y, 0);
        A = new SimpleIntegerProperty(this, TITLE_PROP_A, 0);
        S = new SimpleIntegerProperty(this, TITLE_PROP_S, 0);
        setViewProperties();
        component().addObserver(this);
    }
    /** Getters and Setters */

    public void setParent(LeyoutComponentController parent) {
        this.parent = parent;
    }

    public void setController(LeyoutComponentController controller) {
        this.controller = controller;
    }

    public void setComponent(LeyoutComponent component) {
        this.component = component;
    }

    public void setView(LeyoutComponentView view) {
        this.view = view;
        viewSets();
        viewEvents();
        updateData();
        view().paint();
    }


    public LeyoutComponentController parent () {
        return parent;
    }

    public LeyoutComponentController controller() {
        return controller;
    }

    public LeyoutComponent component(){
        return component;
    }

    public LeyoutComponentView view(){
        return view;
    }


    /** Properties */

    public int getX() {
        return X.get();
    }

    public IntegerProperty xProperty() {
        return X;
    }

    public int getY() {
        return Y.get();
    }

    public IntegerProperty yProperty() {
        return Y;
    }

    public int getA() {
        return A.get();
    }

    public IntegerProperty aProperty() {
        return A;
    }

    public int getS() {
        return S.get();
    }

    public IntegerProperty sProperty() {
        return S;
    }

    public void setX(int x) {
        this.X.set(x);
        view().updateView();
    }

    public void setY(int y) {
        this.Y.set(y);
        view().updateView();
    }

    public void setA(int a) {
        this.A.set(a);
        view().updateView();
    }

    public void setS(int s) {
        this.S.set(s);
        view().updateView();
    }


    public void setStrProperty (StringProperty strProperty){
        strProperties.add(strProperty);
    }

    public void setIntProperty (IntegerProperty intProperty) {
        intProperties.add(intProperty);
    }

    public ArrayList<StringProperty> getStrProperties() {
        return strProperties;
    }

    public ArrayList<IntegerProperty> getIntProperties() {
        return intProperties;
    }

    private void setViewProperties(){
        intProperties.addAll(Arrays.asList(new IntegerProperty[]{X, Y, A, S}));
    }

    protected abstract void setComponentProperties();

    public void update(){
        updateData();
        updateView();
    }

    public abstract void updateData();

    public void updateView(){
        view().updateView();
    }

    /** Sizes */

    public void setXYAS(int x, int y, int angle, int size){                             //Перемещение группы
        setX(x);
        setY(y);
        setA(angle);
        setS(size);
    }

    public void setXY(int x, int y) {
        setX(x);
        setY(y);
    }

    /** Get String */

    @Override
    public String toString(){
        return component().toString();
    }

    public String getText(){
        return "0";
    }

    /** Behavior */

    public void activate() {
        view.activate();
    }

    private void viewSets(){
        view().getStylesheets().add("style.css");
    }

    private void viewEvents(){
        view().setOnMouseEntered(mouseEvent -> {
            view.entered();
        });

        view().setOnMouseExited(mouseEvent -> {
            view.exited();
        });

        view().setOnMouseClicked(mouseEvent -> {
            PropertyPane pp = PropertyPane.getInstance();
            pp.addProperties(controller(), strProperties, intProperties);
            new ShapeInfo(controller());
        });
    }

    protected abstract void setEventTonExt(MouseButton button);



}