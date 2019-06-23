package leyout.controllers;

import leyout.wievs.ShapeTestTable;
import model.TestTable;

public class TestTableController extends LeyoutElementController {

    public TestTableController (){
        super();
        wiev = new ShapeTestTable(this);
        element = new TestTable(this);
        ((TestTable)element).setId(0);
        ((TestTable)element).setTitle("Untitled");
        wiev.setSize(60);
    }

    public TestTableController (Integer id, String title, int size){
        super();
        element = new TestTable(this);
        ((TestTable)element).setId(id);
        ((TestTable)element).setTitle(title);
        wiev = new ShapeTestTable(this, size);
//        wiev.setSize(size);
    }

    public int getId() {
        return ((TestTable)element).getId();
    }

    public void setId(int id){
        ((TestTable)element).setId(id);
    }

    public String getTitle() {
        return ((TestTable)element).getTitle();
    }

    public void setTitle(String title){
        ((TestTable)element).setTitle(title);
    }

    public void setSize (int size){

    }
}