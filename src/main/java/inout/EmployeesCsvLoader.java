package inout;

import model.Employee;
import model.Profession;
import model.Skill;
import sets.SetEmployees;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

//Задача: завантаження працівників з файлу .csv

public class EmployeesCsvLoader {

    private static EmployeesCsvLoader instance;
    @Deprecated
    HashMap<String, Employee> arrEmp;
    //    TODO Массив хранения перенесен в класс SetEmployers
    String fileName = "src\\main\\resources\\employes.csv";
    List<String> lines;
    String[] tokens;
    SetEmployees set;

    private EmployeesCsvLoader() throws IOException {
        instance = this;
        set = SetEmployees.getInstance();
        arrEmp = new HashMap<String, Employee>();
        lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        for (String l: lines) {
            tokens = l.split(";");
            Employee employee = new Employee(tokens[0], tokens[1], tokens[2], tokens[3], Profession.valueOf(tokens[4]), tokens[5], tokens[6]);
            arrEmp.put(tokens[0], employee);
            set.addEmployee(employee);
        }
    }


    public static EmployeesCsvLoader getInstance() throws IOException {
        if (instance == null) {
            instance = new EmployeesCsvLoader();
        }
        return instance;
    }

    public void loadToSet(SetEmployees set){
        try {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
            for(String l : lines){
                tokens = l.split(";");
                Employee employee = new Employee(tokens[0], tokens[1], tokens[2], tokens[3], Profession.valueOf(tokens[4]), tokens[5], tokens[6]);
                set.addEmployee(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Employee getEmployeeByID(String id){
        return arrEmp.get(id);
    }

    public HashMap<String, Employee> getArrEmp() {
        return arrEmp;
    }


    public void addSkill(String id, Skill skill){
        arrEmp.get(id).setSkill(skill);
    }

}
