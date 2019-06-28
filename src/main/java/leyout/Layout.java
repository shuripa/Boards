package leyout;

import javafx.scene.layout.Region;
import leyout.components.*;
import leyout.controllers.*;
import sets.BoardsController;

import java.util.ArrayList;

public class Layout extends Region {

    private static Layout layout = null;
    private ArrayList<GroupBoard> arrBoards;
    private CanbanController cc;
    private BoardsController bc;

    public ArrayList<GroupBoard> getArrBoards() {
        return arrBoards;
    }

    public static Layout getInstace(){
        if (layout == null){
            layout = new Layout();
        }
        return layout;
    }

    private Layout(){
//        leyerToConnection();
//        canbanController();
//        createArrBoards();
//        boards189and059();
//        loadOrders();
//        GroupBoard bg1 = board029();
//        GroupBoard bg2 = board317(bg1);
//        GroupBoard bg3 = board771();
//        boardsVT1andVT2();
//        board246();
//        CompositBoardController gbc1 = CompositBoard082();
//        LoadMaterialToGrid(gbc1);


//Переробка елементів дошки
        Board b = new Board();
        b.setTitle("KM 082");
        b.setId(1901);
        b.setCondition("MFC1841082***");

        BoardController bc = new BoardController(b);
        bc.setXYAS(0, 27 , 0, 60);
        this.getChildren().add(bc.view());

        Human h = new Human();
        h.setLogining(12713);

        HumanController hc = new HumanController(h);
        hc.setXY(20, 7);
        this.getChildren().add(hc.view());

        Grid g = new Grid();
        GridController gc = new GridController(g);
        gc.setXYAS(0, 0, 0, 60);
        this.getChildren().add(gc.view());

        BoardIndex i = new BoardIndex();
        i.setProc(70);
        BoardIndexController ic= new BoardIndexController(i);
        ic.setXY(55, 27);
        this.getChildren().add(ic.view());

//        Переробка дошки v.3
        CompositBoard cb = new CompositBoard();
        cb.setTitle("KM 034");
        cb.setId(1902);
        cb.setCondition("MFC1841034***");
        cb.setLogining(12715);
        cb.setProc(50);
        CompositBoardController cbc = new CompositBoardController(cb);
        cbc.setXYAS(100, 100, 0, 90);
        this.getChildren().add(cbc.view());

//        CompositBoard cb = new CompositBoard();

//        MAO
        CompositMao cm = new CompositMao();
        cm.setTitle("MAO-01");
        cm.addCondition("MFC1841082***");
//        cm.addLeaf(gbc1.getCompositBoard());
        CompositMaoController cmc = new CompositMaoController(cm);
        cmc.setXYAS(630, 218, -45, 0);
        this.getChildren().add(cmc.view());

//        canbans();
//        testTables(bg1, bg2, bg3);
//        Conviers();
//        Blanks();
//        pushChart();

    }

    private void pushChart() {
//        //        Працівник з візком
//        GroupPushcart gp = new GroupPushcart(700,200,0);
//        this.getChildren().addAll(gp);
    }

    private void Blanks() {
        //        Заготовки
//        GroupBlank gb1 = new GroupBlank("1211", "VT 04 Li", 60, 15, 180, 180, 60);
//        GroupBlank gb2 = new GroupBlank("1212", "VT 04 Li", 60, 100, 180, 180, 90);
//        getChildren().addAll(gb1, gb2);
    }

    private void Conviers() {
//        //        Конвеєра
//        ShapeConvier sc = new ShapeConvier(60,6);
//        sc.setXY(290, 0);
//        getChildren().add(sc);
//        ShapeConvier sc2 = new ShapeConvier(80,8);
//        sc2.setXY(440, 0);
//        getChildren().add(sc2);
    }

    private void testTables(GroupBoard bg1, GroupBoard bg2, GroupBoard bg3) {
//        //        Тестувальні столи
////        Тестувальний стіл 1
//        GroupTest gt1 = new GroupTest("1520", "KM-15", 40, 5, 250, 0);
//        getChildren().add(gt1);
//        gt1.nEnt.addNode(bg1.getExt());
//        gt1.nEnt.addNode(bg2.getExt());
//        gt1.nEnt.addNode(bg3.getExt());
//
//        getChildren().add(new GroupTest("1521", "KM-18", 50, 113, 250, 0));
//        getChildren().add(new GroupTest("1522", "KM-21", 100, 230, 250, 0));
//        getChildren().add(new GroupTest("1523", "KM-21", 60, 327, 340, 90));
    }

    private void canbans() {
//        //        Канбани
////        cc = new CanbanController();
//
//        cc.addCanban(10, 550, 4, 4, "16D");
//        cc.addCanban(160, 550, 7, 4, "01F");
//        cc.addCanban(415, 550, 7, 4, "13O");
//        cc.addCanban(10, 650, 7, 4, "14O");
//        cc.addCanban(265, 650, 7, 4,"15O");
//        cc.addCanban(520, 650, 7, 4,"16O");
//        cc.addCanban(760, 550, 7, 4,"17O");
//        cc.addCanban(835, 650, 7, 4,"18O");
//        cc.addCanban(10, 720, 30, 8,"A");
//        getChildren().addAll(cc.getCanbans());
    }

