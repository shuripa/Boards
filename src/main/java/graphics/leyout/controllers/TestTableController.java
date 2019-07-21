package graphics.leyout.controllers;

import graphics.leyout.views.TestTableView;
import javafx.scene.input.MouseButton;
import graphics.leyout.components.TestTable;

import java.io.IOException;

public class TestTableController extends LeyoutComponentController {

    public TestTableController (TestTable table) throws IOException {
        super(table);
        setView(new TestTableView(this));
        ((TestTableView)view()).setIdText("" + table.getId());
        ((TestTableView)view()).setTitleText(table.getTitle());
    }

    public TestTableController (LeyoutComponentController controller, TestTable table) throws IOException {
        super(table);
        setView(new TestTableView(this));
        setParent(controller);
        ((TestTableView)view()).setIdText("" + table.getId());
        ((TestTableView)view()).setTitleText(table.getTitle());
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

    public String getId() {
        return ((TestTable) component()).getId();
    }

    public String getTitle() {
        return ((TestTable) component()).getTitle();
    }

}