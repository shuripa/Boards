package startmenu;

import javafx.scene.control.TitledPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/*
StartMenuItem - кнопка, которая создает сцену.
 */

public class StartMenuItem extends Region {
    TitledPane propertyPane;
    ItemAction itemAction;
                                                                                                                        // Свойства кнопки.
                                                                                                                        // w, h, x, y - размеры кнопки// text - текст кнопки
    public StartMenuItem(ItemAction action, int w, int h, int x, int y, String text){
        this.getStylesheets().add("style.css");                                                                         // Получение стиля стиля
        this.itemAction = action;

        Rectangle rb = new Rectangle(w, h);                                                                             // Рисование кнопки
//        addActiveElement(rb);
        rb.setStroke(Color.rgb(82, 79, 161, 0.5));
        rb.setStrokeWidth(0.5);
        rb.setId("blankbound");
        rb.relocate(x,y);
//        rb.setStyle("-fx-fill: #4287f5");

        //td
        Text td = new Text(text);                                                                                       // Текст кнопки
        td.setFont(new javafx.scene.text.Font(32));
//        td.setId("blanktxt");
        td.setX(x + 35);
        td.setY(y + 50);

//        addActiveElement(td);

        rb.setOnMouseClicked(event -> {
            rb.setId("ent");
            updateBounds();
            itemAction.action();
        });

        rb.setOnMouseEntered(event -> {
            rb.setId("selbound");
            td.setId("seltxt");
        });

        rb.setOnMouseExited(event -> {
            rb.setId("blankbound");
            td.setId("blanktxt");
        });


        this.getChildren().addAll(rb, td);
    }

    public void setPropertyPane(TitledPane propertyPane) {
        this.propertyPane = propertyPane;
    }



}
