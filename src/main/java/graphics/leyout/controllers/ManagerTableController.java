package graphics.leyout.controllers;

import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.components.ManagerTable;
import graphics.leyout.views.ManagerTableView;
import javafx.scene.input.MouseButton;
import model.Profession;
import model.Side;

import java.io.IOException;

public class ManagerTableController extends LeyoutComponentController {

    public ManagerTableController(LeyoutComponent component, LeyoutCompositController parent) throws IOException {
        super(component);
        setParent(parent);
        setView(new ManagerTableView(this));
    }

    public Side getSide(){
        return ((ManagerTable)component()).getSide();
    }

    public Profession getProfession() {
        return parent().component().getWorkPlace().getProfession();
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
}
