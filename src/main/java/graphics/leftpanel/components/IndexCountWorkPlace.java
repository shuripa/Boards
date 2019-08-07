package graphics.leftpanel.components;

import sets.SetWorkPlacedComposits;

public class IndexCountWorkPlace extends IndexButton {
    public IndexCountWorkPlace(String hint, String measure) {
        super(hint, measure);
    }

    @Override
    public void action() {

    }

    @Override
    public void update(){
        SetWorkPlacedComposits composits = SetWorkPlacedComposits.getInstance();
        setIndex(composits.getCountWorkPlace());
        super.update();
    }
}
