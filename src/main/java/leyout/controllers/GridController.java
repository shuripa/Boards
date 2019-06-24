package leyout.controllers;

import leyout.component.Grid;
import leyout.views.ShapeGrid;

import java.util.ArrayList;

public class GridController extends LeyoutComponentController {

    public GridController(int size) {
        element = new Grid(this);
        wiev = new ShapeGrid(this, size);
    }

    public ArrayList<String> getMaterial() {
        return ((Grid)element).getSingleMaterial();
    }

    //Удалить
    public void setMaterial(ArrayList<String> material) {
        ((Grid)element).setMaterials(material);
    }

    public void addMaterial(String material) {
        ((Grid)element).addMaterial(material);
    }

    public void setMaterials(ArrayList<String> materials) {
        ((Grid)element).setMaterials(materials);
    }
}