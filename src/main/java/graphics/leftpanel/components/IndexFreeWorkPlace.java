package graphics.leftpanel.components;

import sets.SetWorkPlacedComposits;

public class IndexFreeWorkPlace extends IndexButton {

    public IndexFreeWorkPlace(String hint, String measure) {
        super(hint, measure);
    }

    @Override
    public void action() {

    }

    @Override
    public void update(){
        SetWorkPlacedComposits composits = SetWorkPlacedComposits.getInstance();
        setIndex(composits.getCountFreeWorkPlace());
        super.update();
    }

}
