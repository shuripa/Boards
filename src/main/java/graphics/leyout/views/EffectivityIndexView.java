package graphics.leyout.views;

import graphics.leftpanel.LeftPanel;
import graphics.leyout.controllers.EffectivityIndexController;
import javafx.scene.text.Text;

public class EffectivityIndexView extends LeyoutComponentView {

    Text text;

    public EffectivityIndexView(EffectivityIndexController controller) {
        super(controller);
        text = new Text();
        text.setOnMouseEntered(mouseEvent -> {
            LeftPanel lp = LeftPanel.getInstance();
            lp.show(this, 0, 0);
        });

        addText(text);
    }

    @Override
    public void paint() {
        text.relocate (0, 0);
    }

    @Override
    public void repaint() {

    }

    public void setText(String text) {
        this.text.setText(text);
    }
}
