package panes;

import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import leyout.views.EmployerGroupView;

public class RightPanel extends Accordion {
    private static RightPanel instance;

    private RightPanel(){

//         !!! План !!! Сам класс наследуется от TitledPane
        this.getPanes().add(new PlanPane());

//         !!! Материал !!! Заглушка для материала
        VBox materialBox = new VBox();
        // Можно так. Тут создается TitledPane и сразу добавляется,
        // но не очевидно что здесь происходит.
        this.getPanes().add(new TitledPane("Material", materialBox));

//         !!! Редактор !!! Заглушка для редактор лейаута. (Иконки объектов лейаута)
        VBox editorBox = new VBox();
        TitledPane editPane = new TitledPane("Editor", editorBox);

//         !!! Карточки клиентов !!! Класс возвращает VBox.
        // TODO: переделать по образцу плана
        EmployerGroupView gec = new EmployerGroupView();
        TitledPane gecPane = new TitledPane("Employes", gec.getBox());

        this.getPanes().addAll(editPane, gecPane);

//         !!! Набор свойств. !!!

//        Label l1 = new Label("X");
//        Label l2 = new Label("Y");
//        Label l3 = new Label("A");
//        TextField t1 = new TextField("600");
//        TextField t2 = new TextField("0");
//        TextField t3 = new TextField("180");
//        HBox h1 =new HBox(l1, t1);
//        HBox h2 =new HBox(l2, t2);
//        HBox h3 =new HBox(l3, t3);
//        VBox propertyBox = new VBox();
//        propertyBox.getChildren().addAll(h1, h2, h3);


        this.getPanes().add(PropertyPane.getInstance());
//        PropertyPane.getInstance().setContent(propertyBox);
    }


    public static RightPanel getInstance(){
        if (instance == null) {
            instance = new RightPanel();
        }
        return instance;
    }

}
