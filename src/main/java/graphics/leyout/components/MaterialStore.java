package graphics.leyout.components;

import graphics.leyout.events.Listener;
import model.Material;
import sets.stock.Reserve;
import sets.stock.Stock;
import sets.stock.StockSet;

import java.util.ArrayList;

public class MaterialStore extends LeyoutComponent{
    ArrayList<Reserve> reserves;
    Instructions instructions;
    Stock stock;


    public MaterialStore(Instructions instructions){
        reserves = new ArrayList<>();
        stock = StockSet.getInstance().getStock("F5");

        this.instructions = instructions;

        onAddInstruction(event -> {
            for (Material material: event.getSet()) {
                reserves.add(stock.getReserve(material.getTitle()));
            }
        });

        onDelInstruction(event -> {
//            TODO: реализовать удаление.
        });
    }

    private void onAddInstruction(Listener listener) {
        instructions.setAddInstructionEventListeners(listener);
    }

    private void onDelInstruction(Listener listener) {
        instructions.setDelInstructionEventListeners(listener);
    }

    public void setReserves(Reserve reserve) {
        reserves.add(reserve);
    }

    public void degCountMaterial(Material material){
        for (Reserve s: reserves) {
            if (s.getMaterial().equals(material)){
                s.degCount();
            }
        }
    }

    @Override
    public String toString() {
        return "";
    }
}
