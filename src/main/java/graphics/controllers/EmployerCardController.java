package graphics.controllers;

import graphics.Layout;
import graphics.components.Employer;
import graphics.components.GroupBoard;
import graphics.views.EmployerCardView;
import model.Skill;

import java.io.IOException;
import java.util.ArrayList;

public class EmployerCardController extends PaneComponentController
{
    EmployerCardView employerCardView;
    ArrayList<GroupBoard> arrBd;
    char[] bdchar;
    char[] skchar;

    public EmployerCardController(Employer emp){
        super(emp);

        setView(new EmployerCardView(this));
        //        bdchar = null;
        //        skchar = null;
    }

    public int getId(){
        return ((Employer)component()).getID();
    }

    public String getName() {
        return ((Employer)component()).getName();
    }

    public String getPhone() {
        return ((Employer)component()).getPhone();
    }


    public void boardSelect() throws IOException {
        ArrayList<Skill> arrSk = ((Employer)component()).getSkills();
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


    @Override
    public void updateData() {
        view().setViewProperties();
    }

    @Override
    public String getText() {
        return null;
    }

    public void viewEvents(){

        view().setOnMouseEntered(mouseEvent -> {
            view().entered();
            try {
                boardSelect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        view().setOnMouseExited(mouseEvent -> {
            view().exited();
            boardUnselect();
        });

        view().setOnMouseClicked(mouseEvent -> {
//            PropertyPane pp = PropertyPane.getInstance();
//            pp.addProperties(this, strProperties, intProperties);
//            new ShapeInfo(this);
        });

    }

    @Override
    protected LeyoutComponentController createLeyoutComponent(double x, double y) throws IOException {
        return null;
    }

}
