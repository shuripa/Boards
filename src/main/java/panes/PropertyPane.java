package panes;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import leyout.controllers.LeyoutComponentController;

import java.util.ArrayList;

public class PropertyPane extends TitledPane {
    private static PropertyPane instance;
    private LeyoutComponentController sender;
    private static ArrayList<StringProperty> stringProperties;
    private static ArrayList<IntegerProperty> intProperties;

    private PropertyPane(){
        this.setText("Property");
        clear();
    }

    public static PropertyPane getInstance(){
        if (instance == null) {
            instance = new PropertyPane();
        }
        return instance;
    }

    public void addProperties (LeyoutComponentController sender, ArrayList<StringProperty> stringProperties, ArrayList<IntegerProperty> intProperties){
        clear();
        if (stringProperties != null && stringProperties.size()>0) {
            for (StringProperty sp : stringProperties) {
                this.stringProperties.add(sp);
            }
        }
        if (intProperties != null && intProperties.size()>0) {
            for (IntegerProperty ip : intProperties) {
                this.intProperties.add(ip);
            }
        }
        this.sender = sender;
        refresh();
    }

    private void refresh() {
        VBox content = new VBox();

        if (stringProperties.size()>0) {
            for (StringProperty sp : stringProperties) {
                TextField tp = new TextField(sp.getValue());

                tp.setOnKeyReleased(keyEvent -> {
                    sp.setValue(tp.getText());
                    sender.update();
                });

                HBox str = new HBox();
                str.getChildren().addAll(new Label(sp.getName()), tp);
                str.setSpacing(5);
                content.getChildren().add(str);
            }
        }

        if (intProperties.size() >0) {
            for (IntegerProperty ip : intProperties) {
                TextField tp = new TextField("" + ip.getValue());

                tp.setOnKeyReleased(keyEvent -> {
                    if (!(tp.equals("")) && (tp != null)) {
                        ip.setValue(Integer.parseInt(tp.getText()));
                        sender.update();
                    }
                });

                HBox str = new HBox();
                str.getChildren().addAll(new Label(ip.getName()), tp);
                str.setSpacing(5);
                content.getChildren().add(str);
            }
        }

        this.setContent(content);
    }

    public void clear(){
        stringProperties = new ArrayList<>();
        intProperties = new ArrayList<>();
    }

}
