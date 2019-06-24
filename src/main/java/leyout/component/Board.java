package leyout.component;

        import leyout.controllers.BoardController;

public class Board extends LeyoutComponent {

    int id;
    String title;
    String condition;

    public Board(BoardController controller, int id, String title) {
        super(controller);
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String toString(){
        return "Дошка:\nID = " + id +";\nTitle = " + title + ";\nCondition = " + condition;
    }

    public void setID(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}