package inout;

import sets.stock.MaterialController;
import graphics.leyout.components.GroupBoard;
import sets.BoardsController;
import model.Material;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * example record: VT 15; 3FC1307650172
 */

/**
 * GridMaterialLoader
 * 1) загружает информацию для сетки о том какой материал должен быть на ней размещен.
 * 2) создает связи в материале укзаывая позиции, которые служат изначальными узлами.
 * Введение инстркуций для инструмента перечень размещенного материала должен браться оттуда.
 */
@Deprecated
public class GridMaterialLoader {

    HashMap<String, ArrayList<String>> arrWkPcGrMat;                    //Название р/м, набор материалов.
    HashMap<Material, ArrayList<String>> arrMatWkPc;
    HashMap<String, GroupBoard> mapboard;


    String fileName = "src\\main\\resources\\materialongrid.csv";
    List<String> lines;
    String[] tokens;

    public GridMaterialLoader(ArrayList<GroupBoard> arrBoards) throws IOException {
        arrWkPcGrMat = new HashMap<>();

        lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        MaterialController mc = MaterialController.getInstance();
        mapboard = new HashMap<>();

        for (GroupBoard gboard: arrBoards) {
            mapboard.put(gboard.getDescription(), gboard);
        }

        for (String l: lines){
            tokens = l.split(";");

            if (tokens.length > 1) {
                mc.getMaterial(tokens[1]).setKnotsEnt(tokens[0]);         //Переход из String-material на Material-material
            }

            if (arrWkPcGrMat.containsKey(tokens[0])){               //Если рабочее место существует - получить его и добавить материал
                arrWkPcGrMat.get(tokens[0]).add(tokens[1]);
            } else {
                if (tokens.length > 1) {
//                    mc.getMaterials(tokens[1]).setKnotsEnt(tokens[0]);         //Переход из String-material на Material-material
                    ArrayList<String> x = new ArrayList<>();        //Создать набор материалов для рабочего места
                    x.add(tokens[1]);                               //Добавить материал в набор
                    arrWkPcGrMat.put(tokens[0], x);                 //добавить рабочее место с набором материалов
                }
            }
        }

        BoardsController sbs = BoardsController.getInstance();
        for (String l: lines){                                      //??? непонятній цикл
            tokens = l.split(";");
            for (GroupBoard gb: arrBoards) {                        //Перебор CompositBoard. ???-CompositBoard передается по параметру в конструкторе.
                gb.setMaterial(arrWkPcGrMat.get(gb.getDescription()));  //Устанавливаем набор материала для рабочего места.
            }
//            for (CompositBoardController gbc: sbs.getGroupBoardControllersByTitle(tokens[0])) {    //Перероблений цикл завантаження матеріалу                    //Перебор CompositBoard. ???-CompositBoard передается по параметру в конструкторе.
//                gbc.addMateril(tokens[1]);
//            }
        }


    }

    public ArrayList<String> getMaterials(String title) {
        ArrayList<String> result = new ArrayList<>();
        for (String s: arrWkPcGrMat.keySet()) {
            if (s.equals(title)){
                result = arrWkPcGrMat.get(title);
            }
        }
        return result;
    }
}