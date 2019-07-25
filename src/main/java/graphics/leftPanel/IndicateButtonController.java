package graphics.leftPanel;

import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.controllers.LeyoutComponentController;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Text;
import javafx.stage.Popup;

import java.io.IOException;

public class IndicateButtonController extends LeyoutComponentController {

    Popup pp;

    public IndicateButtonController(LeyoutComponent index) throws IOException {
        super(index);
        setView(new IndicateButtonView(this));
        pp =new Popup();
        pp.setAutoHide(true);
        Text text = new Text("Ефективність розміщення працівників");
        pp.getContent().add(text);
    }

    @Override
    protected void setComponentProperties() {

    }

    @Override
    protected void setDragEvent() {

    }

    @Override
    protected void setEventTonExt(MouseButton button) {

    }

    public void viewEvents() throws IOException {
        super.viewEvents();
        view().setOnMouseEntered(mouseEvent -> {
            select();
            pp.show(view(), 55, 40);
        });
        view().setOnMouseExited(mouseEvent -> {
            unselect();
            pp.hide();
        });
    }

    public int getMediumEffectivity(){
        return (int)Math.ceil(((IndicateButton)component()).getSumEffectivity() /((IndicateButton)component()).getCountWorkPlace());
    }
}
