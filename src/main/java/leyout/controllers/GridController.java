package leyout.controllers;

import leyout.components.Grid;
import leyout.views.ShapeGrid;

import java.util.ArrayList;

public class GridController extends LeyoutComponentController {

    public GridController(int size) {
        component = new Grid(this);
        view = new ShapeGrid(this, size);
    }

    public ArrayList<String> getMaterial() {
        return ((Grid) component).getSingleMaterial();
    }

    //Удалить
    public void setMaterial(ArrayList<String> material) {
        ((Grid) component).setMaterials(material);
    }

    public void addMaterial(String material) {
        ((Grid) component).addMaterial(material);
    }

    public void setMaterials(ArrayList<String> materials) {
        ((Grid) component).setMaterials(materials);
    }
}
