package sets;

import model.Employer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SetEmployers implements Iterable<String> {
    private static SetEmployers instance;
    private HashMap<String, Employer> employers;

    private SetEmployers(){
        instance = this;
        employers = new HashMap<>();
    }

    public static SetEmployers getInstance(){
        if (instance == null){
            new SetEmployers();
        }
        return instance;
    }

    public void addEmployer(Employer e){
        employers.put(e.getId(), e);
    }

    public Employer getEmployer(String id){
        return employers.get(id);
    }

    public ArrayList<Employer> getEmployers(){
        ArrayList<Employer> result = new ArrayList<>();
        for (String s: employers.keySet()) {
            result.add(employers.get(s));
        }
        return result;
    }

    public Buffer<Employer> getBufferEmploers(){
        Buffer<Employer> buffer = new Buffer<>();
        for (String s: employers.keySet()){
            buffer.enque(employers.get(s));
        }
        return buffer;
    }

    @Override
    public Iterator<String> iterator() {
        return employers.keySet().iterator();
    }

}
