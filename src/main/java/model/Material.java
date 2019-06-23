package model;

import java.util.ArrayList;

public class Material {
    String name;
    Integer id;
    ArrayList <String> knotsEnt;
    ArrayList <String> knotsExt;

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

    public Material(String name){
        knotsEnt = new ArrayList();
        knotsExt = new ArrayList();
        this.name = name;
        id = 0;
    }

    public Material(String name, int id){
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }
}
