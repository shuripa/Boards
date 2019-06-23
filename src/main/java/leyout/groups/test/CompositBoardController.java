package leyout.groups.test;

import javafx.scene.Node;
import leyout.LeyoutComponentController;
import leyout.controllers.*;
import leyout.LeyoutComponentWiev;
import model.Order;

import java.util.ArrayList;

public class CompositBoardController extends LeyoutComponentController {
    //Components
    CompositBoardWiev gbw;
    CompositBoard gbm;
    //Leaf
    HumanController hc;
    BoardController bc;
    BoardIndexController bic;
    GridController gc;

    public CompositBoardController(int id, String dsc, int size, int x, int y, double a){
        hc = new HumanController();
        bc = new BoardController(id, dsc, size);
        gc = new GridController(size);
        bic = new BoardIndexController(this, 70);

        gbw = new CompositBoardWiev(this, size, x, y, a);
        gbm = new CompositBoard(this);
    }

    public LeyoutComponentWiev getHumanShape() {
        return hc.getWievAsSuper();
    }

    public LeyoutComponentWiev getBoardShape() {
        return bc.getWievAsSuper();
    }

    public LeyoutComponentWiev getBoardIndex(){
        return bic.getWievAsSuper();
    }

    public LeyoutComponentWiev getGridShape() {
        return gc.getWievAsSuper();
    }

    public leyout.LeyoutComponentController getGridController(){
        return gc;
    }

    public leyout.LeyoutComponentController getHumanController() {
        return hc;
    }

    public Node getView() {
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