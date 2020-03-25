package graphics.cards.controllers;

import graphics.cards.views.EmployerCardView;
import graphics.leyout.components.WorkPlace;
import graphics.leyout.components.WorkPlacedComposit;
import graphics.leyout.controllers.LeyoutComponentController;
import graphics.leyout.controllers.LeyoutWorkPlacedController;
import model.Employee;
import model.Profession;
import model.ProfessionColor;
import sets.SetWorkPlesedControllers;

import java.io.IOException;

public class EmployerCardController extends PaneComponentController
{

    public EmployerCardController(Employee component){
        super(component);
        setView(new EmployerCardView(this));
    }

    public String getId(){
        return ((Employee)component()).getId();
    }

    public String getName() {
        return ((Employee)component()).getName();
    }

    public String getPhone() {
        return ((Employee)component()).getPhone();
    }


    public void boardSelect() {
        SetWorkPlesedControllers set = SetWorkPlesedControllers.getInstance();
        set.selectControllersToEmployer((Employee)component());
    }

    public void boardUnselect() {
        SetWorkPlesedControllers set = SetWorkPlesedControllers.getInstance();
        for (LeyoutWorkPlacedController componentController: set) {
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
            boardSelect();
        });

        view().setOnMouseExited(mouseEvent -> {
            view().exited();
            boardUnselect();
        });

        view().setOnMouseClicked(mouseEvent -> {
            //Контроллер карточки рабочего создает карточки меню скилов рабочего и само меню скилов
            //Меню контейнер это вид. нужно создать контроллер, который контролирует этот вид.
//            MenuConteiner menu = new MenuConteiner(this);
//
//            for (Skill sk: ((Employer)component()).getSkills()) {
//                if (sk != null) {
//                    menu.addCard(new SkillMenuCardController(sk));
//                }
//            }
//            menu.showConteiner(140);

            LoginMenuController loginMenu = new LoginMenuController(this, (Employee)component());

        });
    }

    //TODO: Створення WorkPlace, в цьому класі не потрібно
    @Override
    protected LeyoutComponentController createLeyautComponent(double x, double y) throws IOException {
//        Layout layout = getInstace();
//        WorkPlace h = new WorkPlace();
//        h.setEmployer((Employer)component());
//        WorkPlaceController hc = new WorkPlaceController(h);
//        hc.setXYAS((int)x, (int)y, 0, 0);
//        layout.addComponentController(hc);
//        return hc;
        return null;
    }

    @Override
    public void updateData() {
        view().setViewProperties();
        if (((Employee)component()).isLogined()){
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
        Profession p =((Employee)component()).getProfession();
        return ProfessionColor.valueOf(p.name()).toString();
    }

    public String getProfession() {
        Profession p =((Employee)component()).getProfession();
        return p.toString();
    }

    public int getPriority(){
        if (((Employee)component()).getWorkPlaсe() != null)
        return  ((Employee)component()).getWorkPlaсe().getPriority();
        else return 9;
    }

    public String getWorkPlaceTitle() {
        String result = "";
        WorkPlace wp = ((Employee)component()).getWorkPlaсe();
        if (wp != null && wp.parent()!=null){
            result =  ((WorkPlacedComposit)wp.parent()).getTitle() + "  " + ((WorkPlacedComposit)wp.parent()).getId();
        } else {
            System.out.println("WARNING: WorkPlace or WorkPlace.paren is null");
        }
        return result;
    }
}
