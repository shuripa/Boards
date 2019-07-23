package graphics.leyout.components;

public class CanbanBoard extends LeyoutComponent {
    String title;
    CanbanLeaf[] leaves;
    CanbansStock parent;
    int cntLeaves;

    @Deprecated
    public CanbanBoard(int cntLeaves, int cntCards){
//        TODO: создано для теста. Удалить.
        this.cntLeaves = cntLeaves;
        leaves = new CanbanLeaf[cntLeaves];
        for (int i = 0; i < cntLeaves; i++) {
            leaves[i] = new CanbanLeaf(this, cntCards);
        }
    }

    public CanbanBoard(CanbansStock parent, int cntLeaves, int cntCards){
        this.parent = parent;
        this.cntLeaves = cntLeaves;
        leaves = new CanbanLeaf[cntLeaves];
        for (int i = 0; i < cntLeaves; i++) {
            leaves[i] = new CanbanLeaf(this, cntCards);
        }
    }

    public int getCountLeaves(){
        return cntLeaves;
    }

    public CanbanLeaf getLeaf(int i){
        return leaves[i];
    }

    @Override
    public String toString() {
        return "";
    }
}
