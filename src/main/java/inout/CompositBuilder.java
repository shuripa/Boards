package inout;

import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.controllers.LeyoutComponentController;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class CompositBuilder {

    private int id;
    private String tp;
    private String title;
    private int x;
    private int y;
    private int a;
    private int s;
    private int leafs;
    private int cards;
    private int employer;
    private String profession;
    private String side;
    private int parid;
    private String stepName;
    private int stepLevel;
    private ArrayList<String> conditions;
    private ArrayList<String> bindings;

    public CompositBuilder(int id, String tp) {
        this.id = id;
        this.tp = tp;
        title = "";
        parid = 0;
        x = 100;
        y = 100;
        a = 0;
        s = 60;
        leafs = 0;
        cards = 0;
        employer = 0;
        profession = "";        // Заменить объектом
        side = "";              // Заменить объектом
        stepName = "";
        stepLevel = 0;
        conditions = new ArrayList<>();
        bindings = new ArrayList<>();
    }

    public CompositBuilder title(String title){
        this.title = title;
        return this;
    }

    public CompositBuilder xyas(int x, int y, int a, int s){
        this.x = x;
        this.y = y;
        this.a = a;
        this.s = s;
        return this;
    }

    public CompositBuilder leafs(int val){
        leafs = val;
        return this;
    }

    public CompositBuilder cards(int val) {
        cards = val;
        return this;
    }

    public CompositBuilder assigned(int val){
        employer = val;
        return this;
    }

    public CompositBuilder profession(String val){
        profession = val;
        return this;
    }

    public CompositBuilder side(String val){
        side = val;
        return this;
    }

    public CompositBuilder parid(int val){
        parid = val;
        return this;
    }

    public CompositBuilder stepName(String val){
        stepName = val;
        return this;
    }

    public CompositBuilder stepLevel(int val){
        stepLevel = val;
        return this;
    }

    public CompositBuilder conditions(ArrayList<String> val){
        conditions = val;
        return this;
    }

    public CompositBuilder bindings(ArrayList<String> val){
        bindings = val;
        return this;
    }


    public int getId() {
        return id;
    }

    public String getTp() {
        return tp;
    }

    public String getTitle() {
        return title;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getA() {
        return a;
    }

    public int getS() {
        return s;
    }

    public int getLeafs() {
        return leafs;
    }

    public int getCards() {
        return cards;
    }

    public int getEmployer() {
        return employer;
    }

    public String getProfession() {
        return profession;
    }

    public String getSide() {
        return side;
    }

    public int getParid() {
        return parid;
    }

    public String getStepName() {
        return stepName;
    }

    public int getStepLevel() {
        return stepLevel;
    }

    public ArrayList<String> getConditions() {
        return conditions;
    }

    public ArrayList<String> getBindings() {
        return bindings;
    }

    public LeyoutComponent build() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        LeyoutComponent component;
        LeyoutComponentController controller;

        String componentClassName, contrlollerClassName;
        Class<?> componentClass, controllerClass;
        Constructor<?> componentConstructor, controllerConstructor;

        componentClassName = "graphics.leyout.components."+tp;
        componentClass = Class.forName(componentClassName);
        componentConstructor = componentClass.getConstructor(inout.CompositBuilder.class);
        component = (LeyoutComponent) componentConstructor.newInstance(this);

        contrlollerClassName = "graphics.leyout.controllers."+tp+"Controller";
        controllerClass = Class.forName(contrlollerClassName);
        controllerConstructor = controllerClass.getConstructor(graphics.leyout.components.LeyoutComponent.class, inout.CompositBuilder.class);
        controller = (LeyoutComponentController)controllerConstructor.newInstance(component, this);

        return component;
    }
}
