package graphics.cards.controllers;

import graphics.Layout;
import graphics.cards.BoardMenu;
import graphics.cards.views.EmployerCardView;
import graphics.leyout.components.Employer;
import graphics.leyout.components.GroupBoard;
import graphics.leyout.components.WorkPlace;
import graphics.leyout.controllers.LeyoutComponentController;
import graphics.leyout.controllers.WorkPlaceController;
import model.Condition;
import model.Skill;
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

}
