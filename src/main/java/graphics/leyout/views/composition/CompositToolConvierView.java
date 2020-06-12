package graphics.leyout.views.composition;

import graphics.leyout.controllers.*;

public class CompositToolConvierView extends CompositToolView {

    private int RBoard;	//Внешний радиус доски
    private int RLine;	//Внешний радиус ленты
    private int LLine; 	//Длина ленты

    public CompositToolConvierView(LeyoutWorkPlacedController controller){
        super(controller);
    }

    @Override
    public void paint() {
        RLine = 16;
        LLine = (int)((countPos()*(controller().S()+10))/2 - Math.PI*RLine);
        RBoard = (int) Math.sqrt(Math.pow(controller().S()/2, 2) + Math.pow((20+RLine),2));

        ToolConvierController cc = ((CompositToolConvierController)controller()).getConvierController();
        cc.setXYAS(0, 0 ,0, controller().S());
//        cc.setS(controller().S());
        this.getChildren().add(cc.view());

        for (int i = 0; i < countPos(); i++) {
            CompositBoardController cv = ((CompositToolConvierController)controller()).getCompositBoardController(i);
            if (i < countPos()/2) {
                cv.setXYAS(Math.round(RBoard+34-controller().S()/2), Math.round(RBoard-27+(controller().S()+10)*i), 90, controller().S());
            } else {
                int X = Math.round(RBoard-36-controller().S()/2);
                int Y = Math.round(RBoard+LLine-20-(controller().S()+10)*i);
                cv.setXYAS(Math.round(RBoard-36-controller().S()/2), Math.round(RBoard+LLine-20-(controller().S()+10))*i, -90, controller().S());
            }
            this.getChildren().add(cv.view());
        }
    }

    @Override
    public void repaint() {
        RLine = 16;
        LLine = (int)((countPos()*(controller().S()+10))/2 - Math.PI*RLine);
        RBoard = (int) Math.sqrt(Math.pow(controller().S()/2, 2) + Math.pow((20+RLine),2));
        ToolConvierController cc = ((CompositToolConvierController)controller()).getConvierController();
        cc.setXYAS(0, 0, 0, controller().S());
        for (int i = 0; i < countPos(); i++) {
            CompositBoardController cv = ((CompositToolConvierController)controller()).getCompositBoardController(i);
            if (i < countPos()/2) {
                cv.setXYAS(Math.round(RBoard-35+controller().S()/2), Math.round(RBoard-27+(controller().S()+10)*i), 90, controller().S());
            } else {
                int X = RBoard-35-controller().S()/2;
                int Y = RBoard+LLine-20-(controller().S()+10)*(i-countPos()/2);
                System.out.println("RBoard = " + RBoard + ", LLine = " + LLine + ", X = " + X + ", Y = " + Y);
                cv.setXYAS(RBoard-36-controller().S()/2, RBoard+LLine-20-(controller().S()+10)*(i-countPos()/2), -90, controller().S());
            }
        }

    }

    public int countPos(){
        return ((CompositToolConvierController)controller()).countPos();
    }
}
