package graphics.leyout.components;

public class Convier extends LeyoutComponent {
    int countPos;
    String id;
    String title;

    public Convier(int countPos){
        this.countPos = countPos;
    }

    public Convier(int countPos, String id, String title){
        this.id = id;
        this.title = title;
        this.countPos = countPos;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCountPos() {
        return countPos;
    }

    @Override
    public String toString() {
        return "";
    }

}
