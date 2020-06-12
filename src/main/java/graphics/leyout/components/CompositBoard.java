package graphics.leyout.components;

import inout.CompositBuilder;
import model.*;
import sets.MAOSystem;
import sets.SetEmployees;

import java.util.ArrayList;

public class CompositBoard extends WorkPlacedComposit {
    Board b;
    WorkPlace wp;
    BoardIndex i;
    EffectivityIndex e;
    Grid g;
//    int step;
    ArrayList<Order> orders;

    public CompositBoard(){
        super();
        orders = new ArrayList<>();
//        step =110;
        leafs();
    }

    public CompositBoard(CompositBuilder builder) {
        super();
        orders = new ArrayList<>();
//        step = 110;
        leafs();
        building(builder);
    }

    private void leafs(){
        b = new Board();
        wp = new WorkPlace(this, Profession.BINDER);
        g = new Grid();
        i = new BoardIndex(this);
        e = new EffectivityIndex(this);
        wp.addComponentObserver(i);
        addLeafs(b, wp, g, i, e);
    }

    private void building(CompositBuilder builder){
        b.building(builder);
        logining(getEmployeeFromSetEmployees(builder.getEmployeeId()));
        i.setProc(builder.getParid());

        //        if(builder.getConditions().size() != 0){
        //TODO CompositBoard хранит только одно значение условия
//            setCondition(builder.getConditions().get(0));
        //если ситуация изменится, раскомментировать код
//            for (String s: builder.getConditions()) {
//                setCondition(s);
//            }
//        }
    }


    public void setCondition(String condition){

//        Принимается только строка условий поскольку либо объект сам решает какой шаг установить,
//        либо шаг будет определен принимаемым типом компонента, когда все преобразователи будут сведены к одному классу.

        b.setCondition("MFC1847034***", 110);
    }


    private Employee getEmployeeFromSetEmployees(int id){
        return SetEmployees.getInstance().getEmployeeByID("" + id);
    }

    //    public void setCondition(String condition) {
//        b.setCondition(condition);

//    }


    //    public String getConditionString (){
//        return b.getCondition().getConditionString();
//    }
    public Condition condition(){
        return b.getCondition();
    }
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

    public Employee getEmployee(){
        return wp.getEmployee();
    }

    @Override
    public double getEffectivity() {
        return (i != null) ? getEffectivityIndex().getTotalEffectivity() : 0;
    }

    @Override
    public int getCountFreeWorkPlace() {
        return wp == null || !wp.isLogined() ? 1 : 0;
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

    public String getId(){
        return b.getId();
    }

    public void setId(String boardId) {
        b.setId(boardId);
    }

    public String getTitle (){
        return b.getTitle();
    }

    public void setTitle(String title) {
        b.setTitle(title);
    }

    public Board getBoard() {
        return b;
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

    @Override
    public WorkPlace getWorkPlace() {
        return wp;
    }

    @Override
    public String toString() {
        return "";
    }

}

