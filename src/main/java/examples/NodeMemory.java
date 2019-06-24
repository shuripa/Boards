package examples;

import leyout.component.GroupBoard;
import leyout.views.ShapeNode;

public class NodeMemory {
    public static void main(String[] args) {
        GroupBoard groupBoard = new GroupBoard(111, "", 1, 1, 1, 1.0, 90);
        ShapeNode nEnt = new ShapeNode(groupBoard);
        for (int i = 0; i < 100; i++) {
            nEnt.addNode(new ShapeNode(groupBoard));
        }

    }
}
