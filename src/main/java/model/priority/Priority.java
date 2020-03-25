package model.priority;

import graphics.leyout.components.WorkPlace;
import model.Employee;

public abstract class Priority {
//    Закрепленное рабочее место
//    Продуктивность
//    Професия сопоставима
//    Професия отличается на вверх 1
//    Професия отличается на вниз 1
//    Професия отличается на 2 и более
//    Проект

//    Работник и рабочее место
//

    Employee employee;
    WorkPlace workPlace;
    int rank;
    double productivity;
    Priority result;

    public Priority(){
        rank = 0;
    }

    public Priority(Employee employee, WorkPlace workPlace){
        this.employee = employee;
        this.workPlace = workPlace;
        rank = 0;
    }

    public void setRank (int rank){
        this.rank = rank;
    }

    int getRank (){
        return rank;
    }

    abstract Priority verification(Employee employee, WorkPlace workPlace);

}
