package graphics.leyout.views;

import graphics.leyout.controllers.ConvierController;
import graphics.leyout.controllers.LeyoutComponentController;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class ConvierView extends LeyoutComponentView {
    private int size;
    private int countPos;
    private String style;

    private int rBoard;	//Внутренний радиус доски
    private int RBoard;	//Внешний радиус доски
    private int rLine;	//Внутренний радиус ленты
    private int RLine;	//Внешний радиус ленты
    private int LLine; 	//Длина ленты
    Circle cbue, cbui, cbde, cbdi, clui, cldi;
    Rectangle re, ri;

    public ConvierView(LeyoutComponentController controller){
        super(controller);
        arrBoard();
    }

    public int countPos(){
        return ((ConvierController)controller()).countPos();
    }

    public void paint() {
        rLine = 12;
        RLine = 16;
        LLine = (int)((controller().S()+10)*countPos()/2 - Math.PI*RLine);
        RBoard = (int) Math.sqrt(Math.pow(controller().S()/2, 2) + Math.pow((20+RLine),2));
        rBoard = (int) Math.sqrt(Math.pow(controller().S()/2, 2) + Math.pow(RLine,2));

        cbue = new Circle(RBoard, RBoard, RBoard);      //circle board up external
        cbui = new Circle(RBoard, RBoard, rBoard);      //circle board up internal
        clui = new Circle(RBoard, RBoard, rLine);       //circle line up internal
        cbde = new Circle(RBoard, RBoard+LLine, RBoard);    //circle board down external
        cbdi = new Circle(RBoard, RBoard+LLine, rBoard);    //circle board down internal
        cldi = new Circle(RBoard,RBoard+LLine, rLine);      //circle line down internal

        re = new Rectangle(RBoard-RLine, RBoard-RLine,RLine*2, LLine+2*RLine); //rectangle external
        re.setArcHeight(2*RLine);
        re.setArcWidth(2*RLine);
        ri = new Rectangle(RBoard - rLine, RBoard,rLine*2, LLine);  //rectangle internal

        this.addActiveElements(cbue, cbui, cbde, cbdi, re, ri, clui, cldi);
    }

    @Override
    public void repaint() {
        int size = controller().S();
        LLine = (int)((controller().S()+10)*countPos()/2 - Math.PI*RLine);
        RBoard = (int) Math.sqrt(Math.pow(controller().S()/2, 2) + Math.pow((20+RLine),2));
        rBoard = (int) Math.sqrt(Math.pow(controller().S()/2, 2) + Math.pow(RLine,2));
        //circle board up external
        cbue.setCenterX(RBoard);
        cbue.setCenterY(RBoard);
        cbue.setRadius(RBoard);
        //circle board up internal
        cbui.setCenterX(RBoard);
        cbui.setCenterY(RBoard);
        cbui.setRadius(rBoard);
        //circle line up internal
        clui.setCenterX(RBoard);
        clui.setCenterY(RBoard);
        clui.setRadius(rLine);
        //circle board down external
        cbde.setCenterX(RBoard);
        cbde.setCenterY(RBoard+LLine);
        cbde.setRadius(RBoard);
        //circle board down internal
        cbdi.setCenterX(RBoard);
        cbdi.setCenterY(RBoard+LLine);
        cbdi.setRadius(rBoard);
        //circle line down internal
        cldi.setCenterX(RBoard);
        cldi.setCenterY(RBoard+LLine);
        cldi.setRadius(rLine);

//        re = new Rectangle(RBoard-RLine, RBoard-RLine,RLine*2, LLine+2*RLine); //rectangle external
        re.setX(RBoard-RLine);
        re.setY(RBoard-RLine);
        re.setWidth(RLine*2);
        re.setHeight(LLine+2*RLine);
//        ri = new Rectangle(RBoard - rLine, RBoard,rLine*2, LLine);  //rectangle internal
        ri.setX(RBoard-rLine);
        ri.setY(RBoard);
        ri.setWidth(rLine*2);
        ri.setHeight(LLine);

    }

    private void arrBoard() {
//        GroupBoard[] arrPos = new GroupBoard[countPos];
//
//        for (int i = 0; i < countPos/2; i++) {
//            arrPos[i] = new GroupBoard(i,"", size,0, size, 90, 0);
//            arrPos[i].setLayoutX(RBoard+34-size/2);
//            arrPos[i].setLayoutY(RBoard-27+(size+10)*i);
//            this.getChildren().addAll(arrPos[i]);
//        }
//
//        for (int i = 0; i < countPos/2; i++) {
//            arrPos[i] = new GroupBoard(i, "", size, 0, size, -90, 0);
//            arrPos[i].setLayoutX(RBoard-36-size/2);
//            arrPos[i].setLayoutY(RBoard+LLine-20-(size+10)*i);
//            this.getChildren().addAll(arrPos[i]);
//        }
    }
}
