package leyout.controllers;

import leyout.groups.GroupBoardCanban;
import leyout.wievs.ShapeNode;
import java.util.ArrayList;
import java.util.HashMap;

//TODO: Привести к стандарту
// Канбан может иметь следующие параметры
// Представление:
// p или x, y   - точка размещения                                                  - int
// a            - угол поворота                                                     - Double
// id           - номер
// title        - обозначение
// b            - горизонтальное или вертикальное расположение индикаторов заказов  - boolean
// Модель:
// w            - количество листов
// h            - количество карточек
//  -hc         - количество заказов в карточке (по сути индивидуально
//              для каждой карточки, но может быть и значение по умолчанию)

public class CanbanController {
    private static CanbanController instance;
    private ArrayList<GroupBoardCanban> arrCanbans;                     //Массив канбанов
    private HashMap<String, ShapeNode> materialToEntNode;               //Материал - ВходУзел
    private HashMap<String, ArrayList<ShapeNode>> materialToExtNode;    //Материал - ВыходУзел

    private CanbanController (){
        materialToEntNode = new HashMap<>();
        materialToExtNode = new HashMap<>();
        arrCanbans = new ArrayList<>();
    }

    public static CanbanController getInstance(){
        if (instance == null){
            instance = new CanbanController();
        }
        return instance;
    }

    public ArrayList<GroupBoardCanban> getCanbans (){
        return arrCanbans;
    }

    public void addCanban(int x, int y, int w, int h, String title) {
        arrCanbans.add(new GroupBoardCanban(this, x, y, w, h, title));
    }

    public void addEntNode(String material, ShapeNode node){
        materialToEntNode.put(material, node);
    }

    public void addExtNode(String material, ShapeNode node){
        if (!materialToExtNode.containsKey(material)){
            materialToExtNode.put(material, new ArrayList<>());
        }
        materialToExtNode.get(material).add(node);
    }

    public ArrayList<ShapeNode> getExt(String material){
        if (materialToExtNode.containsKey(material)) {
            return materialToExtNode.get(material);
        }else{
            return new ArrayList<>();
        }
    }
}
