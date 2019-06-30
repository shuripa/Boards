package sets;

import graphics.components.Employer;

import java.util.HashMap;

public class SetEmployers {
    private static SetEmployers instance;
    private HashMap<Integer, Employer> employers;

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
        employers.put(e.getID(), e);
    }

    public Employer getEmployer(int id){
        return employers.get(id);
    }
}
