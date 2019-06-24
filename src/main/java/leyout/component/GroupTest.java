package leyout.component;

import leyout.controllers.HumanController;
import leyout.controllers.LeyoutComponentController;
import leyout.controllers.TestTableController;
import leyout.views.ShapeCanban;
import leyout.views.ShapePalete;
import leyout.views.ShapeTestTable;
import leyout.views.ShapeWorkTable;
import leyout.BlankGroup;

public class GroupTest extends BlankGroup {
    int s;

    public GroupTest (String id, String dsc, int size, int x, int y, double a){
        super(32, 0, size);
        this.s = size;
//        168, 178

        //тестовочный стол
//        ShapeTestTable tt = new ShapeTestTable(id, dsc, size);
        LeyoutComponentController controller = new TestTableController(Integer.parseInt(id), dsc, size);
        ShapeTestTable tt = (ShapeTestTable) controller.getWievAsNode();
//        tt.relocate(200, 200);
        controller.relocate(32, 22);
//        tt.relocate(32, 22);
//        this.getChildren().add(tt);

        //палета
        ShapePalete tp = new ShapePalete();
//        tp.relocate(252, 190);
        tp.relocate(34 + size, 12);
//        this.getChildren().add(tp);

        //тестовочный канбан
        ShapeCanban tc = new ShapeCanban();
//        tc.relocate(168, 200);
        tc.relocate(0, 22);
//        this.getChildren().add(tc);

        //рабочий стол
        ShapeWorkTable wt = new ShapeWorkTable();
//        wt.relocate(190, 179);
        wt.relocate(20, 1);
//        this.getChildren().add(wt);

        //рабочий
        HumanController h = new HumanController();
//        h.relocate(215, 182);
        h.relocate(47, 4);
        h.relocate(22 + size/2, 4);
//        this.getChildren().add(h);


        this.getChildren().addAll(tt, tp, tc, wt, h.getWievAsSuper());
        this.relocate(x, y);
        super.setRotate(a);
    }
}
