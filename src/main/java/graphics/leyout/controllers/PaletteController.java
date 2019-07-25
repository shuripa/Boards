package graphics.leyout.controllers;

import graphics.leyout.components.Palette;
import graphics.leyout.views.PaletteView;
import javafx.scene.input.MouseButton;

import java.io.IOException;

public class PaletteController extends LeyoutComponentController{

    public PaletteController(Palette palette) throws IOException {
        super(palette);
        setView(new PaletteView(this));
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
