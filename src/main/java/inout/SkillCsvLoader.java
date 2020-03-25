package inout;

import model.Employee;
import model.Skill;
import sets.SetEmployees;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
    Загружает и хранит скилы.
*/

public class SkillCsvLoader {
    ArrayList<Skill>skills;


    public SkillCsvLoader(HashMap<String, Employee> arrEmp) throws IOException {
        String fileName = "src\\main\\resources\\skill.csv";
        List<String> lines;
        skills = new ArrayList<>();

    String[] tokens;
        lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        SetEmployees setE = SetEmployees.getInstance();

        for (String l: lines) {
            tokens = l.split(";");
            String id = tokens[0];
            System.out.print("" + id);
            Employee e = arrEmp.get(id);
            setE.addEmployee(e);
            System.out.println(" " + e.getName() + " " + tokens[1] + " " + tokens [2]);
            Skill s = new Skill(e, tokens[1], Integer.parseInt(tokens[3]), Double.parseDouble(tokens[2]));
            e.setSkill(s);
        }
    }
}
