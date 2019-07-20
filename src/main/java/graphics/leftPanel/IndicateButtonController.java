package graphics.leftPanel;

import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.controllers.LeyoutComponentController;
import javafx.scene.input.MouseButton;

import java.io.IOException;

public class IndicateButtonController extends LeyoutComponentController {
    public IndicateButtonController(LeyoutComponent index) throws IOException {
        super(index);
        setView(new IndicateButtonView(this));
    }

    @Override
    protected void setComponentProperties() {

    }

    @Override
    public void updateViewData() {

    }

    @Override
    protected void setDragEvent() {

    }

    @Override
    protected void setEventTonExt(MouseButton button) {

    }
}
