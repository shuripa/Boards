package graphics.leftpanel.components;

import sets.SetEmployers;

public class IndexCountEmloyes extends IndexButton {
    public IndexCountEmloyes(String hint, String measure) {
        super(hint, measure);
    }

    @Override
    public void action() {

    }

    @Override
    public void update(){
        SetEmployers employers = SetEmployers.getInstance();
        setIndex(employers.getEmployers().size());
        super.update();
    }
}
