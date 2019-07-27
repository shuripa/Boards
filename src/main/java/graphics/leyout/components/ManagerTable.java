package graphics.leyout.components;

import model.Side;

public class ManagerTable extends LeyoutComponent {

    Side side;

    public ManagerTable(LeyoutComponent parent, Side side){
        setParent(parent);
        this.side = side;

    }

    @Override
    public String toString() {
        return "";
    }

    public Side getSide() {
        return side;
    }
}
