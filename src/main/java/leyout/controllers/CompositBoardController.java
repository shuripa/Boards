package leyout.controllers;

import javafx.scene.Node;
import leyout.views.LeyoutComponentView;
import leyout.component.CompositBoard;
import leyout.views.CompositBoardView;
import model.Order;

import java.util.ArrayList;

public class CompositBoardController extends LeyoutComponentController {
    //Components
    CompositBoardView gbw;
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

        gbw = new CompositBoardView(this, size, x, y, a);
        gbm = new CompositBoard(this);
    }

    public LeyoutComponentView getHumanShape() {
        return hc.getWievAsSuper();
    }

    public LeyoutComponentView getBoardShape() {
        return bc.getWievAsSuper();
    }

    public LeyoutComponentView getBoardIndex(){
        return bic.getWievAsSuper();
    }

    public LeyoutComponentView getGridShape() {
        return gc.getWievAsSuper();
    }

    public LeyoutComponentController getGridController(){
        return gc;
    }

    public LeyoutComponentController getHumanController() {
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