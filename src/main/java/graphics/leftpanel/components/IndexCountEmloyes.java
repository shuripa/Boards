package graphics.leftpanel.components;

import sets.SetEmployees;

public class IndexCountEmloyes extends IndexButton {
    public IndexCountEmloyes(String hint, String measure) {
        super(hint, measure);
    }

    @Override
    public void action() {

    }

    @Override
    public void update(){
        SetEmployees employers = SetEmployees.getInstance();
        setIndex(employers.getEmployees().size());
        super.update();
    }
}
