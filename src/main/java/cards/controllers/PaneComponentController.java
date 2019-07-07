package cards.controllers;


import graphics.Layout;
import graphics.controllers.LeyoutComponentController;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import graphics.components.LeyoutComponent;
import cards.views.PaneComponentView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

import java.io.IOException;
import java.util.ArrayList;

public abstract class PaneComponentController {

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

    private LeyoutComponent component;
    private LeyoutComponent sender;
    private PaneComponentView view;
    private PaneComponentController controller;
//    private ArrayList<StringProperty> strProperties; // Строковые свойства
//    private ArrayList<IntegerProperty> intProperties; // Строковые свойства


    public PaneComponentController() {
        this.controller = this;
        X = new SimpleIntegerProperty(this, TITLE_PROP_X, 0);
        Y = new SimpleIntegerProperty(this, TITLE_PROP_Y, 0);
        A = new SimpleIntegerProperty(this, TITLE_PROP_A, 0);
        S = new SimpleIntegerProperty(this, TITLE_PROP_S, 0);

    }

    public PaneComponentController(LeyoutComponent component) {
        this.component = component;
        this.controller = this;
//        view.setComponentProperties();
        X = new SimpleIntegerProperty(this, TITLE_PROP_X, 0);
        Y = new SimpleIntegerProperty(this, TITLE_PROP_Y, 0);
        A = new SimpleIntegerProperty(this, TITLE_PROP_A, 0);
        S = new SimpleIntegerProperty(this, TITLE_PROP_S, 0);
    }

    public PaneComponentController(LeyoutComponent component, LeyoutComponent sender) {
        this.component = component;
        this.controller = this;
        this.sender = sender;
//        view.setComponentProperties();
        X = new SimpleIntegerProperty(this, TITLE_PROP_X, 0);
        Y = new SimpleIntegerProperty(this, TITLE_PROP_Y, 0);
        A = new SimpleIntegerProperty(this, TITLE_PROP_A, 0);
        S = new SimpleIntegerProperty(this, TITLE_PROP_S, 0);
    }

    public void setView(PaneComponentView view) {
        this.view = view;
        viewSets();
        viewEvents();
        updateData();
        view().paint();
        view.setViewProperties();
    }

    public PaneComponentView view(){
        return view;
    }

    public LeyoutComponent component(){
        return component;
    }

    public LeyoutComponent sender(){
        return sender;
    }

    public PaneComponentController controller(){
        return controller;
    }

    private void viewSets() {
        view().getStylesheets().add("style.css");
    }

    public void viewEvents() {
        view().setOnMouseEntered(mouseEvent -> {
            view.entered();
        });

        view().setOnMouseExited(mouseEvent -> {
            view.exited();
        });

        view().setOnMouseClicked(mouseEvent -> {
//            try {
//                createLeyoutComponent(mouseEvent.getSceneX(), mouseEvent.getSceneY());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        });

        view().setOnDragDetected(mouseEvent -> {
            try {
                LeyoutComponentController controller = createLeyoutComponent(mouseEvent.getSceneX(), mouseEvent.getSceneY());
                Layout.getInstace().drugComponent((int)mouseEvent.getSceneX(), (int)mouseEvent.getSceneY(), controller);
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

    protected abstract LeyoutComponentController createLeyoutComponent(double x, double y) throws IOException;

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

    public void update(){
        updateData();
        updateView();
    }

    public abstract void updateData();

    public void updateView(){
        view.repaint();
    }

    public abstract String getText();
}
