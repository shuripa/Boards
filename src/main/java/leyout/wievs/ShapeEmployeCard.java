package leyout.wievs;


import leyout.controllers.EmployerController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ShapeEmployeCard extends LeyoutElementWiev {
    private int size;
    private String id;
    private String description;
    private EmployerController employerController;

    public ShapeEmployeCard(String id, String description, int size){
        super ();
        this.id = id;
        this.description = description;
        this.size = size;
        paint ();
        this.setOnMouseClicked(e -> {

        });
        this.setOnMouseEntered(mouseEvent -> {
            super.entered();
            employerController.boardSelect();
        });
        this.setOnMouseExited(mouseEvent -> {
            super.exited();
            employerController.boardUnselect();
        });
    }

    protected void paint() {
        //Rectangle card
        Rectangle rc = new Rectangle(size, 50);
        rc.setId("blank");
        rc.setStrokeWidth(0.5);
        rc.relocate(.5, .5);

        //ti
        Text ti = new Text("" + id);
        ti.setFont(new Font(11));
        ti.setX(45);
        ti.setY(15);

        //td
        Text td = new Text("" + description);
        td.setFont(new javafx.scene.text.Font(11));
        td.setX(45);
        td.setY(30);

        //image
        Image im;
        ImageView imv = new ImageView();
        try {

            String url = new StringBuilder().append("Employers/images").append(id).append(".jpg").toString();
            im = new Image(url, 30, 40, true, true);
            imv = new ImageView(im);
            imv.relocate(5, 5);
        } catch (IllegalArgumentException e) {
        }

        addActiveElement(rc);
        addTexts(td, ti);
        addNode(imv);
//        this.getChildren().addAll(rc, td, ti, imv);
    }

    @Override
    public void setSize(int size) {

    }

    @Override
    public void reset() {

    }

    public void setEmployerController(EmployerController employerController) {
        this.employerController = employerController;
    }
}
