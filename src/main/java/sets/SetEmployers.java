package sets;

import model.Employer;

import java.util.HashMap;

public class SetEmployers {
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
}
