package graphics;

import graphics.leyout.components.*;
import inout.CompositBuilder;
import sets.MAOSystem;
import sets.SetControl;
import sets.SetInstructions;

import java.util.logging.Level;
import java.util.logging.Logger;


public class LayoutComponentLoader {
    MAOSystem maoSystem;
    LeyoutComponent component;
    LeyoutComponent control;

    public LayoutComponentLoader(){
        Logger.getLogger("MainApp").log(Level.CONFIG, "Load compontns");
        maoSystem = MAOSystem.getInstance();
//    TODO: Тестовые данные не будут использоваться при работе с базой данных

//        Connection connection = new Connection();
//        connection.connect();
        loadTestCompositTool();
        loadTestMaoSystem();
        loadTestCompositBoards();
        loadTestCompositTestTable();
        loadTestCompositPushchart();
        loadTestCompositConvier();
        loadTestCompositManagerTable();
        loadTestCompositInformTable();
        loadTestCanbanBoard();

//        TODO: Другие компоненты: Blank, Welding, Twisting, Melding, WaterTest
//    private void Blanks() {
//                Заготовки
//        GroupBlank gb1 = new GroupBlank("1211", "VT 04 Li", 60, 15, 180, 180, 60);
//        GroupBlank gb2 = new GroupBlank("1212", "VT 04 Li", 60, 100, 180, 180, 90);
//        getChildren().addAll(gb1, gb2);
//    }

//        TODO: Загрузка материалов на сетки
//        TODO: Загрузка заказов
    }

    private void loadTestCompositTool() {
        SetInstructions instructions = SetInstructions.getInstance();
        SetControl setControl = SetControl.getInstance();

        component = new CompositBuilder(2023, "KM-000Cb", "CompositTool")
                .compositToolView("CompositToolBoardView")
                .materialStoreView("ToolGridView")
                .productStoreView("ToolProductStoreView")
                .toolView("ToolBoardView")
                .workPlaceView("ToolWorkPlaceView")
                .xyas(1150, 50, 0, 60).build();

        ((CompositTool)component).setInstruction(instructions.get("MFC184700000C", 110));
        ((CompositTool)component).setInstruction(instructions.get("MFC184700000D", 110));
        ((CompositTool)component).setInstruction(instructions.get("MFC1847000A0C", 110));

        control = new CompositBuilder(2026, "UO_MB23", "CompositControl")
                .compositToolView("CompositControlConcreteView")
                .toolView("MaoControlView")
                .xyas(1135, 100, 35, 0).build();
//        maoSystem.addCompositMao((CompositMao) component);
        setControl.addCompositControl((CompositControl) control);
        ((CompositControl) control).addTool((CompositTool) component);

        component = new CompositBuilder(2024, "t-1t", "CompositTool")
                .compositToolView("CompositToolTestView")
                .materialStoreView("ToolTestCanbanView")
                .productStoreView("ToolPaletteView")
                .toolView("ToolTestTableView")
                .workPlaceView("ToolWorkPlaceView")
                .xyas(1150, 150, 0, 60).build();



        component = new CompositBuilder(2025, "t-2t", "CompositRelocation")
                .compositToolView("CompositToolPushcartView")
                .toolView("ToolPushcartView")
                .workPlaceView("ToolWorkPlaceView")
                .xyas(1150, 250, 0, 60).build();

        component = new CompositBuilder(2027, "UO_MB24", "CompositControl")
                .compositToolView("CompositControlConcreteView")
                .toolView("InformControlView")
                .xyas(1150, 350, 0, 0).build();

        component = new CompositBuilder(3010, "CC-3001", "CompositToolConvier")
                .compositToolView("CompositToolConvierView")
                .toolView("ToolConvierView")
                .leafs(8).xyas(1150,430,0,60).build();

        component = new CompositBuilder(5001, "MT-5001","CompositLeaderTable")
                .xyas(900,430,0,0).side("UP_RIGHT").profession("MASTER").build();

    }

    private void loadTestMaoSystem() {
        component = new CompositBuilder(2023, "UO_MB23", "CompositMao")
                .xyas(135, 145, -45, 0).build();
        maoSystem.addCompositMao((CompositMao) component);

        component = new CompositBuilder(2012, "UO_MB12", "CompositMao")
                .xyas(300, 145, -45,0).build();
        maoSystem.addCompositMao((CompositMao) component);

        component = new CompositBuilder(2013, "UO_MB13", "CompositMao")
                .xyas(250, 460, -45,0).build();
        maoSystem.addCompositMao((CompositMao) component);
    }

