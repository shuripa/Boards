package graphics.leyout.views.tools;

import graphics.leyout.controllers.LeyoutComponentController;
import graphics.leyout.views.LeyoutComponentView;
import javafx.scene.text.Text;

public abstract class ToolView extends LeyoutComponentView {
    Text tt, ti;        //Text title, Text Id

    public ToolView(LeyoutComponentController controller){
        super (controller);
        //Тексты
        tt = new Text(0, 0, "tt" );   //description
        ti = new Text( 0, 0, "ti" );    //ID

    }

    @Override
    public void paint(){
        addTexts(tt, ti);
    };


    @Override
    public abstract void repaint();


    public void setTt(String tt) {
        this.tt.setText(tt);
    }

    public void setTi(String ti) {
        this.ti.setText(ti);
    }

}