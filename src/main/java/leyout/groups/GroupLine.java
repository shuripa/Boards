package leyout.groups;

import leyout.wievs.LeyoutElementWiev;
import javafx.scene.shape.Shape;

public class GroupLine extends LeyoutElementWiev {

    private static GroupLine instance;

    public static GroupLine getInstance(){
        if (instance == null) {
            instance = new GroupLine();
        }
        return instance;
    }

    private GroupLine(){

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

    protected void paint(){

    }

    @Override
    public void setSize(int size) {

    }

    @Override
    public void reset() {

    }
}
