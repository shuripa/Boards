package graphics.leyout.controllers;


import graphics.leyout.components.EffectivityIndex;
import graphics.leyout.components.WorkPlacedComposit;
import graphics.leyout.views.EffectivityIndexView;

import java.io.IOException;

public class EffectivityIndexController extends LeyoutComponentController
{
    public EffectivityIndexController() throws IOException{
        setView(new EffectivityIndexView(this));
    }

    public EffectivityIndexController(EffectivityIndex index) throws IOException {
        super(index);
        setView(new EffectivityIndexView(this));
    }

    public double getIndexValue(){
        return ((EffectivityIndex)component()).getTotalEffectivity();
    }

    public void setText(){
        String text;
        if (((WorkPlacedComposit)component().parent()).getWorkPlace().isLogined()) {
            text = "" + ((EffectivityIndex)component()).getTotalEffectivity() + "%";
        } else {
            text = "0.0%";
        }
        ((EffectivityIndexView)view()).setText(text);
    }

    @Override
    protected void setComponentProperties() {
        setIntProperty(((EffectivityIndex)component()).effectivityProperty());
    }

    @Override
    public void update(){
        setText();
        super.update();
    }
}
