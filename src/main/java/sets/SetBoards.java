package sets;

import leyout.groups.test.GroupBoardController;

import java.util.ArrayList;
import java.util.HashMap;

public class SetBoards {

    private static SetBoards instance;
    private HashMap<Integer, GroupBoardController> mapBoardControllers;

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

    public void addGroupBoardController(GroupBoardController gbc){
        mapBoardControllers.put(gbc.getID(), gbc);
    }

    public GroupBoardController getGroupBoardController(Integer id){
        return (mapBoardControllers.containsKey(id) ? mapBoardControllers.get(id) : null);
    }

    public ArrayList<GroupBoardController> getGroupBoardControllersByTitle(String title){
        ArrayList<GroupBoardController> arrBoardControllers = new ArrayList<>();
        for (GroupBoardController gbc: mapBoardControllers.values()) {
            if (gbc.getTitle() == title) arrBoardControllers.add(gbc);
        }
        return arrBoardControllers;
    }

}
