package graphics.leyout.components;

import sets.SetOrders;
import sets.stock.*;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

//Лыжа

public class KanbanLeaf extends LeyoutComponent {
    private static final Logger logger = Logger.getLogger("MainApp");
    private LeafAddress address;
    private MasterStore master;
    private Reserve reserve;
    private Storage storage;
    private List<Order> orders;

    private PriorityQueue<KanbanCard> freeCards;
    private PriorityQueue<KanbanCard> joinCards;
    private PriorityQueue<KanbanCard> orderCards;

    public KanbanLeaf(KanbanSection parent, LeafAddress address){
        //Установка адреса
        setParent(parent);          //TODO: Обязательна ли обратная связь?
        this.address = address;
        logger.log(Level.FINE, "setAddres" + address);
        //Инициализация
        joinCards = new PriorityQueue<>();
        freeCards = new PriorityQueue<>();
        orderCards = new PriorityQueue<>();
        //Загрузка данных
        master = getMaster(address);
        reserve = getReserve();
        orders = getOrders();
        //Создание карточек
        setCountCards(master.getOrderCnt());
    }

    /*Загрузка данных*/

    private MasterStore getMaster(LeafAddress address){
        MasterStore result = SetMasterStore.getInstance().getMasterStore(address);
        if ( result != null) {
            logger.log(Level.FINE, "address : " + address + " : " + result);
            return result;
        }
        else {
            logger.log(Level.FINE, "address : " + address + " : " + "master is null");
            return new MasterStore("", 0, 0);
        }
    }

    public Reserve getReserve(){
        storage = new KanbanStorage("F5", material(), address.toString());
        StockSet.getInstance().getStock("F5").setStorage(storage);
//        return storage.getCount();

        Reserve result = StockSet.getInstance().getStock("F5").getReserve(address);
        if (result != null){
            logger.log(Level.FINE, "store to " + address.toString() + " not null.");
            if (master.getMaterialStr().equals("")) master.setMaterialStr(result.getMaterial());
            return result;
        } else {
            logger.log(Level.FINE, "store to " + address.toString() + " is null.");
            return new Reserve("", .0);
        }
    }

    private List<Order> getOrders() {
        List<Order> result;
        if (master.getMaterialStr().equals("")){
            if (storage.getMaterial().equals("")){
                result = new ArrayList<>();
                logger.log(Level.FINE, "address : " + address + " : " + "master and store is null");
            } else{
                result = SetOrders.getInstance().getOders("F5", storage.getMaterial());
                logger.log(Level.FINE, "address : " + address + " : " + "master is null, store not null");
            }
        } else{
            result = SetOrders.getInstance().getOders("F5", master.getMaterialStr());
            logger.log(Level.FINE, "address : " + address + " : " + "master not null");
        }
        return result;
    }

    /*Управление карточками*/

    public void setCountCards(int countCards) {
        //TODO Первичная логика вычислени количества карт. Доработать позже.
        //TODO Добавить логику для orderCard;

        if(orders.size() > 0){
            for (Order o: orders) {
                KanbanCard card = new KanbanCard(orderCards.size()+1);
                card.setCardDefinition(master.getMasterDefinition());
                orderCards.offer(card);
            }
        }

        for (int i = cntCard(); i < countCards; i++) {
            if ((joinCards.size()+1)* masterDefinition() < cntInStockMaterial()){
                KanbanCard card = new KanbanCard(joinCards.size()+1);
                // При первом создании если данных нет устанавливаются значения по умолчанию
                // в последующих запросах нужно использовать реальное количество и реальную дифиницию
                card.setCardDefinition(master.getMasterDefinition());
                card.setCountMaterial(master.getMasterDefinition());
                joinCards.offer(card);
            } else  {
                KanbanCard card = new KanbanCard(freeCards.size()+1);
                card.setCardDefinition(master.getMasterDefinition());
                freeCards.offer(card);
            }
        }
    }

    public void join (){
        freeCards.peek().join(joinCards.size()+1);
        joinCards.add(freeCards.poll());
        decCards(freeCards);
    }

    public void free(){
        joinCards.peek().free(freeCards.size()+1);
        if (joinCards.size() + freeCards.size() > cntCard()) {
            joinCards.poll();
        } else {
            freeCards.add(joinCards.poll());
        }
        decCards(joinCards);
    }

    private void decCards(PriorityQueue<KanbanCard> queue) {
        for (KanbanCard card: queue) {
            card.decPriority();
        }
    }

    /*Получение данных*/

    public String material(){
        String result = "";
        if ( master != null) result = master.getMaterialStr();
        return result;
    }

    public double cntInStockMaterial(){
        return StockSet.getInstance().getStock("F5").getCount(material());
    }

    public double cntInStoreMaterial(){
        return storage.getCount();
    }

    public int cntCard(){
        return joinCards.size() + freeCards.size() + orderCards.size();
    }

    public int cntJoined(){
        return joinCards.size();
    }

    public int cntOrdered() {
        return orderCards.size();
    }

    public int cntFreed (){
        return freeCards.size();
    }

    private int masterDefinition(){
        int result = 0;
        if ( master != null) result = master.getMasterDefinition();
        return result;
    }

    public boolean isStarted (){
        boolean result = false;
        for (Order o : orders) {
            result = result ||  o.isStarted();
        }
        return result;
    }

    @Override
    public void update () {
    }

    public String toString() {
        //Пока в лыже не прописан собственный материал ил существует понятие Store для склада
        //используем Store для материала отображения материала и количества

        String  result = "F5: cnt = " + cntInStockMaterial() + "; pos " + address.toString() + " cnt = " + cntInStoreMaterial();
        result = result  + "\n mat = " + material();
        result = result + "\n cards = " + cntCard() + "; def = " + masterDefinition();

        result = result + "\n    Opened Orders = " + cntOrdered() + "; started = " + isStarted();
        for (Order o : orders) {
            result = result + "\n ordNo: " + o.getOrderNo() + ";  cnt: " + o.getCount() + "; rest: " + o.getRest() + "; end : " + o.getEndD();
        }

        result = result + "\n    Join Cards = " + cntJoined();
        for (KanbanCard card : joinCards) {
            result = result + "\n cnt = " + card.getCountMaterial();
        }

        result = result + "\n    Free Cards : " + cntFreed();
        for (KanbanCard card : freeCards) {
            result = result + "\n def = " + masterDefinition();
        }

        return result;
    }

}
