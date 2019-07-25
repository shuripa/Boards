package graphics.leyout.components;

public class CompositConvier extends LeyoutComponent{
    Convier convier;
    CompositBoard[] boards;

    public CompositConvier (int countPos){
        convier = new Convier(countPos);
        addLeaf(convier);
        boards = new CompositBoard[countPos];
        for (int i = 0; i < countPos; i++) {
            CompositBoard b = new CompositBoard();
            b.setTitle("Pos " + (i + 1));
            boards[i] = b;
            addLeaf(b);
        }
    }

    public Convier getConvier() {
        return convier;
    }

    public CompositBoard getBoard (int i){
        return boards[i];
    }

    public int getCountPos(){
        return boards.length;
    }

    @Override
    public String toString() {
        return "";
    }

}
