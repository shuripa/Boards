package panes;

import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import graphics.views.EmployerGroupPane;

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
        this.getPanes().add(new EditorGroupPane());


//         !!! Карточки клиентов !!! Класс возвращает VBox.
        this.getPanes().add(new EmployerGroupPane());

//         !!! Панель свойств
        this.getPanes().add(PropertyPane.getInstance());
    }


    public static RightPanel getInstance(){
        if (instance == null) {
            instance = new RightPanel();
        }
        return instance;
    }

}
