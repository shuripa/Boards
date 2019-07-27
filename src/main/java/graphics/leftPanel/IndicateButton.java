package graphics.leftPanel;

import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.controllers.LeyoutComponentController;
import graphics.leyout.controllers.LeyoutCompositController;
import sets.SetCompositControllers;

import java.util.ArrayList;

public class IndicateButton extends LeyoutComponent {

    int countWorkPlace;
    double sumEffectivity;
    ArrayList<LeyoutCompositController> setControllers;

    public IndicateButton(){
        SetCompositControllers instance = SetCompositControllers.getInstance();
        setControllers = instance.getComponentControllers();

        for (LeyoutComponentController lcc: setControllers) {
            LeyoutComponent component = lcc.component();
            component.addComponentObserver(this);
            component.update();
        }
        update();
    }

    public int getCountWorkPlace() {
        return countWorkPlace;
    }

    public double getSumEffectivity() {
        return sumEffectivity;
    }

    @Override
    public void update() {
        countWorkPlace = 0;
        sumEffectivity = 0;
        for (LeyoutComponentController lcc: setControllers) {
            countWorkPlace = countWorkPlace + lcc.getCountWorkPlase();
            sumEffectivity = sumEffectivity + lcc.getSumEffectivity();
        }
        super.update();
    }

    @Override
    public String toString() {
        return null;
    }
}
