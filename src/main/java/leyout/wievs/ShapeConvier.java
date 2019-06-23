package leyout.wievs;

import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import leyout.groups.GroupBoard;

public class ShapeConvier extends Region {
    private int size;
    private int countPos;
    private String style;

    private float rBoard;	//Внутренний радиус доски
    private float RBoard;	//Внешний радиус доски
    private float rLine;	//Внутренний радиус ленты
    private float RLine;	//Внешний радиус ленты
    private float LLine; 	//Длина ленты

    public ShapeConvier(int size, int countPos){
        this.size = size;
        this.countPos = countPos;
        this.style = "-fx-fill: RGBA(82,79,161,0.6)";

        rLine = 12;
        RLine = 16;
        LLine = (float) ((countPos*(size+10))/2 - Math.PI*RLine);
        RBoard = (float) Math.sqrt(Math.pow(size/2, 2) + Math.pow((20+RLine),2));
        rBoard = (float) Math.sqrt(Math.pow(size/2, 2) + Math.pow(RLine,2));

        System.out.println(size + "size");
        System.out.println(LLine + " :LLine");
        System.out.println(RLine + " :RLine");
        System.out.println(rBoard + " :rBoard");
        System.out.println(RBoard + " :RBoard");

        paint();
//		board();
        arrBoard();
    }

    private void paint() {
        //circle board up external
        Circle cbue = new Circle(RBoard, RBoard, RBoard);
//        cbue.setStroke(Color.WHITE);
        cbue.setStroke(Color.GREY);
        cbue.setStrokeWidth(0.5);
//        cbue.setFill(Color.YELLOW);
        cbue.setFill(Color.WHITE);
//        cbue.setStyle("-fx-opacity: .4");

        //circle board up internal
        Circle cbui = new Circle(RBoard, RBoard, rBoard);
//        cbui.setStroke(Color.WHITE);
        cbui.setStroke(Color.GREY);
        cbui.setStrokeWidth(0.5);
        cbui.setFill(Color.WHITE);

        //circle line up internal
        Circle clui = new Circle(RBoard, RBoard, rLine);
        clui.setStroke(Color.GREY);
        clui.setStrokeWidth(0.5);
        clui.setFill(Color.WHITE);

        //circle board down external
        Circle cbde = new Circle(RBoard, RBoard+LLine, RBoard);
        cbde.setStroke(Color.GREY);
        cbde.setStrokeWidth(0.5);
        cbde.setFill(Color.WHITE);
//        cbde.setStyle("-fx-opacity: .4");

        //circle board down internal
        Circle cbdi = new Circle(RBoard, RBoard+LLine, rBoard);
        cbdi.setStroke(Color.GREY);
        cbdi.setStrokeWidth(0.5);
        cbdi.setFill(Color.WHITE);

        //circle line down internal
        Circle cldi = new Circle(RBoard,RBoard+LLine, rLine);
        cldi.setStroke(Color.GREY);
        cldi.setStrokeWidth(0.5);
        cldi.setFill(Color.WHITE);

        //rectangle external
        Rectangle re = new Rectangle(RBoard-RLine, RBoard-RLine,RLine*2, LLine+2*RLine);
        re.setStroke(Color.GREY);
        re.setStrokeWidth(0.5);
        re.setArcHeight(2*RLine);
        re.setArcWidth(2*RLine);
        re.setStyle(style);

        //rectangle internal
        Rectangle ri = new Rectangle(RBoard - rLine, RBoard,rLine*2, LLine);
        ri.setStroke(Color.GREY);
        ri.setStrokeWidth(0.5);
        ri.setFill(Color.WHITE);
        this.getChildren().addAll(cbue, cbui, cbde, cbdi, re, ri, clui, cldi);
    }

    private void arrBoard() {
        GroupBoard[] arrPos = new GroupBoard[countPos];

        for (int i = 0; i < countPos/2; i++) {
            arrPos[i] = new GroupBoard(i,"", size,0, size, 90, 0);
            arrPos[i].setLayoutX(RBoard+34-size/2);
            arrPos[i].setLayoutY(RBoard-27+(size+10)*i);
            this.getChildren().addAll(arrPos[i]);
        }

        for (int i = 0; i < countPos/2; i++) {
            arrPos[i] = new GroupBoard(i, "", size, 0, size, -90, 0);
            arrPos[i].setLayoutX(RBoard-36-size/2);
            arrPos[i].setLayoutY(RBoard+LLine-20-(size+10)*i);
            this.getChildren().addAll(arrPos[i]);
        }
    }
}
