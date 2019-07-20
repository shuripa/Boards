package inout;

import graphics.leyout.components.Employer;
import model.Skill;
import sets.SetEmployers;

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


    public SkillCsvLoader(HashMap<Integer, Employer> arrEmp) throws IOException {
        String fileName = "src\\main\\resources\\skill.csv";
        List<String> lines;
        skills = new ArrayList<>();

    String[] tokens;
        lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        SetEmployers setE = SetEmployers.getInstance();

        for (String l: lines) {
            tokens = l.split(";");
            Integer id = Integer.parseInt(tokens[0]);
            System.out.print("" + id);
            Employer e = arrEmp.get(id);
            setE.addEmployer(e);
            System.out.println(" " + e.getName() + " " + tokens[1] + " " + tokens [2]);
            Skill s = new Skill(e, tokens[1], Double.parseDouble(tokens[2]));
            e.setSkill(s);
        }
    }
}
