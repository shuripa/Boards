package graphics.cards.controllers;


import graphics.GraphicsController;
import graphics.Layout;
import graphics.cards.views.PaneComponentView;
import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.controllers.LeyoutComponentController;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

import java.io.IOException;
import java.util.ArrayList;

public abstract class PaneComponentController extends GraphicsController {

    private ArrayList<StringProperty> strProperties; // Строковые свойства
    private ArrayList<IntegerProperty> intProperties; // Строковые свойства


    private LeyoutComponent component;
    private LeyoutComponent sender;
    private PaneComponentView view;
    private PaneComponentController controller;
//    private ArrayList<StringProperty> strProperties; // Строковые свойства
//    private ArrayList<IntegerProperty> intProperties; // Строковые свойства


    public PaneComponentController() {
        super();
        this.controller = this;
    }

    public PaneComponentController(LeyoutComponent component) {
        super();
        this.component = component;
        this.controller = this;
//        view.setComponentProperties();
    }

    public PaneComponentController(LeyoutComponent component, LeyoutComponent sender) {
        super();
        this.component = component;
        this.controller = this;
        this.sender = sender;
//        view.setComponentProperties();
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
