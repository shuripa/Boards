package graphics.cards.controllers;

import graphics.Layout;
import graphics.cards.BoardMenu;
import graphics.cards.views.EmployerCardView;
import model.*;
import graphics.leyout.components.GroupBoard;
import graphics.leyout.components.WorkPlace;
import graphics.leyout.controllers.LeyoutComponentController;
import graphics.leyout.controllers.WorkPlaceController;
import sets.SetComponentControllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static graphics.Layout.getInstace;

public class EmployerCardController extends PaneComponentController
{
    EmployerCardView employerCardView;
    ArrayList<GroupBoard> arrBd;


    public EmployerCardController(Employer emp){
        super(emp);
        setView(new EmployerCardView(this));
    }

    public String getId(){
        return ((Employer)component()).getId();
    }

    public String getName() {
        return ((Employer)component()).getName();
    }

    public String getPhone() {
        return ((Employer)component()).getPhone();
    }


    public void boardSelect() throws IOException {
        Collection<Skill> arrSk = ((Employer)component()).getSkills();
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
            boardMenu.showBoard(140);
        });
    }

    @Override
    protected LeyoutComponentController createLeyoutComponent(double x, double y) throws IOException {
        Layout layout = getInstace();
        WorkPlace h = new WorkPlace();
        h.setEmployer((Employer)component());
        WorkPlaceController hc = new WorkPlaceController(h);
        hc.setXYAS((int)x, (int)y, 0, 0);
        layout.addComponentController(hc);
        return hc;
    }

    @Override
    public void updateData() {
        view().setViewProperties();
        if (((Employer)component()).isLogined()){
            view().activate();
        } else {
            view().disactivate();
            view().exited();
        }
    }

    @Override
    public void select() {

    }

    public String getProfessionColor(){
        Profession p =((Employer)component()).getProfession();
        return ProfessionColor.valueOf(p.name()).toString();
    }

    public String getProfession() {
        Profession p =((Employer)component()).getProfession();
        return p.toString();
    }

    public String getWorkPlaceTitle() {
        String result = "";
        WorkPlace wp = ((Employer)component()).getWorkPlase();
        if (wp != null && wp.parent()!=null){
            result =  wp.parent().getTitle() + "  " + wp.parent().getId();
        } else {
            System.out.println("WARNING: WorkPlace or WorkPlace.paren is null");
        }
        return result;
    }
}
