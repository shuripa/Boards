package graphics.editor;

import graphics.editor.components.*;
import graphics.cards.controllers.BoardCardElement;
import graphics.editor.controllers.EditorButtonElement;
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



        BoardCardElement bc = new BoardCardElement("board");
        vBox.getChildren().addAll(bc.view());


        EditorButtonElement button;

        button = new EditorButtonElement(new CompositBoardButton(), 50);
        root.getChildren().add(button.view());

        button = new EditorButtonElement(new CompositTestTableButton(), 120);
        root.getChildren().add(button.view());

        button = new EditorButtonElement(new CompositMaoButton(), 30);
        root.getChildren().add(button.view());

        button = new EditorButtonElement(new CompositInformTableButton(), 50);
        root.getChildren().add(button.view());

        button = new EditorButtonElement(new CompositManagerTableButton(), 100);
        root.getChildren().add(button.view());

        button = new EditorButtonElement(new CompositPushCartButton(), 50);
        root.getChildren().add(button.view());

        button = new EditorButtonElement(new CompositCanbanButton(), 220);
        root.getChildren().add(button.view());

        button = new EditorButtonElement(new CompositConvierButton(), 220);
        root.getChildren().add(button.view());




//        ... {інші компоненти}


//        this.setContent(new ScrollPane(vBox));
        this.setContent(root);
        this.setText("Editor");
        this.setWidth(250);
    }
}
