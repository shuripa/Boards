package sets;

import graphics.leyout.components.GroupBoard;

import java.util.ArrayList;
import java.util.HashMap;
//TODO: Привести к стандарту
// Доска может иметь следующие параметры
// Представление:
// p или x, y   - точка размещения              - int
// w            - ширина                        - int
// a            - угол поворота                 - Double
// id           - индивидуальный номер          - int
// title        - название доски                - string
// b            - ?                             - boolean
// Модель:
// ?            - материал сетки
// ?            - заказы в мао
// ?            - размещенный рабочий
// ?            - условия
// ?            - точки входа / выхода
// ind          - индикатор
@Deprecated
public class BoardsController {
    private static BoardsController instance;

    ArrayList<GroupBoard> arrBoards;                    //Масив дошок
    HashMap<Integer, GroupBoard> idBoards;              //Получение доски по id

    private BoardsController(){
        arrBoards = new ArrayList<>();
        idBoards = new HashMap<>();
    }

    public static BoardsController getInstance(){
        if (instance == null){
            instance = new BoardsController();
        }
        return instance;
    }

    public void addBoard (int id, String title, int x, int y, int w, double a){
        GroupBoard gb = new GroupBoard(id, title, w, x, y, a, 0);
        arrBoards.add(gb);
        idBoards.put(id, gb);
    }

//    CompositBoard bg1 = new CompositBoard("1271", "KM 029", 60, 15, 55, 0, 180);

    public ArrayList<GroupBoard> getArrBoards() {
        return arrBoards;
    }

    public GroupBoard getBoard (int id){
        if (idBoards.containsKey(id))
        return idBoards.get(id);
        else return null;
    }

    public void setCondition(int id, String s) {
        GroupBoard b = getBoard(id);
        b.setCondition(s);
    }
}
