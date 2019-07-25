package inout;

import model.Employer;
import model.Profession;
import model.Skill;
import sets.SetEmployers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class EmployesCsvLoader {

    private static EmployesCsvLoader instance;
    @Deprecated
    HashMap<String, Employer> arrEmp;
    //    TODO Массив хранения перенесен в класс SetEmployers
    String fileName = "src\\main\\resources\\employes.csv";
    List<String> lines;
    String[] tokens;

    private EmployesCsvLoader() throws IOException {
        SetEmployers set = SetEmployers.getInstance();
        arrEmp = new HashMap<String, Employer>();
        lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        for (String l: lines) {
            tokens = l.split(";");
            Employer employer = new Employer(tokens[0], tokens[1], tokens[2], tokens[3], Profession.valueOf(tokens[4]), tokens[5]);
            arrEmp.put(tokens[0], employer);
            set.addEmployer(employer);
        }
    }

    public Employer getEmployerByID(String id){
        return arrEmp.get(id);
    }

    public static EmployesCsvLoader getInstance() throws IOException {
        if (instance == null) {
            instance = new EmployesCsvLoader();
        }
        return instance;
    }

    public HashMap<String, Employer> getArrEmp() {
        return arrEmp;
    }


    public void addSkill(String id, Skill skill){
        arrEmp.get(id).setSkill(skill);
    }

}
