package leyout.wievs;

import javafx.geometry.Bounds;
import javafx.scene.input.MouseButton;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import leyout.LeyoutComponentWiev;

//Заготовка
public class ShapeBlank extends LeyoutComponentWiev {
    private int width;
    private int height;
    private int size;
    private int x;
    private int y;
    private String id;
    private String description;
    private String style;

    public ShapeBlank(String id, String description, int size){
        super();
        this.id = id;
        this.description = description;
        this.size = size;
//        this.style = "-fx-fill: RGBA(82,79,161,0.6)";
        //Всплывающее окно
        this.setOnMouseClicked(mouseEvent -> {
            ShapeInfo shinfo= new ShapeInfo(new Text("Заготовка:" + "\n Назва дошки: " + description + "\n Номер дошки: " + id), 40);
            Bounds bounds = this.localToScreen (this.getBoundsInLocal());           //Границы текущего элемента
            shinfo.show(this, bounds.getMaxX(), bounds.getMinY() -10);    //
        });
        paint();

    }

    @Override
    protected void setEventTonExt(MouseButton button) {

    }

    @Override
    protected void getElements() {

    }

    @Override
    protected void emplacement(int size) {

    }

    public void paint() {
//        rb
        Rectangle rb = new Rectangle(size-5,20);
        rb.setId("blank");
        rb.setStrokeWidth(0.5);
//        rb.setStroke(javafx.scene.paint.Color.WHITE);
//        rb.setStroke(Color.BLACK);
//        rb.setStyle(style);
//        rb.setStyle("-fx-fill: WHITE");
        rb.relocate(.5,.5);
        addActiveElement(rb);

//        this.setOnMouseEntered(event -> {
//            rb.setStyle("-fx-fill: RGBA(82,79,161,1.0)");
//            this.updateBounds();                                //Вариант 1.
//        });
//        this.setOnMouseExited(event -> {
//            rb.setStyle("-fx-fill: RGBA(82,79,161,0.6)");
//            this.requestLayout();                               //Вариант 2.
//        });

//        //l
//        Line l = new Line(0, 9.5, size-5, 9.5);
//        l.setFill(null);
//        l.setStroke(Color.WHITE);
//        l.setStrokeWidth(.5);

        //td
        Text td = new Text("" + description);
        td.setFont(new Font(11));
//        td.setStyle("-fx-fill: white; -fx-font-family: monospace;");
        td.setX(4);
        td.setY(18);

        //ti
        Text ti = new Text("Заготовка");
        ti.setFont(new Font(9));
//        ti.setStyle("-fx-fill: white; -fx-font-family: monospace;");
        ti.setX(2);
        ti.setY(8);
        addTexts(td, ti);

//        this.getChildren().addAll(rb, td, ti);
//        this.getChildren().addAll(td, ti);

    }

    @Override
    public void setSize(int size) {

    }

    @Override
    public void reset() {

    }

    @Override
    public void showInfo() {

    }
}