    private void loadTestCompositBoards() {
        component = new CompositBuilder(1902, "KM-034Cb", "CompositBoard")
                .xyas(100,100,0,90).condition("MFC1847034***").parid(30).employer(12730).build();
        maoSystem.getCompositMao("UO_MB23").addBoard((CompositBoard)component);

        component = new CompositBuilder(1903, "KM-087Cb", "CompositBoard")
                .xyas(100,150,-180,90).condition("*FC1847087***").parid(40).build();
        maoSystem.getCompositMao("UO_MB23").addBoard((CompositBoard)component);

        component = new CompositBuilder(1904, "KM-317Cp","CompositBoard")
                .xyas(220,100,0,90).condition("MFC1802317***").parid(70).build();
        maoSystem.getCompositMao("UO_MB12").addBoard((CompositBoard)component);

        component = new CompositBuilder(1905, "KM-164CbR", "CompositBoard")
                .xyas(220,150,-180,90).condition("MFC1847164***").parid(80).build();
        maoSystem.getCompositMao("UO_MB12").addBoard((CompositBoard)component);

        component = new CompositBuilder(1906, "KM-217Cb", "CompositBoard")
                .xyas(315,100,0,60).condition("MFC1847217***").parid(10).build();
        maoSystem.getCompositMao("UO_MB12").addBoard((CompositBoard)component);

        component = new CompositBuilder(1907, "KM-012CpR","CompositBoard")
                .xyas(315,150,-180,60).condition("MFC1802012***").parid(20).build();
        maoSystem.getCompositMao("UO_MB12").addBoard((CompositBoard)component);

        component = new CompositBuilder(2116, "VT-01", "CompositBoard")
                .xyas(30,480,-90,60).condition("1FC3L*01*****").parid(85).build();
        maoSystem.getCompositMao("UO_MB13").addBoard((CompositBoard)component);

        component = new CompositBuilder(2119, "KM-246", "CompositBoard")
                .xyas(85,480,90,60).condition("MFC1841246***").parid(20).build();
        maoSystem.getCompositMao("UO_MB13").addBoard((CompositBoard)component);

        component = new CompositBuilder(2117, "KM-771", "CompositBoard")
                .xyas(30,415,-90,60).condition("MFC1847771***").parid(50).build();
        maoSystem.getCompositMao("UO_MB13").addBoard((CompositBoard)component);

        component = new CompositBuilder(2118, "VT-02", "CompositBoard")
                .xyas(85,415,90,60).condition("1FC3L*02*****").parid(50).build();
        maoSystem.getCompositMao("UO_MB13").addBoard((CompositBoard)component);

        component = new CompositBuilder(1271, "KM-029", "CompositBoard")
                .xyas(190,450,0,60).condition("MFC1847029***").parid(50).employer(12700).build();
        maoSystem.getCompositMao("UO_MB13").addBoard((CompositBoard)component);

        component = new CompositBuilder(1232, "KM-230","CompositBoard")
                .xyas(160,400,0,90).condition("MFC1841230***").parid(20).build();
        maoSystem.getCompositMao("UO_MB13").addBoard((CompositBoard)component);

        component = new CompositBuilder(1311, "KM-317", "CompositBoard")
                .xyas(280,450,180,60).condition("MFC1802317***").parid(50).build();
        maoSystem.getCompositMao("UO_MB13").addBoard((CompositBoard)component);

        component = new CompositBuilder(1990, "KM-082", "CompositBoard")
                .condition("MFC1841082***").xyas(280,400,0,60).parid(20).employer(14417).build();
        maoSystem.getCompositMao("UO_MB13").addBoard((CompositBoard)component);

        component = new CompositBuilder(1441, "KM-189","CompositBoard")
                .xyas(350,400,0,60).condition("MFC1847189***").parid(50).build();
        maoSystem.getCompositMao("UO_MB13").addBoard((CompositBoard)component);

        component = new CompositBuilder(1459, "KM-189", "CompositBoard")
                .xyas(350,450,180,60).condition("MFC1847059***").parid(50).build();
        maoSystem.getCompositMao("UO_MB13").addBoard((CompositBoard)component);

    }

