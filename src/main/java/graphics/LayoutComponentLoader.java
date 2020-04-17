package graphics;

import graphics.leyout.components.CompositBoard;
import graphics.leyout.components.CompositMao;
import graphics.leyout.components.LeyoutComponent;
import inout.CompositBuilder;
import sets.MAOSystem;


public class LayoutComponentLoader {
    MAOSystem maoSystem;
    LeyoutComponent component;

    public LayoutComponentLoader(){
        maoSystem = MAOSystem.getInstance();

//    TODO: Тестовые данные не будут использоваться при работе с базой данных

//        Connection connection = new Connection();
//        connection.connect();

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

    private void loadTestMaoSystem() {
        component = new CompositBuilder(2023, "CompositMao").title("UO_MB23")
                .xyas(135, 145, -45, 0).build();
        maoSystem.addCompositMao((CompositMao) component);

        component = new CompositBuilder(2012, "CompositMao").title("UO_MB12")
                .xyas(300, 145, -45,0).build();
        maoSystem.addCompositMao((CompositMao) component);

        component = new CompositBuilder(2013, "CompositMao").title("UO_MB13")
                .xyas(250, 460, -45,0).build();
        maoSystem.addCompositMao((CompositMao) component);
    }

    private void loadTestCompositBoards() {
        component = new CompositBuilder(1902, "CompositBoard").title("KM-034Cb")
                .condition("MFC1847034***").xyas(100,100,0,90).parid(30).employer(12730).build();
        maoSystem.getCompositMao("UO_MB23").addBoard((CompositBoard)component);

        component = new CompositBuilder(1903, "CompositBoard").title("KM-087Cb")
                .condition("*FC1847087***").xyas(100,150,-180,90).parid(40).build();
        maoSystem.getCompositMao("UO_MB23").addBoard((CompositBoard)component);

        component = new CompositBuilder(1904, "CompositBoard").title("KM-317Cp")
                .condition("MFC1802317***").xyas(220,100,0,90).parid(70).build();
        maoSystem.getCompositMao("UO_MB12").addBoard((CompositBoard)component);

        component = new CompositBuilder(1905, "CompositBoard").title("KM-164CbR")
                .condition("MFC1847164***").xyas(220,150,-180,90).parid(80).build();
        maoSystem.getCompositMao("UO_MB12").addBoard((CompositBoard)component);

        component = new CompositBuilder(1906, "CompositBoard").title("KM-217Cb")
                .condition("MFC1847217***").xyas(315,100,0,60).parid(10).build();
        maoSystem.getCompositMao("UO_MB12").addBoard((CompositBoard)component);

        component = new CompositBuilder(1907, "CompositBoard").title("KM-012CpR")
                .condition("MFC1802012***").xyas(315,150,-180,60).parid(20).build();
        maoSystem.getCompositMao("UO_MB12").addBoard((CompositBoard)component);

        component = new CompositBuilder(2116, "CompositBoard").title("VT-01")
                .condition("1FC3L*01*****").xyas(30,480,-90,60).parid(85).build();
        maoSystem.getCompositMao("UO_MB13").addBoard((CompositBoard)component);

        component = new CompositBuilder(2119, "CompositBoard").title("KM-246")
                .condition("MFC1841246***").xyas(85,480,90,60).parid(20).build();
        maoSystem.getCompositMao("UO_MB13").addBoard((CompositBoard)component);

        component = new CompositBuilder(2117, "CompositBoard").title("KM-771")
                .condition("MFC1847771***").xyas(30,415,-90,60).parid(50).build();
        maoSystem.getCompositMao("UO_MB13").addBoard((CompositBoard)component);

        component = new CompositBuilder(2118, "CompositBoard").title("VT-02")
                .condition("1FC3L*02*****").xyas(85,415,90,60).parid(50).build();
        maoSystem.getCompositMao("UO_MB13").addBoard((CompositBoard)component);

        component = new CompositBuilder(1271, "CompositBoard").title("KM-029")
                .condition("MFC1847029***").xyas(190,450,0,60).parid(50).employer(12700).build();
        maoSystem.getCompositMao("UO_MB13").addBoard((CompositBoard)component);

        component = new CompositBuilder(1232, "CompositBoard").title("KM-230")
                .condition("MFC1841230***").xyas(160,400,0,90).parid(20).build();
        maoSystem.getCompositMao("UO_MB13").addBoard((CompositBoard)component);

        component = new CompositBuilder(1311, "CompositBoard").title("KM-317")
                .condition("MFC1802317***").xyas(280,450,180,60).parid(50).build();
        maoSystem.getCompositMao("UO_MB13").addBoard((CompositBoard)component);

        component = new CompositBuilder(1990, "CompositBoard").title("KM-082")
                .condition("MFC1841082***").xyas(280,400,0,60).parid(20).employer(14417).build();
        maoSystem.getCompositMao("UO_MB13").addBoard((CompositBoard)component);

        component = new CompositBuilder(1441, "CompositBoard").title("KM-189")
                .condition("MFC1847189***").xyas(350,400,0,60).parid(50).build();
        maoSystem.getCompositMao("UO_MB13").addBoard((CompositBoard)component);

        component = new CompositBuilder(1459, "CompositBoard").title("KM-189")
                .condition("MFC1847059***").xyas(350,450,180,60).parid(50).build();
        maoSystem.getCompositMao("UO_MB13").addBoard((CompositBoard)component);

    }

    private void loadTestCompositTestTable() {
        component = new CompositBuilder(1525, "CompositTestTable").title("KM-25")
                .condition("MFC1847164***").xyas(100,15, 0, 60).build();
        component = new CompositBuilder(1521, "CompositTestTable").title("KM-18")
                .condition("MFC1847164***").xyas(150,15, 0, 60).build();
        component = new CompositBuilder(1522, "CompositTestTable").title("KM-22")
                .condition("MFC1847164***").xyas(200,15, 0, 60).build();
        component = new CompositBuilder(1523, "CompositTestTable").title("KM-23")
                .condition("MFC1847164***").xyas(250,15, 0, 60).build();
    }

    private void loadTestCompositPushchart() {
        component = new CompositBuilder(4101, "CompositPushcart").title("PC-4001")
                .xyas(250, 20, -90, 60).build();
        component = new CompositBuilder(4102, "CompositPushcart").title("PC-4102")
                .xyas(370, 30, 0, 0).build();
        component = new CompositBuilder(4103, "CompositPushcart").title("PC-4103")
                .xyas(575, 315, 0, 0).build();
    }

    private void loadTestCompositConvier() {
        component = new CompositBuilder(3001, "CompositConvier").title("CC-3001")
                .leafs(8).xyas(455,10,0,60).build();

        component = new CompositBuilder(3002, "CompositConvier").title("CC-3002")
                .leafs(6).xyas(160,100,-90,90).build();

        component = new CompositBuilder(3003, "CompositConvier").title("CC-3003")
                .leafs(6).xyas(700,195,90,60).build();
    }

    private void loadTestCompositManagerTable() {
        component = new CompositBuilder(5001, "CompositManagerTable").title("MT-5001")
                .side("UP_RIGHT").profession("MASTER").xyas(602,60,0,0).build();

        component = new CompositBuilder(5002, "CompositManagerTable").title("MT-5002")
                .side("UP_LEFT").profession("LEADER").xyas(692,60,0,0).build();

        component = new CompositBuilder(5003, "CompositManagerTable").title("MT-5003")
                .side("UP_LEFT").profession("DEPARTMENT_MANAGER").xyas(600,10,-180,0).build();

        component = new CompositBuilder(5004, "CompositManagerTable").title("MT-5004")
                .side("UP_RIGHT").profession("LOCATION_MANAGER").xyas(690,16,-180,0).build();
    }

    private void loadTestCompositInformTable() {
        component = new CompositBuilder(6001, "CompositInformTable").title("IT-6001")
                .profession("BRIGADIER").xyas(600, 150, 0, 0).build();

        component = new CompositBuilder(6002, "CompositInformTable").title("IT-6002")
                .profession("DELIVER").xyas(642, 150, 0, 0).build();

        component = new CompositBuilder(6003, "CompositInformTable").title("IT-6003")
                .profession("ENGINEER").xyas(684, 150, 0, 0).build();

        component = new CompositBuilder(6004, "CompositInformTable").title("IT-6004")
                .profession("BINDER").xyas(726, 150, 0, 0).build();
    }

    private void loadTestCanbanBoard() {
        //TODO: К каой группе и где именно присоединяются канбаны
        component = new CompositBuilder(7001, "CanbanBoard").title("01O")
                .leafs(7).cards(4).xyas(50, 550, 0, 0).build();

        component = new CompositBuilder(7002, "CanbanBoard").title("02O")
                .leafs(7).cards(4).xyas(50, 610, 0, 0).build();

        component = new CompositBuilder(7003, "CanbanBoard").title("16D")
                .leafs(4).cards(4).xyas(230, 550, 0, 0).build();

        component = new CompositBuilder(7004, "CanbanBoard").title("13O")
                .leafs(7).cards(4).xyas(230, 610, 0, 0).build();

        component = new CompositBuilder(7005, "CanbanBoard").title("14O")
                .leafs(7).cards(4).xyas(410, 550, 0, 0).build();

        component = new CompositBuilder(7006, "CanbanBoard").title("15O")
                .leafs(7).cards(4).xyas(410, 610, 0, 0).build();

        component = new CompositBuilder(7007, "CanbanBoard").title("16O")
                .leafs(7).cards(4).xyas(590, 550, 0, 0).build();

        component = new CompositBuilder(7008, "CanbanBoard").title("17O")
                .leafs(7).cards(4).xyas(590, 610, 0, 0).build();

        component = new CompositBuilder(7009, "CanbanBoard").title("A")
                .leafs(35).cards(8).xyas(50, 670, 0, 0).build();

    }
}
