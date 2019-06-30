package graphics.components;

import javafx.scene.shape.Shape;
import graphics.controllers.LeyoutComponentController;
import graphics.views.LeyoutComponentView;

public class GroupLine extends LeyoutComponentView {

    private static GroupLine instance;

    public static GroupLine getInstance(){
        if (instance == null) {
//            instance = new GroupLine();
        }
        return instance;
    }

    private GroupLine(LeyoutComponentController controller){
        super(controller);
    }


    public void add (Shape shapeConnection){
        getChildren().add(shapeConnection);
        shapeConnection.setId("blankbound");
    }

    public void rem(Shape shapeConnection){
        getChildren().remove(shapeConnection);
    }

    public void rem(){
        for (int j = getChildren().size(); j > 0; j--) {
            getChildren().remove(j-1);
        }
    }

    public void paint(){

    }

    @Override
    public void repaint() {

    }

}
