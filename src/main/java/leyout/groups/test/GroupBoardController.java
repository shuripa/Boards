package leyout.groups.test;

import javafx.scene.Node;
import leyout.controllers.*;
import leyout.wievs.LeyoutElementWiev;
import model.Order;

import java.util.ArrayList;

public class GroupBoardController extends LeyoutGroupController{
    //Components
    GroupBoardWiev gbw;
    GroupBoard gbm;
    //Leaf
    HumanController hc;
    BoardController bc;
    BoardIndexController bic;
    GridController gc;

    public GroupBoardController(int id, String dsc, int size, int x, int y, double a){
        hc = new HumanController();
        bc = new BoardController(id, dsc, size);
        gc = new GridController(size);
        bic = new BoardIndexController(this, 70);

        gbw = new GroupBoardWiev(this, size, x, y, a);
        gbm = new GroupBoard(this);
    }

    public LeyoutElementWiev getHumanShape() {
        return hc.getWievAsSuper();
    }

    public LeyoutElementWiev getBoardShape() {
        return bc.getWievAsSuper();
    }

    public LeyoutElementWiev getBoardIndex(){
        return bic.getWievAsSuper();
    }

    public LeyoutElementWiev getGridShape() {
        return gc.getWievAsSuper();
    }

    public LeyoutElementController getGridController(){
        return gc;
    }

    public LeyoutElementController getHumanController() {
        return hc;
    }

    public Node getWieve() {
        return gbw;
    }

    public void setCondition(String condition) {
        bc.setCondition(condition);
    }

    public void setID(int id) {
        bc.setID(id);
    }

    public void setTitle(String title) {
        bc.setTitle(title);
    }

    public void addOrder(Order order) {
        bic.addOrder(order);
    }

    public void setLogining(int empID) {
        hc.setLogining(empID);
    }

    public Integer getID() {
        return bc.getId();
    }

    public String getTitle() {
        return bc.getTitle();
    }

    public void addMateril(String material) {
        gc.addMaterial(material);
    }

    public void setMaterials(ArrayList<String> materials) {
        gc.setMaterials(materials);
    }
}