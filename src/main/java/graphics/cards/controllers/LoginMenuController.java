package graphics.cards.controllers;

import graphics.leyout.controllers.LeyoutComponentController;
import graphics.leyout.controllers.LeyoutCompositController;
import model.Condition;
import model.Employer;
import model.Skill;
import sets.SetCompositControllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class LoginMenuController extends PaneComponentController {

    ArrayList<PaneComponentController> cards;
    Employer employer;
    MenuConteinerController menu;
    SetCompositControllers setComposit;

    HashMap<Integer, ArrayList<LeyoutCompositController>> controllers;
    LoginCardController card;

    public LoginMenuController(PaneComponentController parent, Employer employer) {
        this.employer = employer;
        setComposit = SetCompositControllers.getInstance();
        menu = new MenuConteinerController(parent);
        controllers = new HashMap<>();
        controllers = setComposit.getControllersToEmployer(employer);

        String productivity;

        for (int priority = 1; priority < 9; priority++) {
            if (controllers.containsKey(priority)){
                for (LeyoutCompositController controller: controllers.get(priority)) {
                    String sProd = "-";
                    int count=0;
                    double prod=0;
                    for (Condition condition: controller.component().getConditions()) {
                        count = 0;
                        prod = 0;
                        for (Skill sk: employer.getSkills()) {
                            if (condition.isSuited(sk)) {
                                count = count + 1;
                                prod = prod + sk.getProductivity();
                            }
                        }
                    }
                    if (prod != 0) {
                        productivity = "" + (int)Math.ceil(prod/count) + "%";
                    } else productivity = "-";
                    card = new LoginCardController(controller, employer, priority, productivity);
                    menu.addCard(card);
                }
            }
        }
        menu.show();
    }


    @Override
    protected LeyoutComponentController createLeyoutComponent(double x, double y) throws IOException {
        return null;
    }

    @Override
    public void updateData() {

    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public void select() {

    }
}
