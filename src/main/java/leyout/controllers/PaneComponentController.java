package leyout.controllers;


import javafx.scene.layout.Region;
import leyout.components.LeyoutComponent;
import leyout.views.PaneComponentView;
import panes.PropertyPane;

public abstract class PaneComponentController extends Region {

    private LeyoutComponent emp;
    private PaneComponentView view;
    private PaneComponentController controller;

    public PaneComponentController(LeyoutComponent emp) {
        this.emp = emp;
    }

    public void setView(PaneComponentController controller) {
        this.controller = controller;
        viewSets();
        viewEvents();
        updateData();
        view().paint();
    }

    public PaneComponentView view(){
        return view;
    }

    private void viewSets() {
        view().getStylesheets().add("style.css");
    }

    private void viewEvents() {
        view().setOnMouseEntered(mouseEvent -> {
            view.entered();
        });

        view().setOnMouseExited(mouseEvent -> {
            view.exited();
        });

        view().setOnMouseClicked(mouseEvent -> {
            PropertyPane pp = PropertyPane.getInstance();
            pp.addProperties(this, strProperties, intProperties);
            new ShapeInfo(this);
        });
    }

    public void update(){
        updateData();
        updateView();
    }

    public abstract void updateData();

    public void updateView(){
        repaint();
    }

    public abstract void paint();

    public abstract void repaint();
}
