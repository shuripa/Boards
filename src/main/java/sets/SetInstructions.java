package sets;

import inout.InstructionLoader;
import model.Instruction;

import java.util.ArrayList;

public class SetInstructions {
    private static SetInstructions instance;
    private static InstructionLoader loader;
    ArrayList<Instruction> instructions;

    private SetInstructions(){
        instructions = new ArrayList<>();
        instance = this;
        loader = new InstructionLoader();
    }

    public static SetInstructions getInstance(){
        if (instance == null){
            instance = new SetInstructions();
            loader.load();
        }
        return instance;
    }

    public void add(Instruction instruction){
        instructions.add(instruction);
    }

    public Instruction get(String condition, Integer step){
        for (Instruction i: instructions) {
            if (i.getCondition().getConditionAsString().equals(condition)
                    && i.getCondition().getStep() == step) return i;
        }
        return null;
    }

    public void print(){
        for (Instruction ins: instructions) {
            System.out.println(ins.getCondition().getConditionAsString());
            ins.print();
        }
    }
}
