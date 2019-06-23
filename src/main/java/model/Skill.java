package model;

public class Skill {
    public String getMaterialBlank() {
        return materialBlank;
    }

    String materialBlank;
    Double productivity;

    public Skill(String materialBlank, double productivity) {
        this.materialBlank = materialBlank;
        this.productivity = productivity;
    }

    public Double getProductivity() {
        return productivity;
    }
}
