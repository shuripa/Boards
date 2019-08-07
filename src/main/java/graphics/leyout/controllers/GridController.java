package graphics.leyout.controllers;

import graphics.leyout.components.Grid;
import graphics.leyout.views.GridView;

import java.io.IOException;
import java.util.ArrayList;

public class GridController extends LeyoutComponentController {

    public GridController() throws IOException {
        setView(new GridView(this));
    }

    public GridController(Grid grid) throws IOException {
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


}
