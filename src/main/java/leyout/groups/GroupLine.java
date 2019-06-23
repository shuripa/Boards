package leyout.groups;

import javafx.scene.input.MouseButton;
import leyout.LeyoutComponentWiev;
import javafx.scene.shape.Shape;

public class GroupLine extends LeyoutComponentWiev {

    private static GroupLine instance;

    public static GroupLine getInstance(){
        if (instance == null) {
            instance = new GroupLine();
        }
        return instance;
    }

    private GroupLine(){

    }

    @Override
    protected void setEventTonExt(MouseButton button) {

    }

    @Override
    protected void getElements() {

    }

    @Override
    protected void emplacement(int size) {

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

    @Override
    public void showInfo() {

    }
}
