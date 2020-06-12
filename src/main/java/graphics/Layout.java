package graphics;

import graphics.leyout.controllers.LeyoutComponentController;
import graphics.leyout.views.LeyoutComponentView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.input.KeyCode;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Region;
import panes.PropertyPane;
import panes.RightPanel;
import sets.SetEmployees;
import sets.SetInstructions;

public class Layout extends Region {

    private static Layout layout = null;
    private int cx, cy, dx, dy, ndx, ndy;                           //dragget coordinate
    private LeyoutComponentController dComponentController;         //dragget controller
    private TextInputControl t;                                 //Текстове поле для введення значень властивостей компонентів на лейауті

    private Layout() {
    }

    public static Layout getInstace() {
        if (layout == null){
            layout = new Layout();
        }
        return layout;
    }

    public void show() {
        SetInstructions instructions = SetInstructions.getInstance();
//        instructions.print();

        SetEmployees employes = SetEmployees.getInstance();

//        TODO: Умови для МАО можуть складатись з умов дошок які входять в МАО
//        TODO При неправильній назві завантажуються замовлення відповідно до назви
//        TODO При відсутності замовлень система падає
//        TODO В CompositBoard условие добавляется объектом.

        LayoutComponentLoader lcl = new LayoutComponentLoader();

//        TODO: перевести всі властивості в String
//        TODO: всі маніпуляції з властивостями по типу отримання робочого по ID або додавання контролеру в масив заховати в середину відповідних класів

        setEvents();
    }

    private void setEvents() {
        this.setOnDragEntered(dragEvent -> {
            RightPanel.getInstance().getPanes().get(4).setExpanded(true);
            System.out.println("On drag entered");
            System.out.println("Old: " + dx + "; " + dy);
            dx = (int)dragEvent.getSceneX();
            dy = (int)dragEvent.getSceneY();
            System.out.println("Scene: " + dragEvent.getSceneX() + "; " +dragEvent.getSceneY());
            dragEvent.consume();
        });

        this.setOnDragOver(dragEvent -> {
            dragEvent.acceptTransferModes(TransferMode.MOVE);
//            Проблема в том что не каждый компонент имеет parent
//            sin: 0: 0, 90: 1, 180:  0, 270: -1
//            cos: 0: 1, 90: 0, 180: -1, 270:  0

            ndx = (int)(dragEvent.getSceneX()-dx);
            ndy = (int)(dragEvent.getSceneY()-dy);
            double sin = 1;
            double cos = 1;
            if (dComponentController.parent() != null) {
                ndx = (int)Math.ceil(ndx*Math.cos(dComponentController.parent().A()));
                ndy = (int)Math.ceil(ndy*Math.cos(dComponentController.parent().A()));
            }
            dComponentController.setXY(cx+ndx, cy+ndy);
            System.out.println("On drag over " + ndx + "; " + ndy);
            dragEvent.consume();
        });

        this.setOnDragExited(dragEvent -> {
            System.out.println("On drag exited " + ndx + "; " + ndy);
            dComponentController.setXY(cx+ndx, cy+ndy);
            dragEvent.consume();
        });

        this.setOnDragDropped(dragEvent -> {
            System.out.println("On drag dropped");
            PropertyPane pp = PropertyPane.getInstance();
            pp.addProperties(dComponentController, dComponentController.getStrProperties(), dComponentController.getIntProperties());
            dragEvent.setDropCompleted(true);
            dragEvent.consume();
        });

        this.setOnDragDone(dragEvent -> {
            System.out.println("On drag done");
            dragEvent.consume();
        });

        this.setOnMouseClicked(mouseEvent -> {
            // Поле не появляется вообще. Проверка на null не помогает, кроме того она есть уже в самом deleteTextField()
//            if (t != null) {
//                deleteTextField();
//            }
        });
    }

//TODO: канбан контроллер  и канбан груп, нужны ли
//TODO: канбан контроллер нужно сделать не синглтоном, а зависящим от стока и от лейаута
//TODO: Слой соединений

    public void setdx(int sceneX) {
        dx = sceneX;
    }

    public void setdy(int sceneY) {
        dy = sceneY;
    }

    public void drugComponent (int x, int y, LeyoutComponentController controller){
        dx = x;
        dy = y;
        dComponentController = controller;
        cx = dComponentController.X();
        cy = dComponentController.Y();
        System.out.println(cx + " " + cy + " " + dx + " " + dy);
    }

    public void addComponentController(LeyoutComponentController componentController) {
        this.getChildren().add(componentController.view());
    }

    public void createTextField(LeyoutComponentController controller, double X, double Y) {
        deleteTextField();
        t = new TextField();
//        TODO только строчные свойства можно присоединить. ??? Переделать все свойства в строчные
//        Эта процедура для свойств типа been. Так что просто присоединить свойство не получится.
//        t.accessibleTextProperty(controller.getIntProperties());
//        t.accessibleTextProperty(controller.getTextProperty());
        t.relocate(X, Y);
        t.setOnKeyPressed(keyEvent -> {
            KeyCode keyCode = keyEvent.getCode();
            if (KeyCode.ENTER == keyCode || KeyCode.TAB == keyCode || KeyCode.ESCAPE == keyCode)  {
                deleteTextField();
            }
        });
        this.getChildren().add(t);
    }

    public void deleteTextField(){
        if (t != null){
            this.getChildren().remove(t);
            t = null;
        }
    }

    public void addView(LeyoutComponentView view){
        this.getChildren().add(view);
    }

    public void delView(LeyoutComponentView view){
        this.getChildren().remove(view);
    }

    public boolean isContainsView(LeyoutComponentView view) {
        if (getChildren().contains(view)) {
            return true;
        } else {
            return false;
        }
    }

}