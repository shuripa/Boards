package inout;

import model.Instruction;
import sets.stock.KeyStore;
import sets.stock.MasterStore;
import sets.stock.SetMasterStore;

public class MasterStoreLoader {
    String[] tokens;
    CSVReader reader;
    SetMasterStore masterSet;
    KeyStore key;
    MasterStore master;
    Instruction instruction;

    public MasterStoreLoader(){
    }

    public void load(){
        masterSet = SetMasterStore.getInstance();
        reader = new CSVReader("src\\main\\resources\\02.Kanban Teilestamm.csv", ";");
        if (reader.hasNext()) reader.next();
        for (;reader.hasNext();) {
            short count = 0;
            tokens = reader.next();

            key = new KeyStore(tokens[0], tokens[1], tokens[2]);

            for (int i = 0; i < 5 && i+11 < tokens.length; i++){
                if (tokens[i+ 11] != "") count ++;
            }
            master = new MasterStore(tokens[2], count, Integer.parseInt(tokens[3]));

            masterSet.add(key, master);
        }
    }
}