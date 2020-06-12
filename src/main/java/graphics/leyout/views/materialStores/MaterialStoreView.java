package graphics.leyout.views.materialStores;

import graphics.leyout.controllers.LeyoutComponentController;
import graphics.leyout.views.LeyoutComponentView;
import javafx.scene.shape.Rectangle;

public abstract class MaterialStoreView extends LeyoutComponentView {
    Rectangle rb, rl, rr;

    public MaterialStoreView(LeyoutComponentController controller){
        super(controller);
    };

    @Override
    public abstract void paint();


    @Override
    public abstract void repaint();

}
