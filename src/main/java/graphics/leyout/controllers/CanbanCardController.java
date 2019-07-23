package graphics.leyout.controllers;

import graphics.leyout.components.CanbanCard;
import graphics.leyout.components.CanbanLeaf;
import graphics.leyout.views.CanbanCardView;
import javafx.scene.input.MouseButton;

import java.io.IOException;

public class CanbanCardController extends LeyoutComponentController {

    public CanbanCardController(CanbanCard canbanCard) throws IOException {
        super(canbanCard);
        setView(new CanbanCardView(this));
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

    public int getMaxCountOrder() {
        return ((CanbanCard)component()).getMaxCountOrder();
    }

    public int getFactCountOrder() {
        return ((CanbanCard)component()).getFactCountOrder();
    }

    public int getMaxLeafCountOrder(){
        int maxLeafCntOrd = 2;
        if (component().getParent()!= null){
            maxLeafCntOrd = ((CanbanLeaf) component().getParent()).getMaxLeafCountOrder();
        }
        return maxLeafCntOrd;
    }

}
