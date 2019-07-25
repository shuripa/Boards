package graphics;

import graphics.leyout.components.*;
import graphics.leyout.controllers.*;
import inout.EmployesCsvLoader;
import inout.SkillCsvLoader;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.KeyCode;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Region;
import model.Condition;
import panes.PropertyPane;
import panes.RightPanel;
import sets.BoardsController;
import sets.MAOSystem;

import java.io.IOException;
import java.util.ArrayList;

public class Layout extends Region {

    private static Layout layout = null;
    private BoardsController bc;
    private int cx, cy, dx, dy, ndx, ndy;                           //dragget coordinate
    private LeyoutComponentController dComponentController;         //dragget controller
    private ArrayList<LeyoutComponentController> targetComponentControllers; // target components;
    private LeyoutComponentController enteredComponentController;         // target components;
    private CompositBoard cb;
    CompositBoardController cbc;
    private TextInputControl t;                                 //Текстове поле для введення значень властивостей компонентів на лейауті


    public static Layout getInstace() throws IOException {
        if (layout == null){
            layout = new Layout();
        }
        return layout;
    }

    private Layout() throws IOException {
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
        EmployesCsvLoader employes = EmployesCsvLoader.getInstance();                   // Загрузка работников
        SkillCsvLoader scl = null;                                                      // Загрузка скилов
        try {
            scl = new SkillCsvLoader(employes.getArrEmp());
        } catch (IOException e) {
            e.printStackTrace();
        }

//        MAO_begin
//        TODO: Умови для МАО можуть складатись з умов дошок які входять в МАО
        MAOSystem maoSystem = MAOSystem.getInstance();

        CompositMao cm = new CompositMao();
        cm.setTitle("UO_MB23");
        cm.addCondition("MFC1847087***");
        cm.addCondition("MFC1847034***");
        maoSystem.addCompositMao(cm);
        CompositMaoController cmc = new CompositMaoController(cm);
        cmc.setXYAS(135, 145, -45, 0);

        CompositMao cm1 = new CompositMao();
//        TODO При неправильній назві завантажуються замовлення відповідно до назви
//        TODO При відсутності замовлень система падає
        cm1.setTitle("UO_MB12");
        cm1.addCondition("MFC1802012***");
        cm1.addCondition("MFC1802317***");
        cm1.addCondition("MFC1847164***");
        maoSystem.addCompositMao(cm1);
        CompositMaoController cmc1 = new CompositMaoController(cm1);
        cmc1.setXYAS(230, 145, -45, 0);

//        cm.addLeaf(gbc1.getCompositBoard());


//        Переробка дошки v.3
//        TODO: перевести всі властивості в String
//        TODO: всі маніпуляції з властивостями по типу отримання робочого по ID або додавання контролеру в масив заховати в середину відповідних класів
        cb = new CompositBoard();
        cb.setTitle("KM 034Cb");
        cb.setId("1902");
        cb.setCondition(new Condition("MFC1847034***", 110));
        cb.setProc(50);
        cbc = new CompositBoardController(cb);
        cb.logining(employes.getEmployerByID("12630"));
        cbc.setXYAS(100, 100, 0, 90);
//        SetComponentControllers.getInstance().addComponentController(cbc);
        this.getChildren().add(cbc.view());
        cm.addBoard(cb);
        cb.getBoardIndex().update();

//        Переробка дошки v.3
        cb = new CompositBoard();                                           //Не грузится из файла
        cb.setTitle("KM 087Cb");                                            //Файл данных
        cb.setId("1903");                                                     //Файл данных
        cb.setCondition(new Condition("MFC1847087***", 110));                                   //Файл условий
        cb.setProc(50);                                                     //Не грузится из файла
        cbc = new CompositBoardController(cb);                              //Не грузится из файла
        cb.logining(employes.getEmployerByID("12700"));                    //Файл логирования
        cbc.setXYAS(100, 150, -180, 90);                   //Файл размеров
//        SetComponentControllers.getInstance().addComponentController(cbc);
        this.getChildren().add(cbc.view());
        cm.addBoard(cb);                                                    //Файл связей
        cb.getBoardIndex().update();

        cb = new CompositBoard();
        cb.setTitle("KM 317Cp");
        cb.setId("1904");
        cb.setCondition(new Condition("MFC1802317***", 110));
        cb.setProc(50);
        cbc = new CompositBoardController(cb);
        cb.logining(employes.getEmployerByID("13710"));
        cbc.setXYAS(195, 100, 0, 90);
//        SetComponentControllers.getInstance().addComponentController(cbc);
        this.getChildren().add(cbc.view());
        cm1.addBoard(cb);
        cb.getBoardIndex().update();

        cb = new CompositBoard();
        cb.setTitle("KM 164Cb");
        cb.setId("1905");
        cb.setCondition(new Condition("MFC1847164***", 110));
        cb.setProc(50);
        cbc = new CompositBoardController(cb);
        cb.logining(employes.getEmployerByID("13003"));
        cbc.setXYAS(195, 150, -180, 90);
//        SetComponentControllers.getInstance().addComponentController(cbc);
        this.getChildren().add(cbc.view());
        cm1.addBoard(cb);
        cb.getBoardIndex().update();

        setEvents();

//        MAO_end
//        SetComponentControllers.getInstance().addComponentController(cmc);
        this.getChildren().add(cmc.view());
        this.getChildren().add(cmc1.view());

//        Test table

        CompositTestTable comptest = new CompositTestTable();
        comptest.setId("1525");
        comptest.setTitle("KM-25");
        comptest.setCondition(new Condition ("MFC1847164***", 120));
        CompositTestTableController compTestController = new CompositTestTableController(comptest);
        compTestController.setXYAS(100, 15, 0, 60);
        this.getChildren().add(compTestController.view());

//        Pushcart

        CompositPushcart compositPushcart = new CompositPushcart();
        compositPushcart.setId("0001");
        compositPushcart.setTitle("PC01");
        CompositPushcartController compositPushcartController = new CompositPushcartController(compositPushcart);
        compositPushcartController.setXYAS(360, 130, 0, 0);
        this.getChildren().add(compositPushcartController.view());

//        Conviers()

        CompositConvier compositConvier = new CompositConvier(8);
        CompositConvierController compositConvierController = new CompositConvierController(compositConvier);
        compositConvierController.setXYAS(470, 20, 0, 60);
        this.getChildren().add(compositConvierController.view());

        CompositConvier convier2= new CompositConvier(6);
        CompositConvierController convierController2 = new CompositConvierController(convier2);
        convierController2.setXYAS(150, 100, -90, 90);
        this.getChildren().add(convierController2.view());


//        canbans();

        CanbanBoard canbanBoard = new CanbanBoard(25, 6);
        CanbanBoardController canbanBoardController = new CanbanBoardController(canbanBoard);
        canbanBoardController.setXYAS(55, 660, 0, 0);
        this.getChildren().add(canbanBoardController.view());

        CanbanBoard canbanBoard1 = new CanbanBoard(25, 8);
        CanbanBoardController canbanBoardController1 = new CanbanBoardController(canbanBoard1);
        canbanBoardController1.setXYAS(55, 745, 0, 0);
        this.getChildren().add(canbanBoardController1.view());

//        testTables(bg1, bg2, bg3);
//        Blanks();

    }