    private void LoadMaterialToGrid(CompositBoardController gbc1) {
//        //        Завантаження матеріалу на сітку
//
//        try {
//            GridMaterialLoader gml = new GridMaterialLoader(arrBoards);     //Стара дошка
//            gbc1.setMaterials(gml.getMaterials(gbc1.getTitle()));           //Нова дошка
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private CompositBoardController CompositBoard082() {
//        //        Перероблені дошки v2
//        CompositBoardController gbc1 = new CompositBoardController(1900, "KM-xxx", 60, 600, 200, 0);
////        TODO: можно ли добалять к лейауту не тут а в наборе?
////         - Можно создав в наборе процедуру добавления всех элементов и передав ей лейаут параметром
//        this.getChildren().add(gbc1.getView());
////        Властивості
////        TODO: переделать в свойства
//        gbc1.setId(1990);
//        gbc1.setTitle("KM 082");
//        gbc1.setCondition("MFC1841082***");
////        Замовлення
////        TODO: Заказы добавляются - не к CompositBoard, - не к Индексу а к МАО
//        gbc1.addOrder(new Order(21116, "MFC184108200A", 8, 148.57));
//        gbc1.addOrder(new Order(21117, "MFC1841082A0A", 4, 178.24));
//        gbc1.addOrder(new Order(21118, "MFC1841082L0A", 47, 188.13));
////        Логування
//        gbc1.setLogining(14417);
////        Додавання дошки в набор
//        BoardsController.getInstance().addGroupBoardController(gbc1);
//        return gbc1;
        return null;
    }

    private void board246() {
//        GroupBoard x = new GroupBoard(2119, "KM 246", 60, 125, 70, 90, 1);
//        arrBoards.add(x);
//        getChildren().add(x);
//        x = new GroupBoard(1232,"KM 230",90, 15, 130, 0, 0);
//        arrBoards.add(x);
//        getChildren().add(x);
    }

    private void boardsVT1andVT2() {
//        //        Інші дошки
//        GroupBoard vt01 = new GroupBoard(2116, "VT 01", 60, 80, 8, -90, 85);
//        vt01.setCondition("1FC3L*01*****");
//        GroupBoard vt02 = new GroupBoard(2118, "VT 02", 60, 125, 8, 90, 50);
//        vt02.setCondition("1FC3L*02*****");
//        arrBoards.add(vt01);
//        arrBoards.add(vt02);
//        getChildren().addAll(vt01, vt02);
    }

    private GroupBoard board771() {
//        //        Дошка 3
//        GroupBoard bg3 = new GroupBoard(2117, "KM 771", 60, 80, 70, -90, 50);
//        arrBoards.add(bg3);
//        bg3.setCondition("MFC1847771***");
//        getChildren().add(bg3);
//        return bg3;
        return null;
    }

    private GroupBoard board317(GroupBoard bg1) {
//        //         Дошка 2
//        GroupBoard bg2 = new GroupBoard(1311, "KM 317", 60, 15, 0, 0, 0);
//        arrBoards.add(bg2);
////        Умова
//        bg2.setCondition("MFC1802317***");
//        this.getChildren().addAll(bg1, bg2);
//        return bg2;
        return null;
    }

    private GroupBoard board029() {
//        //Дошка 1
//        GroupBoard bg1 = new GroupBoard(1271, "KM 029", 60, 15, 55, 0, 180);
//        arrBoards.add(bg1);
//        //Логування
//        bg1.setLoginning(12700);
//        //Умова
//        bg1.setCondition("MFC1847029***");
//
//        //Список замовлень
//        ArrayList orders = new ArrayList<>();
//        Order ord1 = new Order(21100, "1FC3LA02004B0", 20, 23.15);
//        Order ord2 = new Order(21115, "1FC3LC02004B0", 30, 25.15);
//        orders.add(ord1);
//        orders.add(ord2);
//        bg1.setOrd(orders);
//        return bg1;
        return null;
    }

    private void loadOrders() {
        //        Завантаження замовлень

//        GroupBoardCanban gbc2 = new GroupBoardCanban(230, 450, 6, "12M");
//        GroupBoardCanban gbc3 = new GroupBoardCanban(450, 450, 6, "13M");
//        getChildren().addAll(gbc1, gbc2, gbc3);
    }

    private void boards189and059() {
//        //        Переработка подхода к созданию досок
//        bc = BoardsController.getInstance();
//        bc.addBoard(1441, "KM 189", 600, 0, 60, 0); // Li/Cb LOL
//        bc.addBoard(1459, "KM 059", 600, 45, 60, 180); // Cb LOL
//        this.getChildren().addAll(bc.getArrBoards());
////        добавления условий addConditions
//        bc.setCondition(1441, "MFC184*189***");
//        bc.setCondition(1459, "MFC1847059***");
////        Завантаження матеріалу на сітку
//        try {
//            GridMaterialLoader gmlnew = new GridMaterialLoader(bc.getArrBoards());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private void createArrBoards() {
//        //      TODO: привести в порядок дошки
////        Масив дошок
//        arrBoards = new ArrayList<>();
    }

    private void canbanController() {
//        //        TODO: канбан контроллер нужно сделать не синглтоном, а зависящим от стока и от лейаута
////        Канбан контроллер
//        cc = CanbanController.getInstance();
    }

    private void leyerToConnection() {
//        //        Слой для соединений  // LineLayer to Connections
//        GroupLine gLine = GroupLine.getInstance();
//        getChildren().add(gLine);
    }
}
