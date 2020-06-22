package sets;

import inout.EmployeesCsvLoader;
import inout.SkillCsvLoader;
import model.Employee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

//Завдання: отримати, зберігати, оперувати і надавати список працівників.

public class SetEmployees implements Iterable<String> {
    private static SetEmployees instance;
    private HashMap<String, Employee> employees;

    private SetEmployees(){
        instance = this;
        employees = new HashMap<>();
        try {
            EmployeesCsvLoader eloader = EmployeesCsvLoader.getInstance();
            eloader.loadToSet(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SkillCsvLoader scl = null;                                                      // Загрузка скилов
        try {
            scl = new SkillCsvLoader(employees);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SetEmployees getInstance(){
        Logger.getLogger("MainApp").log(Level.FINE, "Geting instance SetEmployees");
        if (instance == null){
            new SetEmployees();
        }
        return instance;
    }

    public void addEmployee(Employee e){
        employees.put(e.getId(), e);
    }

    public Employee getEmployeeByID(String id){
        return employees.get(id);
    }

    public ArrayList<Employee> getEmployees(){
        ArrayList<Employee> result = new ArrayList<>();
        for (String s: employees.keySet()) {
            result.add(employees.get(s));
        }
        return result;
    }

    public Buffer<Employee> getBufferEmploers(){
        Buffer<Employee> buffer = new Buffer<>();
        for (String s: employees.keySet()){
            buffer.enque(employees.get(s));
        }
        return buffer;
    }

    @Override
    public Iterator<String> iterator() {
        return employees.keySet().iterator();
    }

}
