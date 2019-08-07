package graphics.leftpanel;

import graphics.leftpanel.controllers.BindControlButtonController;
import graphics.leftpanel.controllers.IndexButtonController;
import graphics.leftpanel.components.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Popup;

import java.io.IOException;

public class LeftPanel extends Popup {
    Rectangle msgRect;

    private static LeftPanel instance;

    private LeftPanel() throws IOException {
        this.setHideOnEscape(true);

//        Group root = new Group();
//        root.relocate(0, 25);

        Rectangle msgRect = new Rectangle( 0, 25, 50, 845);
        msgRect.setStyle("-fx-fill: RGBA(47,79,79,1.0); -fx-stroke: SlateGray; -fx-stroke-width: 0.5");
        getContent().add(msgRect);

        BindControlButtonController bbc = new BindControlButtonController(new BindControlButton(this));
        bbc.setXY(37, 28);
        setAutoHide(true);

        // Кількість людей на зміні
        IndexCountEmloyes indexCountEmloyes = new IndexCountEmloyes("Кількість людей на зміні", "");
        IndexButtonController indexCountEmployesController = new IndexButtonController(indexCountEmloyes);
        indexCountEmployesController.setXYAS(25, 60, 0, 24);

        //Кількість робочих місць
        IndexCountWorkPlace countWorkPlace = new IndexCountWorkPlace("Кількість робочих місць", "");
        IndexButtonController countWorkPkaceController = new IndexButtonController(countWorkPlace);
        countWorkPkaceController.setXYAS(25, 115, 0, 24);

        //Кількість вільних робочих місць
        IndexButton countFreeWorkPlace = new IndexFreeWorkPlace("Кількість незадіяних робочих місць", "");
        IndexButtonController countFreeWorkPlaceController = new IndexButtonController(countFreeWorkPlace);
        countFreeWorkPlaceController.setXYAS(45, 115, 0, 10);

        //Показник ефективності розподілу. Розподіл. Вивільнення.
        IndexButton dispersion = new IndexDispersion("Ефективність розподілу працівників на робочих місцях", "%");
        IndexButtonController dispersionController = new IndexButtonController(dispersion);
        dispersionController.setXYAS(25, 200, 0 ,24);

        getContent().addAll(
                countWorkPkaceController.view(),
                countFreeWorkPlaceController.view(),
                indexCountEmployesController.view(),
                dispersionController.view()
        );

        getContent().add(bbc.view());   //кнопка

    }

    public static LeftPanel getInstance(){
        if (instance == null){
            try {
                instance = new LeftPanel();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

}
