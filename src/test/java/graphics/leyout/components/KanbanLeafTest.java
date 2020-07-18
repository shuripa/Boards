package graphics.leyout.components;

import org.junit.Test;

import java.io.IOException;


/*
* Лыжа канбана.
* Описание.
* Лыжа содержит материал. Материал содержится не поштучно а в связках. Связка характеризуется понятием заказ, который
* в свою очередь характеризуется понятием дифиниция. Дифиниция это величина дневного заказа.
* Связки разделяются карточками. Карточка имеет три состояния:
* - завешана на лыже
* - снята, свободна - находится на выходе канбана.
* - заказана, тоже свободна но перемещена на вход канбана, по ней открыт заказ, и она ожидает его прибытия.
* По прибытии материала он завешивается на лыжу и перекладывается карточкой.
*
* Данные.
* 
* Управляющие данные для мест хранения.
* MasterStore. Загружается в MasterStoreLoader. Файл "02.Kanban Teilestamm.csv". Хранится в SetMasterStore. Содержит:
* - String material
* - int orderCnt
* - int masterDefinition
* 
* Места хранения
* Store. Загружается в StockLoader. Файл "14.Lagerbestand.csv". Хранится в StokSet. Содержит
*  - String material
*  - Double count
* Количество материала отображает весь материал содержащийся на складе. При этом он может быть закомплектован на одном
* или нескольких рабочих местах и даже вмотан в модули. Модуль должен быть зафиниширован чтобы материал списался.
* Если этикетка выброшена материал спишется но модуль не появится.
*
* Открытые заказы. 
* Order. Загружается в OrderLoader. Файл "05.Offene.Fertigungsauftraege.csv". Хранится в SetOrders.
* - String orderNo;
* - String stock;
* - Material material;
* - Integer count;
* - Integer rest;
*/


public class KanbanLeafTest {
    LeyoutComponent component;
    KanbanBoard board;
    KanbanSection section;
    KanbanLeaf leaf;

    public KanbanLeafTest() throws IOException {
        //Есть два варианта создания:
        // 1) По билдеру.
        // 2) Из кнопки, сначала компонент создается, затем ему присваивается название, затем читаются данные ...
//        component = new CompositBuilder(7001, "16O","KanbanBoard").xyas(50, 650, 0, 0).sections(7).leafs(4).build();
        board = new KanbanBoard();
        board.setTitle("16O");
    }

    @Test
    public void setCountCards() {
    }

    @Test
    public void join() {
    }

    @Test
    public void free() {
    }

    @Test
    public void cntMaterial() {
    }

    @Test
    public void cntCard() {
    }

    @Test
    public void cntJoinCard() {
    }

    @Test
    public void storeKey() {
    }

    @Test
    public void getStore() {
    }

    @Test
    public void testToString() {
//        Создание по билдеру
//        System.out.println(component.toString());

//        Создание по кнопке
        System.out.println(board.toString());
//        section = board.getLeaf(6);
//        System.out.println(section.toString());
//        leaf = section.getLeaf(2);
//        System.out.println(leaf.toString());
    }

    @Test
    public void update() {
    }
}