package leyout.controllers;

import javafx.scene.input.MouseButton;
import leyout.components.Grid;
import leyout.views.GridView;

import java.util.ArrayList;

public class GridController extends LeyoutComponentController {

    public GridController(Grid grid) {
        super(grid);
        setView(new GridView(this));
    }

    public ArrayList<String> getMaterial() {
        return ((Grid) component()).getSingleMaterial();
    }


    @Override
    protected void setComponentProperties() {
        System.out.println("No property");
    }

    @Override
    protected void setEventTonExt(MouseButton button) {

    }

    @Override
    public void updateData() {

    }
}
