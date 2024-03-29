package graphics.leyout.controllers;

import graphics.GraphicsElement;
import graphics.Hint;
import graphics.Layout;
import graphics.cards.ShapeInfo;
import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.views.LeyoutComponentView;
import inout.CompositBuilder;
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

public abstract class LeyoutComponentController extends GraphicsElement {
    private LeyoutCompositController parent;
    private LeyoutComponentController controller;
    private LeyoutComponent component;
    private LeyoutComponentView view;
    private Hint hint;

    private ArrayList<StringProperty> strProperties; // Строковые свойства
    private ArrayList<IntegerProperty> intProperties; // Строковые свойства
    /**    General */


    public LeyoutComponentController() {
        super();
        this.controller = this;
        strProperties = new ArrayList<>();
        intProperties = new ArrayList<>();
        hint = new Hint(this, "");
        setViewProperties();
        component().addControllerObserver(this);
//        SetCompositControllers scc = SetCompositControllers.getInstance();
//        scc.addComponentController(this);
    }

    public LeyoutComponentController(LeyoutComponent component) {
        super();
        this.controller = this;
        this.component = component;
        strProperties = new ArrayList<>();
        intProperties = new ArrayList<>();
        try {
            setComponentProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setViewProperties();
        component().addControllerObserver(this);
//        hint = new Hint(this, "");

//        SetCompositControllers scc = SetCompositControllers.getInstance();
//        scc.addComponentController(this);
    }

    public LeyoutComponentController(LeyoutComponent component, CompositBuilder builder){
        super();
        this.controller = this;
        this.component = component;
        strProperties = new ArrayList<>();
        intProperties = new ArrayList<>();
        try {
            setComponentProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setViewProperties();
        component().addControllerObserver(this);
//        hint = new Hint(this, "");
        setXYAS(builder.getX(), builder.getY(), builder.getA(), builder.getS());
    }

    /** Getters and Setters */

    public void setParent(LeyoutCompositController parent) {
        this.parent = parent;
    }

    public void setController(LeyoutComponentController controller) {
        this.controller = controller;
    }

    public void setComponent(LeyoutComponent component) {
        this.component = component;
        try {
            setComponentProperties();
        } catch (IOException e) {
            e.printStackTrace();
        }
        component.addControllerObserver(this);
    }

    public void setView(LeyoutComponentView view) throws IOException {
//        if (this.view != null)
        this.view = view;
        viewSets();
        viewEvents();
        view().paint();
        if (component != null) update();
    }

    public void setHint(String s){
        hint = new Hint(controller, s);
    }

    public void showHint(int x, int y){
        if (hint != null);
        hint.showhint(x, y);
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

    protected abstract void setComponentProperties() throws IOException;


    //Если где-нибудь в потомках update переопределен, и нет обращения super.update - обновление вида ломается.
    public void update(){
        view().update();
    }

    private void viewSets(){
        view().getStylesheets().add("style.css");
    }

    public void viewEvents() throws IOException {

        view().setOnMouseEntered(mouseEvent -> {
            select();
            if (hint != null) hint.showhint(mouseEvent.getSceneX(), mouseEvent.getScreenY());
        });

        view().setOnMouseExited(mouseEvent -> {
            unselect();
            if (hint != null) hint.hide();
        });

        view().setOnMouseClicked(mouseEvent -> {
            //TODO Это проблема, когда MouseClick переопределяется свойства не загружаются.
            PropertyPane pp = PropertyPane.getInstance();
            pp.addProperties(controller(), strProperties, intProperties);
            if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                if (component() != null) new ShapeInfo(controller());
            }

            if (mouseEvent.getClickCount() == 2){
                Layout l = Layout.getInstace();
            }
        });

        view().setOnDragDetected(mouseEvent -> {
//            System.out.println("On drag detected.");
            Layout.getInstace().drugComponent((int)mouseEvent.getSceneX(), (int)mouseEvent.getSceneY(), this);
            Dragboard db = view().startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            if (this.toString() != null){
                content.putString(this.toString());
            } else {
                content.putString("");
            }
            db.setContent(content);

            mouseEvent.consume();
        });

    }

    public ArrayList<Condition> getConditions(){
        return component().getConditions();
    }

    /** Behavior */

    public void activate() {
        view.activate();
    }

    public void select() {
        select(1);
    }

    public void select(int i){
        //0 - прозрачный, 1 серый цвет
        view().setScaleX(1.02);
        view().setScaleY(1.02);
        view().entered(i);
    }

    public void unselect() {
        view().setScaleX(1.0);
        view().setScaleY(1.0);
        view().exited();
    }

    /** Get String */

    @Override
    public String toString(){
        return component().toString();
    }

    public String getText() {
        return "0";
    }
}