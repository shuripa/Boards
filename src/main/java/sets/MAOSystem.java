package sets;

import graphics.leyout.components.CompositBoard;
import graphics.leyout.components.CompositMao;

import java.util.HashMap;

public class MAOSystem {
    private HashMap<String, CompositMao> arrMao;
    private static MAOSystem instance;

    private MAOSystem(){
        arrMao = new HashMap<>();
    }

    public static MAOSystem getInstance(){
        if (instance == null) {
            instance = new MAOSystem();
        }
        return instance;
    }

    public void addCompositMao(CompositMao mao){
        arrMao.put(mao.getTitle(), mao);
    }

    public CompositMao getCompositMao(String title){
        return arrMao.get(title);
    }

    public CompositMao getMaoWithBoard (CompositBoard board){
        CompositMao result = null;
        for (CompositMao cm: arrMao.values()) {
            if (cm.isContainBoard(board)){
                result = cm;
            }
        }
        return result;
    }
}
