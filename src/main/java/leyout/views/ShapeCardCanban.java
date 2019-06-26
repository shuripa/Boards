package leyout.views;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import leyout.Infoable;
import leyout.components.GroupLeafCanban;
import leyout.controllers.CanbanController;
import leyout.controllers.StockController;
import stock.Stock;
import stock.Store;

import java.io.IOException;
import java.util.Queue;
/**
 * Карточка канбана или лыжа
 * это новый канбан отличный от ShapeCanban, который используется на тестовках
*/

public class ShapeCardCanban extends Group implements Infoable {
    StockController stockController;
    Stock stock;
    Store store;
    String title;                   //Название
    String material;                //Материал
    Double count;
    String stockTitle = "F5";
    private int cntAllOrd = 4;          //Всего заказов
    private int cntOrd = 1;             //Всего заказов заполнено материалом
    private Queue<Integer> OrdDef;      //Дефиниция каждого из загруженных заказов
    ShapeNode pEnt;                     //Точка входа
    ShapeNode pExt;                     //Точка выхода
    CanbanController topParent;
    GroupLeafCanban parent;


    public ShapeNode getExt() {
        return pExt;
    }

    public ShapeCardCanban(GroupLeafCanban parent, String title){
        super();
        this.parent = parent;
//        this.topParent = parent.getControl().getControl();
        this.title = title;


        this.getStylesheets().add("style.css");
        paint();

        try {
            stockController = StockController.getInstance();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stock = stockController.getStock(stockTitle);
        store = stock.getStore(title);
        if (store != null) {
            material = store.getMaterial();

//        TODO: убрать TOP
//        topParent.addExtNode(material, pExt);       //Наполнение хаш-мепа контроллера
            CanbanController.getInstance().addExtNode(material, pExt);  //Наполнение хаш-мепа контроллера

        }
        this.setOnMouseClicked(mouseEvent -> {
//            showInfo();
        });

//        paint();
    }

    public void paint() {

//        Circle pointIn = new Circle(2, 5, 2);
//        pointIn.setFill(Color.WHITE);
//        pointIn.setStroke(Color.GREY);
//        Прямоугольник
        Rectangle r = new Rectangle(0,0, 32, 10);
        r.setId("blank");
//        addActiveElement(r);
        this.getChildren().add(r);

        //индикаторы
        //точка входа
        pEnt = new ShapeNode(this);
        pEnt.relocate(0,2);
        CanbanController.getInstance().addEntNode(material, pEnt);


        this.getChildren().add(pEnt);


        for (int i = 0; i < cntAllOrd; i++) {
            Rectangle rect = new Rectangle(cntAllOrd*4+3 - i*4, 3, 4, 4);
            rect.setStroke(Color.GREY);
            rect.setFill(Color.WHITE);
            if(i < cntOrd && 1 == cntOrd)rect.setFill(Color.RED);
            if(i < cntOrd && 1 < cntOrd) rect.setFill(Color.DARKGREEN);
            this.getChildren().add(rect);
        }
        //Текст
//        Text n = new Text(title);
//        n.setXY(10+cntAllOrd*4, -5);
//        n.setFont(new Font(8));
//        n.setStroke(Color.GREY);
//        this.getChildren().add(n);

        //точка выхода
//        Circle pointOut = new Circle(12+cntAllOrd*4, 5 ,2);
//        pointOut.setFill(Color.WHITE);
//        pointOut.setStroke(Color.GREY);
//        this.getChildren().add(pointOut);

        pExt = new ShapeNode(this);
        pExt.relocate(9+cntAllOrd*4,2);

        this.getChildren().add(pExt);
    }

    public void setCntAllOrd(int cntAllOrd) {
        this.cntAllOrd = cntAllOrd;
    }

    public void setCntOrd(int cntOrd) {
        this.cntOrd = cntOrd;
    }

    public void setStockTitle(String stockTitle) {
        this.stockTitle = stockTitle;
    }

//    @Override
//    public void showInfo(){
//        stock = stockController.getStock(stockTitle);
//        store = stock.getStore(title);
//        System.out.println(title);
//        material = store.getMaterial();
//        count = store.getCount();
//        Bounds bounds = this.localToScreen (this.getBoundsInLocal());
////        Bounds bounds1 = this.localToScene(this.getBoundsInParent());
////        Bounds bounds2 = this.localToScene(this.getLayoutBounds());
//        //Границы текущего элемента
////            Text text = new Text("LocalCentr – X: " + bounds.getCenterX() + "; Y: " + bounds.getCenterY() + "\n" +
////                "Parent – X: " + bounds1.getCenterX() + "; Y: " + bounds1.getCenterY() + "\n" +
////                "Leyout – X: " + bounds2.getCenterX() + "; Y: " + bounds2.getCenterY() + "\n" +
////                "LocalMax – X: " + bounds.getMaxX() + "; Y: " + bounds.getMinY() + "\n"
////                    );
//
//        Text text = new Text(title + "\n" + material + " = " + count);
//        ShapeInfo info = new ShapeInfo(text, 40);
//        info.show(this, bounds.getMaxX(), bounds.getMinY() -15);
//    }
}