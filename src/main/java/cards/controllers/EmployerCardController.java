package cards.controllers;

import cards.BoardMenu;
import cards.views.EmployerCardView;
import graphics.Layout;
import graphics.components.Employer;
import graphics.components.GroupBoard;
import graphics.components.Human;
import graphics.controllers.HumanController;
import graphics.controllers.LeyoutComponentController;
import model.Condition;
import model.Skill;
import sets.SetComponentControllers;

import java.io.IOException;
import java.util.ArrayList;

import static graphics.Layout.getInstace;

public class EmployerCardController extends PaneComponentController
{
    EmployerCardView employerCardView;
    ArrayList<GroupBoard> arrBd;


    public EmployerCardController(Employer emp){
        super(emp);
        setView(new EmployerCardView(this));
//        viewEvents();
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
//        arrBd = Layout.getInstace().getArrBoards();
//        for (Skill sk: arrSk) {
//            for (GroupBoard bd: arrBd) {
////                System.out.print("sk " + sk.getMaterialBlank() + " bd " + bd.getCondition());
//                if ((sk.getMaterialBlank() != null) && (bd.getCondition() != null)) {
//                    skchar = sk.getMaterialBlank().toCharArray();
//                    bdchar = bd.getCondition().toCharArray();
//                }
//
//                Boolean b = true;
//                for (int i = skchar.length;  i > 0 ; i--) {
//                    if ((bdchar != null) && (skchar[i-1] == bdchar[i-1] || skchar[i-1] =='*' || bdchar[i-1] =='*') && (b ==true)){
//
//                    }else {
//                        b = false;
//                        break;
//                    }
//
//                }
//                if(b == true) bd.select();
//            }
//        }
        for (Skill skill: arrSk){
            SetComponentControllers set = SetComponentControllers.getInstance();
            for (LeyoutComponentController controller: set.getComponentControllers()) {
                for (Condition condition: controller.getConditions()) {
                    if (condition.isSuited(skill)){
                        controller.select();
                    }
                }
            }
        }
    }

    public void boardUnselect() {
        for (LeyoutComponentController componentController: SetComponentControllers.getInstance().getComponentControllers()) {
            componentController.unselect();
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

    @Override
    public void viewEvents(){
        super.viewEvents();

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
            BoardMenu boardMenu = new BoardMenu(this);

            for (Skill sk: ((Employer)component()).getSkills()) {
                if (sk != null) {
                    boardMenu.addCard(new SkillMenuCardController(sk));
                }
            }

            boardMenu.showBoard(145);
//            PropertyPane pp = PropertyPane.getInstance();
//            pp.addProperties(this, strProperties, intProperties);
//            new ShapeInfo(this);
        });

    }

    @Override
    protected LeyoutComponentController createLeyoutComponent(double x, double y) throws IOException {
        Layout layout = getInstace();
        Human h = new Human();
        h.setId(((Employer)component()).getId());
        HumanController hc = new HumanController(h);
        hc.setXYAS((int)x, (int)y, 0, 0);
        layout.addComponentController(hc);
        return hc;
    }

}
