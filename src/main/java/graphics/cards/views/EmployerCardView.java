package graphics.cards.views;


import graphics.cards.controllers.EmployerCardController;
import graphics.cards.controllers.PaneComponentController;
import graphics.leyout.components.LeyoutComponent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class EmployerCardView extends PaneComponentView {

    Text ti, td, tp;
    Image im;
    ImageView imv;

    public EmployerCardView(PaneComponentController controller){
        super (controller);
        ti = new Text("");
        td = new Text("");
        tp = new Text("");

    }

    public void paint() {
        //Rectangle card
        Rectangle rc = new Rectangle(220, 50);
        rc.setId("blank");
        rc.setStrokeWidth(0.5);
        rc.relocate(.5, .5);

        //ti
        ti.setFont(new Font(11));
        ti.setX(45);
        ti.setY(12);

        //td
        td.setFont(new javafx.scene.text.Font(11));
        td.setX(45);
        td.setY(24);

        //tp
        tp.setFont(new javafx.scene.text.Font(11));
        tp.setX(45);
        tp.setY(36);

        //image
        imv = new ImageView();
        String id = ((EmployerCardController)controller()).getId();
        try {
            String url = new StringBuilder().append("Employers/images").append(id).append(".jpg").toString();
//            String url = "src\\main\\resources\\Employers\\images" + id + ".jpg";
            im = new Image(url, 30, 40, true, true);
            imv = new ImageView(im);
            imv.relocate(5, 5);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        addActiveElement(rc);
        addTexts(td, ti, tp);
        addNode(imv);
    }

    @Override
    public void setComponentProperties() {

    }

    @Override
    protected LeyoutComponent component() {
        return null;
    }

    @Override
    public void setViewProperties() {
        ti.setText("" + ((EmployerCardController)controller()).getId());
        td.setText("" + ((EmployerCardController)controller()).getName());
        tp.setText("" + ((EmployerCardController)controller()).getPhone());
    }

    @Override
    public void repaint() {
//        ti.setText("" + ((EmployerCardController)controller()).getId());
//        td.setText("" + ((EmployerCardController)controller()).getName());
//        tp.setText("" + ((EmployerCardController)controller()).getPhone());
    }

}
