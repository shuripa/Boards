package graphics.leftPanel;

import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.components.LeyoutComposit;
import graphics.leyout.components.WorkPlace;
import graphics.leyout.controllers.LeyoutComponentController;
import graphics.leyout.controllers.LeyoutCompositController;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import model.Employer;
import sets.Buffer;
import sets.SetCompositControllers;
import sets.SetEmployers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class IndicateButtonController extends LeyoutComponentController {

    Popup pp;

    public IndicateButtonController(LeyoutComponent index) throws IOException {
        super(index);
        setView(new IndicateButtonView(this));
        pp =new Popup();
        pp.setAutoHide(true);
        Text text = new Text("Ефективність розміщення працівників");
        pp.getContent().add(text);
        SetCompositControllers set = SetCompositControllers.getInstance();
        set.addObserver(this);
    }

    @Override
    protected void setComponentProperties() {

    }

    @Override
    protected void setDragEvent() {

    }

    @Override
    protected void setEventTonExt(MouseButton button) {

    }

    public void viewEvents() throws IOException {
        super.viewEvents();
        view().setOnMouseEntered(mouseEvent -> {
            select();
            pp.show(view(), 55, 40);
        });
        view().setOnMouseExited(mouseEvent -> {
            unselect();
            pp.hide();
        });
        view().setOnMouseClicked(mouseEvent -> {
//            ArrayList<Employer> arrEmployers = SetEmployers.getInstance().getEmployers();
            Buffer<Employer> bufferEmploers = SetEmployers.getInstance().getBufferEmploers();
            SetCompositControllers setControllers = SetCompositControllers.getInstance();
            HashMap<Integer, ArrayList<LeyoutCompositController>> controllers;
            WorkPlace wp;

            for (Employer employer: bufferEmploers) {
                System.out.println("WATHCING EMPLOYER: " + employer.getId());
                controllers = setControllers.getControllersToEmployer(employer);
                for (int i = 1; i<9; i++) {
                    if (employer.isLogined() && employer.getWorkPlase().getPriority() != 0 && employer.getWorkPlase().getPriority()<i) break;

                    if (controllers.containsKey(i)) {
                        for (LeyoutCompositController controller : controllers.get(i)) {
                            wp = controller.component().getWorkPlace();
                            if (wp.isLogined()) {
                                    if (wp.getPriority() == 0 || wp.getPriority() > i) {
//                                        b.remove(wp.getEmployer());
                                        free(bufferEmploers, wp);
                                        login(employer, i, controller);
                                    } else {
                                        int pem = employer.getProductivity((LeyoutComposit) controller.component());
                                        int pwp = wp.getEmployer().getProductivity((LeyoutComposit) controller.component());
                                        if (wp.getPriority() == i && pem > pwp){
//                                            arrEmployers.remove(wp.getEmployer());
                                            free(bufferEmploers, wp);
                                            login(employer, i, controller);
                                        }
                                    }
                            } else {
                                if (employer.isLogined()){
                                    int pem = employer.getProductivity((LeyoutComposit) controller.component());
                                    int pwp = employer.getProductivity((LeyoutComposit)employer.getWorkPlase().parent());
                                    if (pem > pwp){
                                        login(employer, i, controller);
                                    }
                                } else {
                                    login(employer, i, controller);
                                }
                            }
                        }
                    }
                        if (employer.isLogined()) break;
                }
            }
        });
    }

    private void free(Buffer<Employer> bufferEmploers, WorkPlace wp) {
        System.out.println("FREING: employer " + wp.getEmployer()
                + " free at place " + ((LeyoutComposit)wp.parent()).getId()
                + " with priority " + wp.getPriority());
        bufferEmploers.enque(wp.getEmployer());
    }

    private void login(Employer employer, int i, LeyoutCompositController controller) {
        controller.component().logining(employer, i);
        System.out.println("LOGINING: emloyer " + employer.getId()
                + " logined to " + ((LeyoutComposit)controller.component()).getId()
                + " with priority " + i);
    }


    public int getMediumEffectivity(){
        return (int)Math.ceil(((IndicateButton)component()).getSumEffectivity() /((IndicateButton)component()).getCountWorkPlace());
    }
}
