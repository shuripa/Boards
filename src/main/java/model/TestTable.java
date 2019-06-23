package model;

import leyout.controllers.TestTableController;
import leyout.elements.LeyoutElement;

public class TestTable extends LeyoutElement {
    private String title;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TestTable(TestTableController controller){
        super(controller);
    }

//    public TestTable(TestTableController controller, int id, String title){
//        super(controller);
//        this.id = id;
//        this.title = title;
//    }

    @Override
    public String toString(){
        return "Тевтувальний стіл:\n" +
               "Назва:              " + title + "\n" +
               "Номер:              " + id + "\n";
    }
}
