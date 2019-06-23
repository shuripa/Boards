package leyout.elements;

import leyout.controllers.LeyoutElementController;

import java.util.ArrayList;
import java.util.HashMap;

public class Grid extends LeyoutElement {
    private ArrayList<String> materials;

    public Grid(LeyoutElementController controller) {
        super(controller);
    }

    public ArrayList<String> getMaterials() {
        return materials;
    }

    public ArrayList<String> getSingleMaterial(){           //Список материалов без дубликатов
        HashMap<String, String> sm = new HashMap<>();
        for (String m: materials) {
            if(!sm.containsKey(m)) sm.put(m, m);
        }
        return new ArrayList<>(sm.values());
    }

    public void setMaterials(ArrayList<String> materials) {
        this.materials = materials;
    }

    @Override
    public String toString() {
        String s = "Матеріал:";
        for (String m: getSingleMaterial()) {
            s = s + "\n" + m;
        }
        return s;
    }

    public void addMaterial(String material) {
        this.materials.add(material);
    }
}