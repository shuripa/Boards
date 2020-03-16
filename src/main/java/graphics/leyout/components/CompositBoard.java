package graphics.leyout.components;

import inout.CompositBuilder;
import inout.EmployesCsvLoader;
import model.*;
import sets.MAOSystem;

import java.io.IOException;
import java.util.ArrayList;

public class CompositBoard extends WorkPlacedComposit {
    Board b;
    WorkPlace wp;
    BoardIndex i;
    EffectivityIndex e;
    Grid g;
//    int step;
    ArrayList<Order> orders;

    public CompositBoard (){
        super();
        orders = new ArrayList<>();
//        step =110;
        leafs();
    }

    public CompositBoard(CompositBuilder builder) throws IOException {
        super();
        orders = new ArrayList<>();
//        step = 110;
        leafs();
        b.setId("" + builder.getId());
        b.setTitle(builder.getTitle());
        EmployesCsvLoader employes = EmployesCsvLoader.getInstance();                   // Загрузка работников
        int empid = builder.getEmployer();
        Employer e = null;
        if (empid != 0) e =  employes.getEmployerByID("" + empid);
        if (e != null) logining(e);                 // Спрятать проверку в класс emploer;
        setCondition(builder.getCondition());

//        if(builder.getConditions().size() != 0){
            //TODO CompositBoard хранит только одно значение условия
//            setCondition(builder.getConditions().get(0));
            //если ситуация изменится, раскомментировать код
//            for (String s: builder.getConditions()) {
//                setCondition(s);
//            }
//        }
    }

    private void leafs() {
        b = new Board();
        wp = new WorkPlace(this, Profession.BINDER);
        g = new Grid();
        i = new BoardIndex(this);
        e = new EffectivityIndex(this);
        wp.addComponentObserver(i);
        addLeafs(b, wp, g, i, e);
    }

    public Board getBoard() {
        return b;
    }

    @Override
    public WorkPlace getWorkPlace() {
        return wp;
    }

    public BoardIndex getBoardIndex(){
        return i;
    }

    public EffectivityIndex getEffectivityIndex(){
        return e;
    }

    public Grid getGrid(){
        return g;
    }

    public void setTitle(String title) {
        b.setTitle(title);
    }

    public String getTitle (){
        return b.getTitle();
    }

    public void setId(String boardId) {
        b.setId(boardId);
    }

    public String getId(){
        return b.getId();
    }


//    public void setCondition(String condition) {
//        b.setCondition(condition);
//    }
    public void setCondition(String condition){

//        Принимается только строка условий поскольку либо объект сам решает какой шаг установить,
//        либо шаг будет определен принимаемым типом компонента, когда все преобразователи будут сведены к одному классу.

        b.setCondition(new Condition("MFC1847034***", 110));
    }


//    public String getConditionString (){
//        return b.getCondition().getConditionString();
//    }
    public Condition condition(){
        return b.getCondition();
    }


//    @Override
//    public ArrayList<Condition> getConditions() {
//        return b.getConditions();
//    }

//    public void action(Employer employer) {
//        getWorkPlace().setEmployer(employer);
//        update();
//        getBoardIndex().updateData();
//    }

//    @Override
//    public void update(){
//        b.update();
//        wp.update();
//        i.update();
//        g.update();
//        super.update();
//    }
    /*Index*/

    public void setProc(int proc) {
        i.setProc(proc);
    }
    /*Orders*/

    public void setOrders(){
        if (mao() != null) {
            //TODO: Заказы временно отбираются по условию а не распределяются
            this.orders = mao().orderToBoard(condition());
        }
    }

    public ArrayList<Order> getOrders(){
        //TODO: Определить когда должны обновляться заказы
        setOrders();
        return orders;
    }

    public Orders orders(){
            //TODO: Заказы временно отбираются по условию а не распределяются
        if (mao() != null)
            return mao().orders(condition());
        return null;
    }

    public CompositMao mao(){
        MAOSystem maosys = MAOSystem.getInstance();
        return maosys.getMaoWithBoard(this);
    }

    public Employer getEmployer(){
        return wp.getEmployer();
    }

    @Override
    public double getEffectivity() {
        return (i != null) ? getEffectivityIndex().getTotalEffectivity() : 0;
    }

    @Override
    public int getCountFreeWorkPlace() {
        return wp == null || !wp.isLogined() ? 1 : 0;
    }

    @Override
    public String toString() {
        return "";
    }

}

