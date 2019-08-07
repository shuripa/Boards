package graphics.leyout.controllers;

import graphics.leyout.components.TestTable;
import graphics.leyout.views.TestTableView;

import java.io.IOException;

public class TestTableController extends LeyoutComponentController {

    public TestTableController (TestTable table) throws IOException {
        super(table);
        setView(new TestTableView(this));
        ((TestTableView)view()).setIdText("" + table.getId());
        ((TestTableView)view()).setTitleText(table.getTitle());
    }

    public TestTableController (LeyoutCompositController controller, TestTable table) throws IOException {
        super(table);
        setView(new TestTableView(this));
        setParent(controller);
        ((TestTableView)view()).setIdText("" + table.getId());
        ((TestTableView)view()).setTitleText(table.getTitle());
    }

    @Override
    protected void setComponentProperties() {

    }


    public String getId() {
        return ((TestTable) component()).getId();
    }

    public String getTitle() {
        return ((TestTable) component()).getTitle();
    }

}