    private void loadTestCompositTestTable() {
        component = new CompositBuilder(1525,"KM-25", "CompositTestTable")
                .xyas(830,25, 0, 60).condition("MFC1847164***").build();
        component = new CompositBuilder(1521, "KM-18", "CompositTestTable")
                .xyas(830,90, 0, 60).condition("MFC1847164***").build();
        component = new CompositBuilder(1522, "KM-22", "CompositTestTable")
                .xyas(50,25, 0, 90).condition("MFC1847164***").build();
        component = new CompositBuilder(1523, "KM-23", "CompositTestTable")
                .xyas(830,161, 0, 60).condition("MFC1847164***").build();
    }

    private void loadTestCompositPushchart() {
        component = new CompositBuilder(4101, "PC-4001", "CompositPushcart")
                .xyas(250, 20, -90, 60).build();
        component = new CompositBuilder(4102, "PC-4102", "CompositPushcart")
                .xyas(370, 30, 0, 0).build();
        component = new CompositBuilder(4103, "PC-4103","CompositPushcart")
                .xyas(575, 315, 0, 0).build();
    }

    private void loadTestCompositConvier() {
        component = new CompositBuilder(3001, "CC-3001", "CompositConvier")
                .leafs(8).xyas(455,10,0,60).build();

        component = new CompositBuilder(3002, "CC-3002", "CompositConvier")
                .leafs(6).xyas(160,100,-90,90).build();

        component = new CompositBuilder(3003, "CC-3003", "CompositConvier")
                .leafs(6).xyas(700,195,90,60).build();
    }

    private void loadTestCompositManagerTable() {
        component = new CompositBuilder(5001, "MT-5001","CompositManagerTable")
                .xyas(602,60,0,0).side("UP_RIGHT").profession("MASTER").build();

        component = new CompositBuilder(5002, "MT-5002", "CompositManagerTable")
                .xyas(692,60,0,0).side("UP_LEFT").profession("LEADER").build();

        component = new CompositBuilder(5003, "MT-5003", "CompositManagerTable")
                .xyas(600,10,-180,0).side("UP_LEFT").profession("DEPARTMENT_MANAGER").build();

        component = new CompositBuilder(5004, "MT-5004", "CompositManagerTable")
                .xyas(690,16,-180,0).side("UP_RIGHT").profession("LOCATION_MANAGER").build();
    }

    private void loadTestCompositInformTable() {
        component = new CompositBuilder(6001, "IT-6001","CompositInformTable")
                .xyas(600, 150, 0, 0).profession("BRIGADIER").build();

        component = new CompositBuilder(6002, "IT-6002","CompositInformTable")
                .xyas(642, 150, 0, 0).profession("DELIVER").build();

        component = new CompositBuilder(6003, "IT-6003","CompositInformTable")
                .xyas(684, 150, 0, 0).profession("ENGINEER").build();

        component = new CompositBuilder(6004, "IT-6004", "CompositInformTable")
                .xyas(726, 150, 0, 0).profession("BINDER").build();
    }

    private void loadTestCanbanBoard() {
        //TODO: К каой группе и где именно присоединяются канбаны
        component = new CompositBuilder(7001, "01O","KanbanBoard")
                .xyas(50, 550, 0, 0).leafs(7).cards(4).build();

        component = new CompositBuilder(7002, "02O","KanbanBoard")
                .xyas(50, 610, 0, 0).leafs(7).cards(4).build();

        component = new CompositBuilder(7003, "16D", "KanbanBoard")
                .xyas(230, 550, 0, 0).leafs(4).cards(4).build();

        component = new CompositBuilder(7004, "13O", "KanbanBoard")
                .xyas(230, 610, 0, 0).leafs(7).cards(4).build();

        component = new CompositBuilder(7005, "14O", "KanbanBoard")
                .xyas(410, 550, 0, 0).leafs(7).cards(4).build();

        component = new CompositBuilder(7006, "15O","KanbanBoard")
                .xyas(410, 610, 0, 0).leafs(7).cards(4).build();

        component = new CompositBuilder(7007, "16O", "KanbanBoard")
                .xyas(590, 550, 0, 0).leafs(7).cards(4).build();

        component = new CompositBuilder(7008, "17O", "KanbanBoard")
                .xyas(590, 610, 0, 0).leafs(7).cards(4).build();

        component = new CompositBuilder(7009, "A", "KanbanBoard")
                .xyas(50, 670, 0, 0).leafs(35).cards(8).build();

    }
}
