package graphics.leftPanel;

import javafx.scene.shape.Rectangle;
import javafx.stage.Popup;

import java.io.IOException;

public class LeftPanel extends Popup {
    Rectangle msgRect;

    public LeftPanel() throws IOException {
        this.setAutoHide(true);
        this.setHideOnEscape(true);
        Rectangle msgRect = new Rectangle( 0, 25, 50, 845);
        msgRect.setStyle("-fx-fill: RGBA(47,79,79,1.0); -fx-stroke: SlateGray; -fx-stroke-width: 0.5");
        IndicateButtonController ibc = new IndicateButtonController(new IndicateButton());

        this.getContent().addAll(msgRect, ibc.view());
    }
}