    private void setEvents() {
        this.setOnDragEntered(dragEvent -> {
            RightPanel.getInstance().getPanes().get(4).setExpanded(true);
            System.out.println("On drag entered");
            System.out.println("Old: " + dx + "; " + dy);
            dx = (int)dragEvent.getSceneX();
            dy = (int)dragEvent.getSceneY();
            System.out.println("Scene: " + dragEvent.getSceneX() + "; " +dragEvent.getSceneY());
            dragEvent.consume();
        });

        this.setOnDragOver(dragEvent -> {
            dragEvent.acceptTransferModes(TransferMode.MOVE);
            ndx = (int)(dragEvent.getSceneX()-dx);
            ndy = (int)(dragEvent.getSceneY()-dy);
            dComponentController.setXY(cx+ndx, cy+ndy);
            System.out.println("On drag over " + ndx + "; " + ndy);
            dragEvent.consume();
        });

        this.setOnDragExited(dragEvent -> {
            System.out.println("On drag exited " + ndx + "; " + ndy);
            dComponentController.setXY(cx+ndx, cy+ndy);
            dragEvent.consume();
        });

        this.setOnDragDropped(dragEvent -> {
            System.out.println("On drag dropped");
            PropertyPane pp = PropertyPane.getInstance();
            pp.addProperties(dComponentController, dComponentController.getStrProperties(), dComponentController.getIntProperties());
            dragEvent.setDropCompleted(true);
            dragEvent.consume();
        });

        this.setOnDragDone(dragEvent -> {
            System.out.println("On drag done");
            dragEvent.consume();
        });

        this.setOnMouseClicked(mouseEvent -> {
            // Поле не появляется вообще. Проверка на null не помогает, кроме того она есть уже в самом deleteTextField()
//            if (t != null) {
//                deleteTextField();
//            }
        });
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
//        ConvierView sc = new ConvierView(60,6);
//        sc.setXY(290, 0);
//        getChildren().add(sc);
//        ConvierView sc2 = new ConvierView(80,8);
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
////        cc = new CanbansGroup();
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
//            gbc1.setMaterials(gml.getMaterials(gbc1.getMaterial()));           //Нова дошка
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
////        TODO: Order assigned to - not in CompositBoard, - not in index MAO
//        gbc1.addOrder(new Order(21116, "MFC184108200A", 8, 148.57));
//        gbc1.addOrder(new Order(21117, "MFC1841082A0A", 4, 178.24));
//        gbc1.addOrder(new Order(21118, "MFC1841082L0A", 47, 188.13));
////        Логування
//        gbc1.logining(14417);
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
//        cc = CanbansGroup.getInstance();
    }

    private void leyerToConnection() {
//        //        Слой для соединений  // LineLayer to Connections
//        GroupLine gLine = GroupLine.getInstance();
//        getChildren().add(gLine);
    }

    public void setdx(int sceneX) {
        dx = sceneX;
    }

    public void setdy(int sceneY) {
        dy = sceneY;
    }

    public void drugComponent (int x, int y, LeyoutComponentController controller){
        dx = x;
        dy = y;
        dComponentController = controller;
        cx = dComponentController.X();
        cy = dComponentController.Y();
        System.out.println(cx + " " + cy + " " + dx + " " + dy);
    }

    public void addComponentController(LeyoutComponentController componentController) {
        this.getChildren().add(componentController.view());
    }

    public void createTextField(LeyoutComponentController controller, double X, double Y) {
        deleteTextField();
        t = new TextField();
//        TODO только строчные свойства можно присоединить. ??? Переделать все свойства в строчные
//        Эта процедура для свойств типа been. Так что просто присоединить свойство не получится.
//        t.accessibleTextProperty(controller.getIntProperties());
//        t.accessibleTextProperty(controller.getTextProperty());
        t.relocate(X, Y);
        t.setOnKeyPressed(keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            if (KeyCode.ENTER == keyCode || KeyCode.TAB == keyCode || KeyCode.ESCAPE == keyCode)  {
                deleteTextField();
            }
        });
        this.getChildren().add(t);
    }

    public void deleteTextField(){
        if (t != null){
            this.getChildren().remove(t);
            t = null;
        }
    }

}
