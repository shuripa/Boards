package leyout.controllers;

import leyout.component.GroupBoard;
import leyout.Layout;
import leyout.views.ShapeEmployeCard;
import model.Employer;
import model.Skill;

import java.util.ArrayList;

public class EmployerController {
    Employer employer;
    ShapeEmployeCard shapeEmployeCard;
    ArrayList<GroupBoard> arrBd;
    char[] bdchar;
    char[] skchar;

    public EmployerController(Employer employer, ShapeEmployeCard shapeEmployeCard){
        this.employer = employer;
        this.shapeEmployeCard = shapeEmployeCard;
        employer.setEmployerController(this);
        shapeEmployeCard.setEmployerController(this);
        bdchar = null;
        skchar = null;
    }

    public EmployerController(String ID, String name){

    }

    public void boardSelect() {
        ArrayList<Skill> arrSk = employer.getSkill();
        arrBd = Layout.getInstace().getArrBoards();
        for (Skill sk: arrSk) {
            for (GroupBoard bd: arrBd) {
//                System.out.print("sk " + sk.getMaterialBlank() + " bd " + bd.getCondition());
                if ((sk.getMaterialBlank() != null) && (bd.getCondition() != null)) {
                    skchar = sk.getMaterialBlank().toCharArray();
                    bdchar = bd.getCondition().toCharArray();
                }

                Boolean b = true;
                for (int i = skchar.length;  i > 0 ; i--) {
                    if ((bdchar != null) && (skchar[i-1] == bdchar[i-1] || skchar[i-1] =='*' || bdchar[i-1] =='*') && (b ==true)){

                    }else {
                        b = false;
                        break;
                    }

                }
                if(b == true) bd.select();
            }
        }
    }

    public void boardUnselect() {
        for (GroupBoard bd: arrBd) {
            bd.unselect();
        }
    }
}
