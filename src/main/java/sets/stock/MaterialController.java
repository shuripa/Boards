package sets.stock;

import model.Material;
import java.util.HashMap;

/**
 * Соответсвие между именем и объектами материала - HashMap
 */
@Deprecated
public class MaterialController {
    private HashMap<String, Material> materials; //String name, Material material;
    private static MaterialController instance;

    private MaterialController() {
        materials = new HashMap<>();
    }

    public static MaterialController getInstance(){
        if (instance == null) instance = new MaterialController();
        return instance;
    }

    public void setMaterials(String title){
        if (!materials.containsKey(title)){
            materials.put(title, new Material(title));
        }
    }

    public Material getMaterial(String title){
        if (!materials.containsKey(title)){
            Material m = new Material(title);
            materials.put(title, m);
            return m;
        } else {
            return materials.get(title);
        }
    }
}
