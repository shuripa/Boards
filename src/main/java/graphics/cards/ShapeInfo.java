package graphics.cards;

import graphics.leyout.controllers.LeyoutComponentController;
import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Popup;

import java.util.ArrayList;

public class ShapeInfo extends Popup{
    TextFlow textMsg;
    Shape msgBubble;

    public ShapeInfo(Text descr, Integer hight){
//        Popup cards = new Popup();
        this.setAutoHide(true);
        this.setHideOnEscape(true);
//        paint(hight);

        Arc pointer = new Arc(0, 0, 20, 20, -20, 40);
        pointer.setType(ArcType.ROUND);
        Rectangle msgRect = new Rectangle( 18, -20, 200, hight);
        msgBubble = Shape.union(pointer, msgRect);
        msgBubble.setStyle("-fx-fill: RGBA(47,79,79,1.0); -fx-stroke: SlateGray; -fx-stroke-width: 0.5");
        //Text
        textMsg = new TextFlow();
        textMsg.setPrefWidth(msgRect.getWidth() -1);
        textMsg.setPrefHeight(msgRect.getHeight() -1);
        textMsg.setLayoutX(pointer.getBoundsInLocal().getWidth()+1);
        textMsg.setLayoutY(msgRect.getLayoutY()-20);



        //        Загрузка стиля
//        carInfoPopup.getScene().getStylesheets()
//                .add(getClass().getResource("/button-fun.css")
//                        .toExternalForm());


//        ScrollPane scrollPane = new ScrollPane(textMsg);
//        scrollPane.setOpacity(0.5);
//        scrollPane.setXY(18, -20);


//        Text descr = new Text("Вікно інформації");
//        descr.setFill(Color.rgb(47,79,79,1.0));
        descr.setFill(Color.rgb(255,255,255,1.0));
        textMsg.getChildren().add(descr);

        Text text = new Text("Примітка:");
        text.relocate(23, hight-20);
        text.setStyle("-fx-font-style: italic; -fx-font-size: 9");

        ArrayList<String> col = new ArrayList<>();
        col.add("id");
        col.add("name");
        col.add("cnt");
        col.add("time");

        this.getContent().addAll(msgBubble, textMsg, text);
    }

//    public ShapeInfo(Node node, int hight){
//        paint(hight);
//        node.setXY(23, hight-50);
//        this.getContent().addAll(msgBoard, node);
//    }

//    private void paint(int hight) {
//    }

    public ShapeInfo(LeyoutComponentController controller) {
        this.setAutoHide(true);
        this.setHideOnEscape(true);

        String s = "";
        if (!(controller==null)) {
            s =controller.toString();
        }

        if (!s.equals("")) {

            Arc pointer = new Arc(0, 0, 20, 20, -20, 40);
            pointer.setType(ArcType.ROUND);
            Rectangle msgRect = new Rectangle(18, -20, 300, s.lines().count() * 15.5 + 20);
            msgBubble = Shape.union(pointer, msgRect);
            msgBubble.setStyle("-fx-fill: RGBA(47,79,79,1.0); -fx-stroke: SlateGray; -fx-stroke-width: 0.5");

            //Text
            textMsg = new TextFlow();
            textMsg.setPrefWidth(msgRect.getWidth() - 1);
            textMsg.setPrefHeight(msgRect.getHeight() - 1);
            textMsg.setLayoutX(pointer.getBoundsInLocal().getWidth() + 1);
            textMsg.setLayoutY(msgRect.getLayoutY() - 20);

            Text descr = new Text(s);

            descr.setFill(Color.rgb(255, 255, 255, 1.0));
            textMsg.getChildren().add(descr);

            Text text = new Text("Примітка:");
            text.relocate(23, s.lines().count() * 20);
            text.setStyle("-fx-font-style: italic; -fx-font-size: 9");

            ArrayList<String> col = new ArrayList<>();
            col.add("id");
            col.add("name");
            col.add("cnt");
            col.add("time");



            this.getContent().addAll(msgBubble, textMsg, text);
            Bounds bounds = controller.view().localToScreen(controller.view().getBoundsInLocal());           //Границы текущего элемента
            super.show(controller.view(), bounds.getMaxX(), bounds.getMinY() - 10);    //
        }
    }

}

//            HBox hb = new HBox();

//            Button b = new Button("Free");
//            hb.getChildren().addAll(t, b);
//            hb.setSpacing(5);
//            hb.setCenterShape(true);