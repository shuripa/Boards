package leyout.controllers;

import javafx.scene.input.MouseButton;
import leyout.views.ShapeTestTable;
import model.TestTable;

public class TestTableController extends LeyoutComponentController {

    public TestTableController (TestTable table){
        setComponent(table);
        setView(new ShapeTestTable());
        ((TestTable) component()).setId(0);
        ((TestTable) component()).setTitle("Untitled");
//        ((ShapeTestTable)view()).setSize(60);
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

    public int getId() {
        return ((TestTable) component()).getId();
    }

    public String getTitle() {
        return ((TestTable) component()).getTitle();
    }

}