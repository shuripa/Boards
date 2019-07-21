package graphics.leyout.components;

import graphics.BlankGroup;

public class GroupTest extends BlankGroup {
    int s;

    public GroupTest (Integer id, String dsc, int size, int x, int y, double a){
        super(32, 0, size);
        this.s = size;
//        168, 178

        //тестовочный стол
//        TestTableView tt = new TestTableView(id, dsc, size);
//        LeyoutComponentController controller = new TestTableController(id, dsc, size);
//        TestTableView tt = (TestTableView) controller.view();
//        tt.setXY(200, 200);
//        controller.setXY(32, 22);
//        tt.setXY(32, 22);
//        this.getChildren().add(tt);

        //палета
//        PaletteView tp = new PaletteView();
//        tp.setXY(252, 190);
//        tp.relocate(34 + size, 12);
//        this.getChildren().add(tp);

        //тестовочный канбан
//        TestCanbanView canban = new TestCanbanView();
//        canban.setXY(168, 200);
//        canban.relocate(0, 22);
//        this.getChildren().add(canban);

        //рабочий стол
//        TestWorkTableView workTable = new TestWorkTableView();
//        workTable.setXY(190, 179);
//        workTable.relocate(20, 1);
//        this.getChildren().add(workTable);

        //рабочий
//        WorkPlaceController wp = new WorkPlaceController();
//        wp.setXY(215, 182);
//        wp.setXY(47, 4);
//        wp.setXY(22 + size/2, 4);
//        this.getChildren().add(wp);


//        this.getChildren().addAll(tt, tp, canban, workTable, wp.view());
//        this.relocate(x, y);
//        super.setRotate(a);
    }
}
