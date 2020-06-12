package sets;

import graphics.leyout.components.CompositControl;
import graphics.leyout.components.CompositTool;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SetControl {
    private HashMap<String, CompositControl> controls;
    private static SetControl instance;

    private SetControl(){
        controls = new HashMap<>();
    }

    public static SetControl getInstance(){
        if (instance == null) {
            instance = new SetControl();
            Logger.getLogger("MainApp").log(Level.CONFIG, "Create SetControl instance");
        }
        Logger.getLogger("MainApp").log(Level.CONFIG, "Getting instance MAOSystem");
        return instance;
    }

    public void addCompositControl(CompositControl control){
        if (control != null)
        controls.put(control.getTitle(), control);
    }

    public CompositControl getCompositControl(String title){
        return controls.get(title);
    }

    public CompositControl getControlByTool (CompositTool tool){
        CompositControl result = null;
        for (CompositControl cc: controls.values()) {
            if (cc.isContainTool(tool)){
                result = cc;
            }
        }
        return result;
    }
}
