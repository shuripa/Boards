package graphics.leyout.components;

import model.Instruction;

import java.util.ArrayList;

public class Instructions extends LeyoutComponent{
    private ArrayList<Instruction> instructions;

    public Instructions (){
        instructions = new ArrayList<>();
    }

    public void addInstruction(Instruction instruction){
        instructions.add(instruction);
    }

    @Override
    public String toString() {
        String result = "";
        for (Instruction i: instructions) {
            result = result + i.getCondition().getConditionAsString() + "\n";
        }
        return result;
    }

}
