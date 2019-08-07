package graphics.editor;

import graphics.editor.components.*;
import graphics.cards.controllers.BoardCardController;
import graphics.editor.controllers.EditorButtonController;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class EditorGroupPane extends TitledPane {
    public EditorGroupPane () throws IOException {
        VBox vBox = new VBox();
        FlowPane root = new FlowPane();
        root.setMaxWidth(250);
        root.setVgap(10);
        root.setHgap(10);
        root.snapSpaceX(10);
        root.snapSpaceY(10);



        BoardCardController bc = new BoardCardController("board");
        vBox.getChildren().addAll(bc.view());


        EditorButtonController button;

        button = new EditorButtonController(new CompositBoardButton(), 50);
        root.getChildren().add(button.view());

        button = new EditorButtonController(new CompositTestTableButton(), 120);
        root.getChildren().add(button.view());

        button = new EditorButtonController(new CompositMaoButton(), 30);
        root.getChildren().add(button.view());

        button = new EditorButtonController(new CompositInformTableButton(), 50);
        root.getChildren().add(button.view());

        button = new EditorButtonController(new CompositManagerTableButton(), 100);
        root.getChildren().add(button.view());

        button = new EditorButtonController(new CompositPushCartButton(), 50);
        root.getChildren().add(button.view());

        button = new EditorButtonController(new CompositCanbanButton(), 220);
        root.getChildren().add(button.view());

        button = new EditorButtonController(new CompositConvierButton(), 220);
        root.getChildren().add(button.view());




//        ... {інші компоненти}


//        this.setContent(new ScrollPane(vBox));
        this.setContent(root);
        this.setText("Editor");
        this.setWidth(250);
    }
}
