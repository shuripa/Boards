package inout;

import model.Condition;
import model.Instruction;
import model.Material;
import sets.SetInstructions;

public class InstructionLoader{
    Instruction instruction;
    String[] tokens;
    CSVReader reader;

    public InstructionLoader(){
    }

    public void load(){
        SetInstructions setInstruction = SetInstructions.getInstance();
        reader = new CSVReader("src\\main\\resources\\B7CLOUT002.csv");
        if (reader.hasNext()) reader.next();
        for (;reader.hasNext();) {
            tokens = reader.next();
            if (tokens[0].equals(tokens[2])){
                Condition condition = new Condition(tokens[0], 110);
                instruction = new Instruction(condition);
                setInstruction.add(instruction);
            } else {
                if (tokens[0].equals(instruction.getCondition().getConditionAsString()))
                    instruction.addEntry(new Material(tokens[2]), Integer.parseInt(tokens[3]));
            }
        }
    }


}
