package graphics.leyout.views.workPlaces;

import graphics.leyout.controllers.LeyoutComponentController;
import graphics.leyout.views.LeyoutComponentView;

public abstract class ToolPositionView extends LeyoutComponentView {

    public ToolPositionView(LeyoutComponentController controller){
        super(controller);
    }

    @Override
    public abstract void paint();

    @Override
    public abstract void repaint();

    public abstract void setText(String t);
}