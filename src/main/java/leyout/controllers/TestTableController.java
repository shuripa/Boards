package leyout.controllers;

import leyout.views.ShapeTestTable;
import model.TestTable;

public class TestTableController extends LeyoutComponentController {

    public TestTableController (){
        super();
        view = new ShapeTestTable(this);
        component = new TestTable(this);
        ((TestTable) component).setId(0);
        ((TestTable) component).setTitle("Untitled");
        view.setSize(60);
    }

    public TestTableController (Integer id, String title, int size){
        super();
        component = new TestTable(this);
        ((TestTable) component).setId(id);
        ((TestTable) component).setTitle(title);
        view = new ShapeTestTable(this, size);
//        view.setSize(size);
    }

    public int getId() {
        return ((TestTable) component).getId();
    }

    public void setId(int id){
        ((TestTable) component).setId(id);
    }

    public String getTitle() {
        return ((TestTable) component).getTitle();
    }

    public void setTitle(String title){
        ((TestTable) component).setTitle(title);
    }

    public void setSize (int size){

    }
}