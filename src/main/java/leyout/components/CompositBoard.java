package leyout.components;

public class CompositBoard extends LeyoutComponent {
    Board board;
    Human human;
    BoardIndex boardIndex;
    Grid grid;

    @Override
    public String toString() {
        return "";
    }

    public String getTitle() {
        return "";
    }

    public String getCondition() {
        return "";
    }

    public void setTitle() {
    }

    public Board getBoard() {
        return board;
    }

    public Human getHuman() {
        return human;
    }

    public BoardIndex getBoardIndex(){
        return boardIndex;
    }

    public Grid getGrid(){
        return grid;
    }
}
