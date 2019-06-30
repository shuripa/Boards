package graphics.components;

import graphics.BlankGroup;

public class GroupTest extends BlankGroup {
    int s;

    public GroupTest (Integer id, String dsc, int size, int x, int y, double a){
        super(32, 0, size);
        this.s = size;
//        168, 178

        //тестовочный стол
//        ShapeTestTable tt = new ShapeTestTable(id, dsc, size);
//        LeyoutComponentController controller = new TestTableController(id, dsc, size);
//        ShapeTestTable tt = (ShapeTestTable) controller.view();
//        tt.setXY(200, 200);
//        controller.setXY(32, 22);
//        tt.setXY(32, 22);
//        this.getChildren().add(tt);

        //палета
//        ShapePalete tp = new ShapePalete();
//        tp.setXY(252, 190);
//        tp.relocate(34 + size, 12);
//        this.getChildren().add(tp);

        //тестовочный канбан
//        ShapeCanban tc = new ShapeCanban();
//        tc.setXY(168, 200);
//        tc.relocate(0, 22);
//        this.getChildren().add(tc);

        //рабочий стол
//        ShapeWorkTable wt = new ShapeWorkTable();
//        wt.setXY(190, 179);
//        wt.relocate(20, 1);
//        this.getChildren().add(wt);

        //рабочий
//        HumanController h = new HumanController();
//        h.setXY(215, 182);
//        h.setXY(47, 4);
//        h.setXY(22 + size/2, 4);
//        this.getChildren().add(h);


//        this.getChildren().addAll(tt, tp, tc, wt, h.view());
//        this.relocate(x, y);
//        super.setRotate(a);
    }
}
