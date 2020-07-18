package graphics.leyout.components;

import inout.CompositBuilder;
import model.Employee;
import model.Instruction;
import model.Profession;
import sets.SetEmployees;

import java.util.ArrayList;

/**
 * Board, TestTable
 * phase, cicle - этап() преобразования материалов в полупродукт, полупродукта в продукт
 * step - шаг этапа преобразования.
 */

public class CompositTool extends WorkPlacedComposit{
    Tool tool;                  //Рабочий инструмент
    MaterialStore mst;          //Места хранения набор материалов
    ProductionStore pst;        //Место хранения продукции
    WorkPlace wp;               //Рабочее место
    ArrayList<Index> inds;      //Все индексы, TODO: пока под вопросом сколько их и какие именно;
    Instructions inss;
    int step;                   //Рабочий шаг TODO: не предусмотрено в билдере

    public CompositTool(){
        super();
        leafs();
    }

    public CompositTool(CompositBuilder builder) {
        super();
        leafs(builder);
        building(builder);
    }

    private void leafs(){
        tool = new Tool();
        wp = new WorkPlace(this, Profession.BINDER);
        //TODO остальное массивы, проверить как их добавлять
        pst = new ProductionStore();
        inds = new ArrayList();
        inss = new Instructions();
        mst = new MaterialStore(inss);
        //TODO конкретные индексы нужно еще создавать
        addLeafs(tool, wp);
    }


    private void leafs(CompositBuilder builder){
        tool = new Tool(builder);
        wp = new WorkPlace(this, Profession.BINDER);
       //TODO остальное массивы, проверить как их добавлять
        pst = new ProductionStore();
        inds = new ArrayList();
        inss = new Instructions();
        mst = new MaterialStore(inss);
        //TODO конкретные индексы нужно еще создавать
        addLeafs(tool, wp);
    }

    private void building(CompositBuilder builder){
        tool.building(builder);
        logining(getEmployeeFromSetEmployees(builder.getEmployeeId()));

//        i.setProc(builder.getParid());

        //        if(builder.getConditions().size() != 0){
        //TODO CompositBoard хранит только одно значение условия
//            setCondition(builder.getConditions().get(0));
        //если ситуация изменится, раскомментировать код
//            for (String s: builder.getConditions()) {
//                setCondition(s);
//            }
//        }
    }

    public Tool getTool() {
        return tool;
    }

    private Employee getEmployeeFromSetEmployees(int id){
        return SetEmployees.getInstance().getEmployeeByID("" + id);
    }

    @Override
    public WorkPlace getWorkPlace() {
        return wp;
    }

    @Override
    public int getCountFreeWorkPlace() {
        return 1;
    }

    public Instructions getInstructions() {
        return inss;
    }

    @Override
    public String toString() {
        return "";
    }

    public MaterialStore getMaterialStore() {
        return mst;
    }

    public ProductionStore getProductStore() {
        return pst;
    }

    public void setInstruction(Instruction instruction) {
        inss.addInstruction(instruction);
    }
}
