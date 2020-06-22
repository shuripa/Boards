package graphics.leyout.controllers;

import graphics.leyout.components.KanbanLeaf;
import graphics.leyout.components.KanbanSection;
import graphics.leyout.views.KanbanLeafView;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KanbanLeafController extends LeyoutComponentController {
    private static final Logger logger = Logger.getLogger("MainApp");
    public KanbanLeafController(KanbanLeaf kanbanLeaf) throws IOException {
        super(kanbanLeaf);
        logger.log(Level.FINE, kanbanLeaf.toString());
        setView(new KanbanLeafView(this));
    }

    @Override
    protected void setComponentProperties() {

    }


    public int getMaxCountOrder() {
        return ((KanbanLeaf)component()).cntCard();
    }

    public int getFactCountOrder() {
        return ((KanbanLeaf)component()).cntJoined();
    }

    public int getMaxLeafCountOrder(){
        int maxLeafCntOrd = 2;
        if (component().parent()!= null){
            maxLeafCntOrd = ((KanbanSection) component().parent()).getMaxLeafCountOrder();
        }
        return maxLeafCntOrd;
    }

//    Все начинается тут. Контроллер листа запрашивает Store у компонента, который передает запрос про цепочке к KanbanBoard,
//    который возвращает Store по той же цепочке обратно и контроллер использует Store.toString для передачи подсказке.
//    Печатается содержимоге всего склада.
    @Override
    public void update(){
        super.update();
        if (((KanbanLeaf)component()).getStore() == null){
            activate();
            setHint (component().toString());
        } else {
            setHint (component().toString());
        }
        logger.log(Level.FINE, "hint: " + component().toString());
    }

    public int ordered() {
        return ((KanbanLeaf)component()).cntOrdered();
    }

    public int joined() {
        return ((KanbanLeaf)component()).cntJoined();
    }

    public int freed() {
        return ((KanbanLeaf)component()).cntFreed();
    }

    public String getMaterial() {
        return ((KanbanLeaf)component()).material();
    }

    public boolean orderIsStarted() {
        return ((KanbanLeaf)component()).isStarted();
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
