package graphics.leyout.controllers;

import graphics.leyout.components.CanbanCard;
import graphics.leyout.components.CanbanLeaf;
import graphics.leyout.views.CanbanCardView;

import java.io.IOException;

public class CanbanCardController extends LeyoutComponentController {

    public CanbanCardController(CanbanCard canbanCard) throws IOException {
        super(canbanCard);
        setView(new CanbanCardView(this));

    }

    @Override
    protected void setComponentProperties() {

    }


    public int getMaxCountOrder() {
        return ((CanbanCard)component()).getMaxCountOrder();
    }

    public int getFactCountOrder() {
        return ((CanbanCard)component()).getFactCountOrder();
    }

    public int getMaxLeafCountOrder(){
        int maxLeafCntOrd = 2;
        if (component().parent()!= null){
            maxLeafCntOrd = ((CanbanLeaf) component().parent()).getMaxLeafCountOrder();
        }
        return maxLeafCntOrd;
    }

    @Override
    public void update(){
        super.update();
        if (((CanbanCard)component()).getStore() == null){
            activate();
        } else {
            setHint(((CanbanCard) component()).getStore().toString());
        }
    }

//    @Override
//    public void viewEvents() throws IOException {
//        super.viewEvents();
//
//        view().setOnMouseClicked(mouseEvent -> {
////            String s = "";
////            s = s +((CanbanCard)component()).getCardInd();
////            s = " " + s +((CanbanCard)component()).getMaterial();
////            s = " " + s +((CanbanCard)component()).getCount();
////            Popup hint = new Popup();
//            Store s = ((CanbanCard)component()).getStore();
//            if (s != null) {
//                System.out.println(s.toString());
//                setHint(s.toString());
//                showHint((int)Math.ceil(mouseEvent.getX()), (int)Math.ceil(mouseEvent.getY()));
//            }
//
////            if (mouseEvent.getButton() == MouseButton.SECONDARY) {
////            }
//
////            if (mouseEvent.getClickCount() == 2){
////            }
//        });
//    }

}
