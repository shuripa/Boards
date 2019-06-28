package model;

public class Skill {
    String materialBlank;

    Double productivity;
    public Skill(String materialBlank, double productivity) {
        this.materialBlank = materialBlank;
        this.productivity = productivity;
    }

    public String getMaterialBlank() {
        return materialBlank;
    }

    public Double getProductivity() {
        return productivity;
    }
}
