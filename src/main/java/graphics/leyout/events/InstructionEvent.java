package graphics.leyout.events;

import model.Material;

import java.util.Set;

public class InstructionEvent implements Event {
    private Set<Material> instruction;

    public InstructionEvent(Set<Material> instruction) {
        this.instruction = instruction;
    }

    @Override
    public Set<Material> getSet() {
        return instruction;
    }
}
