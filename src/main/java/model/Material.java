package model;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Material {
    private static final Logger logger = Logger.getLogger("MainApp");
    Integer id;                         //id нужен для модулей. возможно понадобиться еще что нибудь, время создания
                                        //информация о тестах. МастерДата со всей историей. Примечания.
    String title;
    ArrayList <String> knotsEnt;        //TODO: Это узлы для связи. Сюда прописывается позиция на канбане.
    ArrayList <String> knotsExt;        //TODO: Сюда прописывается сетка.

    public Material(String title){
//        logger.log(Level.CONFIG, "Material constructor: " + title);
        knotsEnt = new ArrayList();
        knotsExt = new ArrayList();
        this.title = title;
        id = 0;
    }

    public Material(String title, int id){
        this.title = title;
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<String> getKnotsEnt() {
        return knotsEnt;
    }

    public void setKnotsEnt(String knotEnt) {
        this.knotsEnt.add(knotEnt);
    }

    public ArrayList<String> getKnotsExt() {
        return knotsExt;
    }

    public void setKnotsExt(String knotExt) {
        this.knotsExt.add(knotExt);
    }

    @Override
    public String toString() {
        return title;
    }

}
