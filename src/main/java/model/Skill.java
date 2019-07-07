package model;

import graphics.components.Employer;
import graphics.components.LeyoutComponent;

public class Skill extends LeyoutComponent {
    String materialBlank;
    Double productivity;
    Employer employer;

    public Skill(Employer sender, String materialBlank, double productivity) {
        this.employer = sender;
        this.materialBlank = materialBlank;
        this.productivity = productivity;
    }

    public String getMaterialBlank() {
        return materialBlank;
    }

    public Double getProductivity() {
        return productivity;
    }

    public Employer getEmployer(){
        return employer;
    }

    @Override
    public String toString() {
        return null;
    }
}
