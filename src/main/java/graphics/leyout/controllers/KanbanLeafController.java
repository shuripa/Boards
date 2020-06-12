package graphics.leyout.controllers;

import graphics.leyout.components.KanbanLeaf;
import graphics.leyout.components.KanbanSection;
import graphics.leyout.views.KanbanLeafView;

import java.io.IOException;

public class KanbanLeafController extends LeyoutComponentController {

    public KanbanLeafController(KanbanLeaf kanbanLeaf) throws IOException {
        super(kanbanLeaf);
        setView(new KanbanLeafView(this));

    }

    @Override
    protected void setComponentProperties() {

    }


    public int getMaxCountOrder() {
        return ((KanbanLeaf)component()).getCountCards();
    }

    public int getFactCountOrder() {
        return ((KanbanLeaf)component()).getRestCards();
    }

    public int getMaxLeafCountOrder(){
        int maxLeafCntOrd = 2;
        if (component().parent()!= null){
            maxLeafCntOrd = ((KanbanSection) component().parent()).getMaxLeafCountOrder();
        }
        return maxLeafCntOrd;
    }

    @Override
    public void update(){
        super.update();
        if (((KanbanLeaf)component()).getStore() == null){
            activate();
        } else {
            setHint(((KanbanLeaf) component()).getStore().toString());
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
