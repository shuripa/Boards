package graphics.cards.controllers;

import graphics.cards.views.EmployerCardView;
import graphics.leyout.components.LeyoutComposit;
import graphics.leyout.components.WorkPlace;
import graphics.leyout.controllers.LeyoutComponentController;
import model.Employer;
import model.Profession;
import model.ProfessionColor;
import sets.SetCompositControllers;

import java.io.IOException;

public class EmployerCardController extends PaneComponentController
{

    public EmployerCardController(Employer component){
        super(component);
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


    public void boardSelect() {
        SetCompositControllers set = SetCompositControllers.getInstance();
        set.selectControllersToEmployer((Employer)component());
    }

    public void boardUnselect() {
        for (LeyoutComponentController componentController: SetCompositControllers.getInstance().getComponentControllers()) {
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

            LoginMenuController loginMenu = new LoginMenuController(this, (Employer)component());

        });
    }

    //TODO: Створення WorkPlace, в цьому класі не потрібно
    @Override
    protected LeyoutComponentController createLeyoutComponent(double x, double y) throws IOException {
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

    public int getPriority(){
        if (((Employer)component()).getWorkPlase() != null)
        return  ((Employer)component()).getWorkPlase().getPriority();
        else return 9;
    }

    public String getWorkPlaceTitle() {
        String result = "";
        WorkPlace wp = ((Employer)component()).getWorkPlase();
        if (wp != null && wp.parent()!=null){
            result =  ((LeyoutComposit)wp.parent()).getTitle() + "  " + ((LeyoutComposit)wp.parent()).getId();
        } else {
            System.out.println("WARNING: WorkPlace or WorkPlace.paren is null");
        }
        return result;
    }
}
