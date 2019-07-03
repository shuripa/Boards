package graphics.controllers;

import javafx.scene.input.MouseButton;
import graphics.views.ShapeTestTable;
import model.TestTable;

import java.io.IOException;

public class TestTableController extends LeyoutComponentController {

    public TestTableController (LeyoutComponentController controller, TestTable table) throws IOException {
        super(table);
        setView(new ShapeTestTable(this));
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
    public void updateViewData() {

    }

    @Override
    protected void setDragEvent() {

    }

    public int getId() {
        return ((TestTable) component()).getId();
    }

    public String getTitle() {
        return ((TestTable) component()).getTitle();
    }

}