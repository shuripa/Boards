package graphics.components;

import graphics.controllers.CanbanController;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class GroupBoardCanban extends Group {

    public CanbanController getControl() {
        return parent;
    }

    CanbanController parent;
    String title;
    GroupLeafCanban[] glc;
    int cnt;

    public GroupBoardCanban(CanbanController parent, int x, int y, int blockCnt, int cardCnt, String title){
        String titleNext ;
        this.parent = parent;
        GroupLeafCanban[] glc = new GroupLeafCanban[blockCnt];
        this.title = title;
        cnt = blockCnt;
        for (int i = 0; i < cnt; i++) {
            if ((title.length() == 1) && (i + 1 < 10)){
                    titleNext = "0" + (i + 1);
            } else {
                    titleNext = "" + (i + 1);
            }
//            glc[i] = new GroupLeafCanban(this, i*35, y, cardCnt, "" + title + "" + titleNext + "-");
            glc[i] = new GroupLeafCanban(this, i*35, y, cardCnt, "" + title + "" + titleNext + "-");

            this.getChildren().add(glc[i]);
        }
        paint(x, y);
    }

    private void paint(int x, int y) {
        Text text = new Text(-2,  y+13, title);
        text.setFill(Color.rgb(0, 0, 0, 0.3));
        text.setStroke(Color.rgb(0,0,0,0.7));
        text.setStrokeWidth(0.5);

        Rectangle rect = new Rectangle(0, 0, 254, 45);
        rect.setStyle("-fx-fill: RGBA(255,255,255,0.0)");
        rect.setStroke(Color.GREY);

        this.relocate(x, y);
        this.getChildren().add(text);

    }

    public GroupLeafCanban getLeafCanban(int i){
        return (GroupLeafCanban) getChildren().get(i);
    }

}
