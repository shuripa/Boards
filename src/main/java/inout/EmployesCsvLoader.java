package inout;

import graphics.components.Employer;
import model.Skill;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class EmployesCsvLoader {

    private static EmployesCsvLoader instance;
    HashMap<Integer, Employer> arrEmp;
    String fileName = "src\\main\\resources\\employes.csv";
    List<String> lines;
    String[] tokens;

    private EmployesCsvLoader() throws IOException {
        arrEmp = new HashMap<Integer, Employer>();
        lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        for (String l: lines) {
            tokens = l.split(";");
            Employer employer = new Employer(Integer.parseInt(tokens[0]), tokens[1], tokens[2], "");
            arrEmp.put(Integer.parseInt(tokens[0]), employer);
        }
    }

    public Employer getEmployerByID(int id){
        return arrEmp.get(id);
    }

    public static EmployesCsvLoader getInstance() throws IOException {
        if (instance == null) {
            instance = new EmployesCsvLoader();
        }
        return instance;
    }

    public HashMap<Integer, Employer> getArrEmp() {
        return arrEmp;
    }


    public void addSkill(Integer id, Skill skill){
        arrEmp.get(id).setSkill(skill);
    }

}
