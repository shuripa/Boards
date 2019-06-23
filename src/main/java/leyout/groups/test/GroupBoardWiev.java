package leyout.groups.test;


public class GroupBoardWiev extends LeyoutGroupWiev {

    public GroupBoardWiev(GroupBoardController controller, int size, int x, int y, double a){
        super(controller, size, x ,y, a);
    }

    @Override
    public void getElements() {
        this.getChildren().add(controller.getHumanShape());
        this.getChildren().add(controller.getGridShape());
        this.getChildren().add(controller.getBoardShape());
        this.getChildren().add(controller.getBoardIndex());
    }

    @Override
    public void emplacement(int size) {
        controller.getHumanShape().relocate(size/2-10, 7);
        controller.getBoardShape().relocate(0, 25);
        controller.getBoardIndex().relocate(size-5, 7);
    }

    @Override
    public void showInfo() {

    }
}