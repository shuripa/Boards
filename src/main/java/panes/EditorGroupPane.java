package panes;

import cards.controllers.BoardCardController;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

public class EditorGroupPane extends TitledPane {
    public EditorGroupPane (){
        VBox vBox = new VBox();
        BoardCardController bc = new BoardCardController("board");

//        ... {інші компоненти}


        vBox.getChildren().add(bc.view());
        this.setContent(new ScrollPane(vBox));
        this.setText("Editor");
    }
}
