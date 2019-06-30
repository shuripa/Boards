package graphics.components;

import graphics.views.ShapeCardCanban;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class GroupLeafCanban extends Group {
    String title;
    ShapeCardCanban[] scc;
    GroupBoardCanban parent;

    public GroupLeafCanban(GroupBoardCanban parent, int x, int y, int cardCnt, String title) {
        this.parent = parent;
        scc = new ShapeCardCanban[cardCnt];
        Line l;
        String sub = "";
        System.out.println(title);
        if (title.length() == 6) {
            sub = title.substring(3, 6);
        } else if (title.length() == 5){
            sub = title.substring(3, 5);
        } else if (title.length() == 4){
            sub = title.substring(1, 4);
        }

        Text textTl, textNo;
        textTl = new Text(20, -2, sub);
        textTl.setFill(Color.rgb(0, 0, 0, 0.6));
        textTl.setStroke(Color.rgb(0,0,0,0.7));
        textTl.setStrokeWidth(0.5);

        textTl = new Text(20, -2, sub);
        textTl.setFill(Color.rgb(0, 0, 0, 0.6));
        textTl.setStroke(Color.rgb(0,0,0,0.7));
        textTl.setStrokeWidth(0.5);

        for (int i = cardCnt; i > 0 ; i--) {
            textNo = new Text(-2, 10*i-2, "" +(cardCnt-i+1));
            textNo.setFont(Font.font(9));
            scc[i-1] = new ShapeCardCanban(this, "" + title + i);
            scc[i-1].relocate(2, 10*(cardCnt-i));
            l = new Line(0, 10*i, 33,10*i);
            l.setStroke(Color.GREY);
            this.getChildren().addAll(scc[i-1], l, textNo);
        }
        l = new Line(0, 0, 0,10*cardCnt);
//        this.getChildren().addAll(l, textTl);
        this.getChildren().add(textTl);
        this.relocate(x, y);

    }

    public GroupBoardCanban getControl(){
        return parent;
    }
    public ShapeCardCanban getCardCanban(int n){
        return scc[n];
//        TODO: разобраться в чем проблема
//        return null;
    }
}
