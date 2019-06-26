package leyout.controllers;

import javafx.scene.input.MouseButton;
import leyout.components.Grid;
import leyout.views.ShapeGrid;

import java.util.ArrayList;

public class GridController extends LeyoutComponentController {

    public GridController(Grid grid) {
        setComponent(grid);
        setView(new ShapeGrid());
    }

    public ArrayList<String> getMaterial() {
        return ((Grid) component()).getSingleMaterial();
    }

    //Удалить
    public void setMaterial(ArrayList<String> material) {
        ((Grid) component()).setMaterials(material);
    }

    public void addMaterial(String material) {
        ((Grid) component()).addMaterial(material);
    }

    public void setMaterials(ArrayList<String> materials) {
        ((Grid) component()).setMaterials(materials);
    }

    @Override
    protected void setComponentProperties() {

    }

    @Override
    protected void setEventTonExt(MouseButton button) {

    }

    @Override
    public void update() {

    }
}
