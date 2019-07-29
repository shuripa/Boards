package graphics.leftPanel;

import javafx.scene.shape.Rectangle;
import javafx.stage.Popup;

import java.io.IOException;

public class LeftPanel extends Popup {
    Rectangle msgRect;

    public LeftPanel() throws IOException {
        this.setHideOnEscape(true);

//        Group root = new Group();
//        root.relocate(0, 25);

        Rectangle msgRect = new Rectangle( 0, 25, 50, 845);
        msgRect.setStyle("-fx-fill: RGBA(47,79,79,1.0); -fx-stroke: SlateGray; -fx-stroke-width: 0.5");

        BindControlButtonController bbc = new BindControlButtonController(new BindControlButton(this));
        bbc.setXY(37, 28);
        setAutoHide(true);

        IndicateButtonController ibc = new IndicateButtonController(new IndicateButton());
        ibc.setXY(0, 35);

//        root.getChildren().addAll(msgRect, bbc.view(), ibc.view());
//        this.getContent().addAll(root);
        getContent().addAll(msgRect, bbc.view(), ibc.view());

    }


}
