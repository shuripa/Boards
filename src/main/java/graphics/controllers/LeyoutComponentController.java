package graphics.controllers;

import graphics.Layout;
import graphics.components.LeyoutComponent;
import graphics.views.LeyoutComponentView;
import graphics.views.ShapeInfo;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseButton;
import javafx.scene.input.TransferMode;
import panes.PropertyPane;

import java.io.IOException;
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


    public LeyoutComponentController() {
        this.controller = this;
        strProperties = new ArrayList<>();
        intProperties = new ArrayList<>();

        X = new SimpleIntegerProperty(this, TITLE_PROP_X, 0);
        Y = new SimpleIntegerProperty(this, TITLE_PROP_Y, 0);
        A = new SimpleIntegerProperty(this, TITLE_PROP_A, 0);
        S = new SimpleIntegerProperty(this, TITLE_PROP_S, 60);
        setViewProperties();
    }

    public LeyoutComponentController(LeyoutComponent component) {
        this.controller = this;
        this.component = component;
        strProperties = new ArrayList<>();
        intProperties = new ArrayList<>();
        setComponentProperties();
        X = new SimpleIntegerProperty(this, TITLE_PROP_X, 0);
        Y = new SimpleIntegerProperty(this, TITLE_PROP_Y, 0);
        A = new SimpleIntegerProperty(this, TITLE_PROP_A, 0);
        S = new SimpleIntegerProperty(this, TITLE_PROP_S, 60);
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
        setComponentProperties();
        component.addObserver(this);
    }

    public void setView(LeyoutComponentView view) throws IOException {
        this.view = view;
        viewSets();
        viewEvents();
        if (component != null) updateViewData();
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
        updateViewData();
        updateView();
    }

    public abstract void updateViewData();

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

    private void viewEvents() throws IOException {

        view().setOnMouseEntered(mouseEvent -> {
            view().setScaleX(1.02);
            view().setScaleY(1.02);
            view.entered();
        });

        view().setOnMouseExited(mouseEvent -> {
            view().setScaleX(1.0);
            view().setScaleY(1.0);
            view.exited();
        });

        view().setOnMouseClicked(mouseEvent -> {
            PropertyPane pp = PropertyPane.getInstance();
            pp.addProperties(controller(), strProperties, intProperties);
            if (component()!= null) new ShapeInfo(controller());
        });

        view().setOnDragDetected(mouseEvent -> {
            System.out.println("On drag detected.");
            try {
                Layout.getInstace().drugComponent((int)mouseEvent.getSceneX(), (int)mouseEvent.getSceneY(), this);
            } catch (IOException e) {
                e.printStackTrace();
            }

            Dragboard db = view().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            content.putString(this.toString());
            db.setContent(content);

            mouseEvent.consume();


        });
    }

    protected abstract void setDragEvent();

    protected abstract void setEventTonExt(MouseButton button);



}