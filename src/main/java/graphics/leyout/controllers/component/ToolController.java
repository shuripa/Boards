package graphics.leyout.controllers.component;

import graphics.leyout.components.Board;
import graphics.leyout.components.Tool;
import graphics.leyout.controllers.LeyoutComponentController;
import graphics.leyout.controllers.LeyoutCompositController;
import graphics.leyout.views.tools.ToolBoardView;
import graphics.leyout.views.tools.ToolView;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ToolController extends LeyoutComponentController {

    public ToolController() throws IOException {
        setView(new ToolBoardView(this));
    }

    public ToolController(Board board) throws IOException {
        super(board);
        setView(new ToolBoardView(this));
    }

    public ToolController(Tool tool, LeyoutCompositController parent, String viewType) {
        super(tool);
        setParent(parent);
        createView(viewType);
        ((ToolView)view()).setTi(tool.getId());
        ((ToolView)view()).setTt(tool.getTitle());
    }


    private void createView(String viewType){
        Class<?> view;
        Constructor<?> constructor;
        String className = "graphics.leyout.views.tools."+ viewType;
        try {
            view = Class.forName(className);
            try {
                constructor = view.getConstructor(LeyoutComponentController.class);
                try {
                    try {
                        setView((ToolView)constructor.newInstance(this));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public String getId() {
        return ((Tool)component()).getId();
    }

    public String getTitle() {
        return ((Tool)component()).getTitle();
    }


    @Override
    protected void setComponentProperties() {
//        setStrProperty(((Tool)component()).idProperty());
//        setStrProperty(((Tool)component()).titleProperty());
    }

    @Override
    public void update() {
        ((ToolView)view()).setTt(getTitle());
        ((ToolView)view()).setTi("" + getId());
        super.update();
    }



//В контроллерах нет необходимости дублировать toString. Функциональность реализована на уровне суперклассов.

}