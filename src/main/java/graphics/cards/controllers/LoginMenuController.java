package graphics.cards.controllers;

import graphics.leyout.components.WorkPlacedComposit;
import graphics.leyout.controllers.LeyoutComponentController;
import graphics.leyout.controllers.LeyoutWorkPlacedController;
import model.Employee;
import sets.SetWorkPlesedControllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class LoginMenuController extends PaneComponentController {

    ArrayList<PaneComponentController> cards;
    Employee employee;
    MenuConteinerController menu;
    SetWorkPlesedControllers setControllers;

    HashMap<Integer, ArrayList<LeyoutWorkPlacedController>> controllers;
    LoginCardController card;

    public LoginMenuController(PaneComponentController parent, Employee employee) {
        this.employee = employee;
        setControllers = SetWorkPlesedControllers.getInstance();
        menu = new MenuConteinerController(parent);
//        controllers = new HashMap<>();
        controllers = setControllers.getControllersToEmployer(employee);

        String productivity;

        for (int priority = 1; priority < 10; priority++) {
            if (controllers.containsKey(priority)){
                for (LeyoutWorkPlacedController controller: controllers.get(priority)) {
                    String sProd = "-";



//                    int count=0;
//                    double prod=0;
//                    for (Condition condition: controller.component().getConditions()) {
//                        count = 0;
//                        prod = 0;
//                        for (Skill sk: employer.getSkills()) {
//                            if (condition.isSuited(sk)) {
//                                count = count + 1;
//                                prod = prod + sk.getProductivity();
//                            }
//                        }
//                    }
//                    if (prod != 0) {
//                        productivity = "" + (int)Math.ceil(prod/count) + "%";
//                    } else productivity = "-";

                    productivity = "" + employee.getProductivity((WorkPlacedComposit)controller.component()) + "%";

                    card = new LoginCardController(controller, employee, priority, productivity);
                    menu.addCard(card);
                }
            }
        }
        menu.show();
    }


    @Override
    protected LeyoutComponentController createLeyautComponent(double x, double y) throws IOException {
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
