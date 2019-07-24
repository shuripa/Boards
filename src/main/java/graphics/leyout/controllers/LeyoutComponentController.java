package graphics.leyout.controllers;

import graphics.GraphicsController;
import graphics.Layout;
import graphics.cards.ShapeInfo;
import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.views.LeyoutComponentView;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseButton;
import javafx.scene.input.TransferMode;
import model.Condition;
import panes.PropertyPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class LeyoutComponentController extends GraphicsController {
    private LeyoutComponentController parent;
    private LeyoutComponentController controller;
    private LeyoutComponent component;
    private LeyoutComponentView view;


    private ArrayList<StringProperty> strProperties; // Строковые свойства
    private ArrayList<IntegerProperty> intProperties; // Строковые свойства
    /**    General */


    public LeyoutComponentController() throws IOException {
        super();
        this.controller = this;
        strProperties = new ArrayList<>();
        intProperties = new ArrayList<>();
        setViewProperties();
        component().addObserver(this);
//        SetComponentControllers scc = SetComponentControllers.getInstance();
//        scc.addComponentController(this);
    }

    public LeyoutComponentController(LeyoutComponent component) throws IOException {
        super();
        this.controller = this;
        this.component = component;
        strProperties = new ArrayList<>();
        intProperties = new ArrayList<>();
        setComponentProperties();
        setViewProperties();
        component().addObserver(this);
//        SetComponentControllers scc = SetComponentControllers.getInstance();
//        scc.addComponentController(this);
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
        intProperties.addAll(Arrays.asList(new IntegerProperty[]{xProperty(), yProperty(), aProperty(), sProperty()}));
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
        view().updateView();
    }

    public void setXY(int x, int y) {
        setX(x);
        setY(y);
        view().updateView();
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

    public void viewEvents() throws IOException {

        view().setOnMouseEntered(mouseEvent -> {
            select();
        });

        view().setOnMouseExited(mouseEvent -> {
            unselect();
        });

        view().setOnMouseClicked(mouseEvent -> {
            PropertyPane pp = PropertyPane.getInstance();
            pp.addProperties(controller(), strProperties, intProperties);
            if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                if (component() != null) new ShapeInfo(controller());
            }

            if (mouseEvent.getClickCount() == 2){
                Layout l = null;
                try {
                    l = Layout.getInstace();
                    l.createTextField (controller(), mouseEvent.getSceneX(), mouseEvent.getSceneY());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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

    public ArrayList<Condition> getConditions(){
        return component().getConditions();
    }

    public void select() {
        view().setScaleX(1.02);
        view().setScaleY(1.02);
        view().entered();
    }

    public void unselect() {
        view().setScaleX(1.0);
        view().setScaleY(1.0);
        view().exited();
    }

    public void selectHuman() {
    }

    public void unselectHuman(){
    }
}