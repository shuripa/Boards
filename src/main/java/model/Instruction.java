package model;

import java.util.HashMap;
import java.util.Set;


public class Instruction {
    //Одна инструкция, - одно условие.
    Condition condition;
    HashMap<Material, Integer> entry;

    public Instruction(Condition condition){
        entry = new HashMap<>();
        this.condition = condition;
    }

    public Condition getCondition(){
        return condition;
    }

    public void addEntry(Material material, int count){
        entry.put(material, count);
    }

    public Set<Material> getMaterials (){
        return entry.keySet();
    }

    public void print() {
        for (Material m: entry.keySet()) {
            System.out.println(m.title + " - " + entry.get(m));
        }
    }
}
