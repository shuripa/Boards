package leyout;

import leyout.controllers.CanbanController;
import leyout.component.*;
import leyout.controllers.CompositBoardController;
import sets.BoardsController;
import sets.SetBoards;
import leyout.views.ShapeConvier;
import inout.GridMaterialLoader;
import javafx.scene.layout.Region;
import model.Order;

import java.io.IOException;
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

//        Слой для соединений  // LineLayer to Connections
        GroupLine gLine = GroupLine.getInstance();
        getChildren().add(gLine);

//        TODO: канбан контроллер нужно сделать не синглтоном, а зависящим от стока и от лейаута
//        Канбан контроллер
        cc = CanbanController.getInstance();

//      TODO: привести в порядок дошки
//        Масив дошок
        arrBoards = new ArrayList<>();

//        Переработка подхода к созданию досок
        bc = BoardsController.getInstance();
        bc.addBoard(1441, "KM 189", 600, 0, 60, 0); // Li/Cb LOL
        bc.addBoard(1459, "KM 059", 600, 45, 60, 180); // Cb LOL
        this.getChildren().addAll(bc.getArrBoards());
//        добавления условий addConditions
        bc.setCondition(1441, "MFC184*189***");
        bc.setCondition(1459, "MFC1847059***");
//        Завантаження матеріалу на сітку
        try {
            GridMaterialLoader gmlnew = new GridMaterialLoader(bc.getArrBoards());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Завантаження замовлень

//        GroupBoardCanban gbc2 = new GroupBoardCanban(230, 450, 6, "12M");
//        GroupBoardCanban gbc3 = new GroupBoardCanban(450, 450, 6, "13M");
//        getChildren().addAll(gbc1, gbc2, gbc3);


        //Дошка 1
        GroupBoard bg1 = new GroupBoard(1271, "KM 029", 60, 15, 55, 0, 180);
        arrBoards.add(bg1);
        //Логування
        bg1.setLoginning(12700);
        //Умова
        bg1.setCondition("MFC1847029***");

        //Список замовлень
        ArrayList orders = new ArrayList<>();
        Order ord1 = new Order(21100, "1FC3LA02004B0", 20, 23.15);
        Order ord2 = new Order(21115, "1FC3LC02004B0", 30, 25.15);
        orders.add(ord1);
        orders.add(ord2);
        bg1.setOrd(orders);

//         Дошка 2
        GroupBoard bg2 = new GroupBoard(1311, "KM 317", 60, 15, 0, 0, 0);
        arrBoards.add(bg2);
//        Умова
        bg2.setCondition("MFC1802317***");
        this.getChildren().addAll(bg1, bg2);

//        Дошка 3
        GroupBoard bg3 = new GroupBoard(2117, "KM 771", 60, 80, 70, -90, 50);
        arrBoards.add(bg3);
        bg3.setCondition("MFC1847771***");
        getChildren().add(bg3);

//        Інші дошки
        GroupBoard vt01 = new GroupBoard(2116, "VT 01", 60, 80, 8, -90, 85);
        vt01.setCondition("1FC3L*01*****");
        GroupBoard vt02 = new GroupBoard(2118, "VT 02", 60, 125, 8, 90, 50);
        vt02.setCondition("1FC3L*02*****");
        arrBoards.add(vt01);
        arrBoards.add(vt02);
        getChildren().addAll(vt01, vt02);

        GroupBoard x = new GroupBoard(2119, "KM 246", 60, 125, 70, 90, 1);
        arrBoards.add(x);
        getChildren().add(x);
        x = new GroupBoard(1232,"KM 230",90, 15, 130, 0, 0);
        arrBoards.add(x);
        getChildren().add(x);


//        Перероблені дошки v2
        CompositBoardController gbc1 = new CompositBoardController(1900, "KM-xxx", 60, 600, 200, 0.0);
//        TODO: можно ли добалять к лейауту не тут а в наборе?
//         - Можно создав в наборе процедуру добавления всех элементов и передав ей лейаут параметром
        this.getChildren().add(gbc1.getView());
//        Властивості
//        TODO: переделать в свойства
        gbc1.setID(1990);
        gbc1.setTitle("KM 082");
        gbc1.setCondition("MFC1841082***");
//        Замовлення
//        TODO: Заказы добавляются - не к CompositBoard, - не к Индексу а к МАО
        gbc1.addOrder(new Order(21116, "MFC184108200A", 8, 148.57));
        gbc1.addOrder(new Order(21117, "MFC1841082A0A", 4, 178.24));
        gbc1.addOrder(new Order(21118, "MFC1841082L0A", 47, 188.13));
//        Логування
        gbc1.setLogining(14417);
//        Додавання дошки в набор
        SetBoards.getInstance().addGroupBoardController(gbc1);

//        Завантаження матеріалу на сітку
        try {
            GridMaterialLoader gml = new GridMaterialLoader(arrBoards);     //Стара дошка
            gbc1.setMaterials(gml.getMaterials(gbc1.getTitle()));           //Нова дошка
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Канбани
//        cc = new CanbanController();

        cc.addCanban(10, 550, 4, 4, "16D");
        cc.addCanban(160, 550, 7, 4, "01F");
        cc.addCanban(415, 550, 7, 4, "13O");
        cc.addCanban(10, 650, 7, 4, "14O");
        cc.addCanban(265, 650, 7, 4,"15O");
        cc.addCanban(520, 650, 7, 4,"16O");
        cc.addCanban(760, 550, 7, 4,"17O");
        cc.addCanban(835, 650, 7, 4,"18O");
        cc.addCanban(10, 720, 30, 8,"A");
        getChildren().addAll(cc.getCanbans());


//        Тестувальні столи
//        Тестувальний стіл 1
        GroupTest gt1 = new GroupTest("1520", "KM-15", 40, 5, 250, 0);
        getChildren().add(gt1);
        gt1.nEnt.addNode(bg1.getExt());
        gt1.nEnt.addNode(bg2.getExt());
        gt1.nEnt.addNode(bg3.getExt());

        getChildren().add(new GroupTest("1521", "KM-18", 50, 113, 250, 0));
        getChildren().add(new GroupTest("1522", "KM-21", 100, 230, 250, 0));
        getChildren().add(new GroupTest("1523", "KM-21", 60, 327, 340, 90));

//        Конвеєра
        ShapeConvier sc = new ShapeConvier(60,6);
        sc.relocate(290, 0);
        getChildren().add(sc);
        ShapeConvier sc2 = new ShapeConvier(80,8);
        sc2.relocate(440, 0);
        getChildren().add(sc2);

//        Заготовки
        GroupBlank gb1 = new GroupBlank("1211", "VT 04 Li", 60, 15, 180, 180, 60);
        GroupBlank gb2 = new GroupBlank("1212", "VT 04 Li", 60, 100, 180, 180, 90);
        getChildren().addAll(gb1, gb2);

        GroupPushcart gp = new GroupPushcart(700,200,0);
        this.getChildren().addAll(gp);

    }


}
