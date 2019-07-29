package graphics.leftPanel;

import graphics.leyout.components.LeyoutComponent;
import javafx.stage.Popup;

public class BindControlButton extends LeyoutComponent {

    Popup observer;

    public BindControlButton(Popup observer) {
        this.observer = observer;
        setActive(true);
    }

    @Override
    public void setActive(boolean active) {
        super.setActive(active);
        observer.setAutoHide(active);
        if (active == true) {
            observer.hide();
        }
    }

    @Override
    public String toString() {
        return isActive() ? "Открепить панель" : "Закрепить панель";
    }
}
