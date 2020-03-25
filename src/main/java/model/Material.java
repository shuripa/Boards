package model;

import java.util.ArrayList;

public class Material {
    Integer id;
    String title;
    ArrayList <String> knotsEnt;
    ArrayList <String> knotsExt;

    public Material(String title){
        knotsEnt = new ArrayList();
        knotsExt = new ArrayList();
        this.title = title;
        id = 0;
    }

    public Material(String title, int id){
        this.title = title;
        this.id = id;
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
