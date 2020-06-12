package graphics.leyout.views.productStores;

import graphics.leyout.controllers.LeyoutComponentController;
import graphics.leyout.views.materialStores.MaterialStoreView;

public abstract class ProductStoreView extends MaterialStoreView {

    public ProductStoreView(LeyoutComponentController controller){
        super(controller);
    }


    public abstract void paint();

    @Override
    public abstract void repaint();

}
