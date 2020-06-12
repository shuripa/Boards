package graphics.leyout.components;

import inout.CompositBuilder;

public class CompositRelocation extends WorkPlacedComposit {

    Tool tool;
    WorkPlace wp;

    public CompositRelocation(CompositBuilder builder){
        super();
        tool = new Tool();                  //Рабочий инструмент
        wp = new WorkPlace();
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public WorkPlace getWorkPlace() {
        return wp;
    }

    @Override
    public int getCountFreeWorkPlace() {
        return 0;
    }

    public Tool getTool() {
        return tool;
    }
}
