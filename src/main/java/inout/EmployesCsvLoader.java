package inout;

import model.Employer;
import model.Skill;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class EmployesCsvLoader {

    HashMap<Integer, Employer> arrEmp;
    String fileName = "src\\main\\resources\\employes.csv";
    List<String> lines;
    String[] tokens;

    //TODO: реализовать Iterable
    public HashMap<Integer, Employer> getArrEmp() {
        return arrEmp;
    }

    public EmployesCsvLoader() throws IOException {
        arrEmp = new HashMap<Integer, Employer>();
        lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        for (String l: lines) {
            tokens = l.split(";");
            Employer employer = new Employer(Integer.parseInt(tokens[0]), tokens[1]);
            arrEmp.put(Integer.parseInt(tokens[0]), employer);
        }
    }

    public void addSkill(Integer id, Skill skill){
        arrEmp.get(id).setSkills(skill);
    }

}
