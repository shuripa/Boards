package graphics.cards.views;


import graphics.cards.controllers.EmployerCardElement;
import graphics.cards.controllers.PaneComponentElement;
import graphics.leyout.components.LeyoutComponent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class EmployerCardView extends PaneComponentView {

    Text ti, td, tp, tprof, tw;
    Image im;
    ImageView imv;
    Rectangle rw;

    public EmployerCardView(PaneComponentElement controller){
        super (controller);
        ti = new Text("");
        td = new Text("");
        tp = new Text("");
        tprof = new Text("");
        tw = new Text("");
        rw = new Rectangle(0, 0, 100, 12);
    }

    public void paint() {
        //Rectangle card
        Rectangle rc = new Rectangle(220, 45);
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

        //Rectangle profession shape
        Rectangle rs = new Rectangle(7, 45);
        rs.relocate(213, 0);
        rs.setStyle("-fx-fill:" + ((EmployerCardElement)controller()).getProfessionColor());

        //text profession
        tprof.setFont(new javafx.scene.text.Font(11));
        tprof.setX(145);
        tprof.setY(36);

        //text workplace title
        tw.setFont(new javafx.scene.text.Font(11));
        tw.setX(100);
        tw.setY(12);

        //Rectangle work place priority shape
        rw.relocate(100, 2);
        rw.setId("select" + ((EmployerCardElement)controller()).getPriority());
        rw.setStrokeWidth(0.1);

        //image
        imv = new ImageView();
        String id = ((EmployerCardElement)controller()).getId();
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
        addTexts(td, ti, tp, tprof);
        addNode(imv);
        getChildren().addAll(rs, rw);
        addText(tw);
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
        ti.setText("" + ((EmployerCardElement)controller()).getId());
        td.setText("" + ((EmployerCardElement)controller()).getName());
        tp.setText("" + ((EmployerCardElement)controller()).getPhone());
        tprof.setText("" + ((EmployerCardElement)controller()).getProfession());
        tw.setText("" + ((EmployerCardElement)controller()).getWorkPlaceTitle());
        rw.setId("set" + ((EmployerCardElement)controller()).getPriority());
        rw.setStrokeWidth(0.1);

    }

    @Override
    public void repaint() {
//        ti.setText("" + ((EmployerCardController)controller()).getId());
//        td.setText("" + ((EmployerCardController)controller()).getName());
//        tp.setText("" + ((EmployerCardController)controller()).getPhone());
    }

}
