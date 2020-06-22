package sets.stock;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LeafAddress {
    private static final Logger logger = Logger.getLogger("MainApp");

    private String board;

    private int section;
    private int leaf;
    public LeafAddress(String board, int section) {
        setBoard(board);
        setSection(section);
        leaf = 0;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public void setLeaf(int leaf) {
        this.leaf = leaf;
    }

    public String getBoard() {
        return board;
    }

    public int getSection() {
        return section;
    }

    @Override
    public String toString() {
        String sec = "";

        if (board.length()<3 && section < 9){
            sec = "0" + (section+1);
        } else {
            sec = "" + (section+1);
        }

        String result = board + sec + "-" + (leaf+1);

        logger.log(Level.FINE, "" + result);
        return result;
    }

    @Override
    public Object clone() {
        return new LeafAddress(board, section);
    }
}
