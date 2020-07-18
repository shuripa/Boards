package graphics.leyout.components;

import graphics.leyout.events.InstructionEvent;
import graphics.leyout.events.Listener;
import model.Instruction;

import java.util.ArrayList;

/*
* Операции:
* - добавление
* - удаление
* - сообщение об изменении (список слушателей, добавление к списку, удаление из списка)
* - возврат массива инструкций или списа материалов.
* */

public class Instructions extends LeyoutComponent{
    private ArrayList<Instruction> instructions;

    private ArrayList<Listener> addListeners;
    private ArrayList<Listener> delListeners;

    public Instructions (){
        instructions = new ArrayList<>();

        addListeners = new ArrayList<>();
        delListeners = new ArrayList<>();
    }

    public void addInstruction(Instruction instruction){
        instructions.add(instruction);
        for (Listener l: addListeners) {
            l.inEvent(new InstructionEvent(instruction.getMaterials()));
        }
    }
    public void delInstruction(Instruction instruction){
        instructions.remove(instruction);
        for (Listener l: delListeners) {
            l.inEvent(new InstructionEvent(instruction.getMaterials()));
        }

    }

    public void setAddInstructionEventListeners(Listener listener){
        addListeners.add(listener);
    }
    public void setDelInstructionEventListeners(Listener listener){
        delListeners.add(listener);
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
