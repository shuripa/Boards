package graphics.cards.controllers;

import graphics.cards.views.LoginCardView;
import graphics.leyout.components.WorkPlacedComposit;
import graphics.leyout.controllers.LeyoutComponentController;
import graphics.leyout.controllers.LeyoutCompositController;
import model.Employee;

import java.io.IOException;

public class LoginCardElement extends PaneComponentElement {

    String id;
    String title;
    String productivity;
    int priority;
    Employee employee;
    LeyoutCompositController compositController;

    public LoginCardElement(LeyoutCompositController controller, Employee employee, int priority, String productivity){
        super(controller.component());
        this.employee = employee;
        this.compositController = controller;
        this.id = ((WorkPlacedComposit)controller.component()).getId();
        this.title = ((WorkPlacedComposit)controller.component()).getTitle();
        this.priority = priority;
        this.productivity = productivity;
        setView(new LoginCardView(this));
    }

    @Override
    public LeyoutComponentController createLeyautComponent(double x, double y) throws IOException {
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

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getProductivity() {

//        String sProd = "-";
//        int count=0;
//        double prod=0;
//        for (Skill sk: employer.getSkills()) {
//            count = 0;
//            prod = 0;
//            for (Condition condition: compositController.component().getConditions()) {
//                if (condition.isSuited(sk)){
//                    count = count +1;
//                    prod = prod + sk.getProductivity();
//                }
//            }
//        }
//        if (prod != 0) {
//            sProd = "" + (int)Math.ceil(prod/count) + "%";
//        }
//        return sProd;
        return productivity;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public void viewEvents(){
        view().setOnMouseEntered(mouseEvent -> {
            view().entered(priority);
            compositController.select(priority);
        });
        view().setOnMouseExited(mouseEvent -> {
            view().exited();
            compositController.unselect();
        });
        view().setOnMouseClicked(mouseEvent -> {
//           view().
            ((WorkPlacedComposit)component()).logining(employee);
        });
    }

}
