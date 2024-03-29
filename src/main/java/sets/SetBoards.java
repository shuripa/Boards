package sets;

import graphics.leyout.controllers.CompositBoardController;

import java.util.ArrayList;
import java.util.HashMap;

public class SetBoards {

    private static SetBoards instance;
    private HashMap<String, CompositBoardController> mapBoardControllers;

    private SetBoards(){
        mapBoardControllers = new HashMap<>();
        instance = this;
    }

    public static SetBoards getInstance(){
        if (instance == null) {
            instance = new SetBoards();
        }
        return instance;
    }

    public void addGroupBoardController(CompositBoardController gbc){
        mapBoardControllers.put(gbc.getId(), gbc);
    }

    public CompositBoardController getGroupBoardController(Integer id){
        return (mapBoardControllers.containsKey(id) ? mapBoardControllers.get(id) : null);
    }

    public ArrayList<CompositBoardController> getGroupBoardControllersByTitle(String title){
        ArrayList<CompositBoardController> arrBoardControllers = new ArrayList<>();
        for (CompositBoardController gbc: mapBoardControllers.values()) {
            if (gbc.getTitle() == title) arrBoardControllers.add(gbc);
        }
        return arrBoardControllers;
    }

}
