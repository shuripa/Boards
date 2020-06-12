package graphics.leyout.components;

import inout.CompositBuilder;
import model.Condition;

public class Tool extends LeyoutComponent{
    String id;
    String title;
    Condition condition;

    public Tool(){
    }

    public Tool(CompositBuilder builder){
        building(builder);
    }

    public void building (CompositBuilder builder){
        setId("" + builder.getId());
        setTitle(builder.getTitle());
        setCondition(builder.getConditionString(), 110);
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    private void setCondition(String conditionString, int step) {
        this.condition = new Condition(conditionString, step);
    }

    @Override
    public String toString() {
        return "";
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }
}
