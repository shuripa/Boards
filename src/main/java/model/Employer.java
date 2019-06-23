package model;

import leyout.controllers.EmployerController;

import java.util.ArrayList;

public class Employer {
    private Integer id;
    private String name;
    private ArrayList<Skill> skills;
    private EmployerController employerController;

    public Employer(Integer id, String name){
        this.id = id;
        this.name = name;
        skills = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setSkills(Skill skill) {
        skills.add(skill);
    }

    public void setEmployerController(EmployerController employerController) {
        this.employerController = employerController;
    }

    public ArrayList<Skill> getSkill() {
        return this.skills;
    }

    public Double getProductivity(String module){
        Double result = 25.0;
        for (Skill s: skills) {
            if (s.getMaterialBlank().equals(module)){
                result = s.getProductivity();
            }
        }
        return result;
    }

    public Integer getID() {
        return id;
    }
}
