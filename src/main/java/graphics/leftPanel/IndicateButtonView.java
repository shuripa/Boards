package graphics.leftPanel;

import graphics.leyout.controllers.LeyoutComponentController;
import graphics.leyout.views.LeyoutComponentView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class IndicateButtonView extends LeyoutComponentView {

    public IndicateButtonView(LeyoutComponentController controller) {
        super(controller);
    }

    @Override
    public void paint() {
        Circle indEffectivs = new Circle(25, 50, 23);
        indEffectivs.setStyle("-fx-fill: RGBA(47,79,79,1.0); -fx-stroke: DarkGray; -fx-stroke-width: 0.7");
        Text text1 = new Text("100%");
        text1.setStyle("-fx-font-style: italic; -fx-font-size: 9; -fx-stroke: LightGray");
        text1.relocate(9, 31);
        Text text2 = new Text ("105 %");
        text2.relocate(17, 50);
        text2.setStyle("-fx-font-style: italic; -fx-font-size: 9; -fx-stroke: LightGray" );
        Line l = new Line(10, 60, 40, 40);
        l.setStrokeWidth(2);
        l.setStyle("-fx-stroke: DarkGray;");
        addActiveElements(indEffectivs, l);
        addTexts(text1, text2);
    }

    @Override
    public void repaint() {

    }
}
