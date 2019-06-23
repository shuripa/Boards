package leyout.wievs;

import javafx.scene.input.MouseButton;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import leyout.LeyoutComponentWiev;
import leyout.controllers.BoardController;
import leyout.LeyoutComponentController;
import leyout.elements.Board;

public class BoardView extends LeyoutComponentWiev {

    private int size;
    Text tt, ti;

    public BoardView(BoardController controller, int size){
        super(controller, size);
    }

    public BoardView(LeyoutComponentController controller) {
        super(controller);

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

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public void reset() {
        tt.setText("" + ((Board)getController().element()).getTitle());
        ti.setText("" + ((Board)getController().element()).getId());
    }

    public void paint(){

        Rectangle rb = new Rectangle(size-5,20);                                //Rectangle Board
            rb.relocate(.5,.5);
        Line l = new Line(1, 9.5, size-6, 9.5);                         //Split line in board

        tt = new Text("" + ((Board)getController().element()).getTitle());     //Text title
//            td.relocate(4,18);
        tt.setX(4);
        tt.setY(18);

        ti = new Text("" + ((Board)getController().element()).getId());        //Text ID
//            ti.relocate(2, 8);
        ti.setX(2);
        ti.setY(8);

        addActiveElements(rb, l);
        addTexts(tt, ti);
    }

    public void setTt(String title){
        this.tt.setText(title);
    }

    @Override
    public void showInfo() {

    }


//    public void select() {
//        super.entered();
//    }

//    public void unseltct() {
//        super.exited();
//    }


}