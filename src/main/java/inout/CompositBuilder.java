package inout;

import graphics.leyout.components.LeyoutComponent;
import graphics.leyout.controllers.LeyoutComponentController;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompositBuilder {
    private static final Logger logger = Logger.getLogger("MainApp");
    private int id;
    private String type;
    private String title;
    private int x;
    private int y;
    private int a;
    private int s;
    private int sections;
    private int leafs;
    private int employer;
    private String profession;
    private String side;
    private int parid;
    private String stepName;
    private int stepLevel;
    private String condition;
//    private ArrayList<String> conditions;
    private ArrayList<String> bindings;
    private String materialStoreViewType;
    private String toolViewType;
    private String toolWorkPlaceType;
    private String productStoreViewType;
    private String compositToolView;

    public CompositBuilder(int id, String title, String type) {
        this.id = id;
        this.type = type;
        this.title = title;
        parid = 0;
        x = 100;
        y = 100;
        a = 0;
        s = 60;
        sections = 0;
        leafs = 0;
        employer = 0;
        profession = "";        // Заменить объектом
        side = "";              // Заменить объектом
        stepName = "";
        stepLevel = 0;
        condition = "";
//        conditions = new ArrayList<>();
        bindings = new ArrayList<>();
    }

    public CompositBuilder xyas(int x, int y, int a, int s){
        this.x = x;
        this.y = y;
        this.a = a;
        this.s = s;
        return this;
    }

    public CompositBuilder sections(int val){
        sections = val;
        return this;
    }

    public CompositBuilder leafs(int val) {
        leafs = val;
        return this;
    }

    public CompositBuilder employer(int val){
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

    public CompositBuilder condition(String val){
        condition = val;
        return this;
    }

    public CompositBuilder bindings(ArrayList<String> values){
        bindings = values;
        return this;
    }

    public CompositBuilder materialStoreView(String type){
        this.materialStoreViewType = type;
        return this;
    }

    public CompositBuilder toolView(String type){
        this.toolViewType = type;
        return this;
    }

    public CompositBuilder workPlaceView(String type){
        this.toolWorkPlaceType = type;
        return this;
    }

    public CompositBuilder productStoreView(String productStoreViewType) {
        this.productStoreViewType = productStoreViewType;
        return this;
    }

    public CompositBuilder compositToolView(String compositToolView) {
        this.compositToolView = compositToolView;
        return this;
    }


    public int getId() {
        return id;
    }

    public String getType() {
        return type;
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

    public int getSections() {
        return sections;
    }

    public int getLeafs() {
        return leafs;
    }

    public int getEmployeeId() {
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

    public String getConditionString() {
        return condition;
    }

    public ArrayList<String> getBindings() {
        return bindings;
    }

    public String getMaterialStoreViewType(){
        return materialStoreViewType;
    }

    public String getToolViewType() {
        return toolViewType;
    }

    public String getToolWorkPlaceType() {
        return toolWorkPlaceType;
    }

    public String getProductStoreView() {
        return productStoreViewType;
    }

    public String getCompositToolView() {
        return compositToolView;
    }

    public LeyoutComponent build()  {
        LeyoutComponent component = null;
        LeyoutComponentController controller;

        String componentClassName, contrlollerClassName;
        Class<?> componentClass, controllerClass;
        Constructor<?> componentConstructor, controllerConstructor;

        componentClassName = "graphics.leyout.components."+ type;
        contrlollerClassName = "graphics.leyout.controllers."+ type +"Controller";

        try {
            componentClass = Class.forName(componentClassName);
            controllerClass = Class.forName(contrlollerClassName);
            try {
                componentConstructor = componentClass.getConstructor(CompositBuilder.class);
                controllerConstructor = controllerClass.getConstructor(LeyoutComponent.class, CompositBuilder.class);
                try {
                    component = (LeyoutComponent) componentConstructor.newInstance(this);
                    controller = (LeyoutComponentController)controllerConstructor.newInstance(component, this);
                } catch (InstantiationException e) {
                    logger.log(Level.WARNING, "Ошибка билдера:", e);
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    logger.log(Level.WARNING, "Ошибка билдера:", e);
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    logger.log(Level.WARNING, "Ошибка билдера:", e);
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                logger.log(Level.WARNING, "Ошибка билдера:", e);
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            logger.log(Level.WARNING, "Ошибка билдера:", e);
            e.printStackTrace();
        }

        return component;
    }
}
