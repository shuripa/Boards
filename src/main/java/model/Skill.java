package model;

import graphics.leyout.components.LeyoutComponent;

/**
 * Skill - (навыки) создан для рабочего Employer и взаимодействует с классом Condition (условие)
 * для того чтобы проверить можно ли рабочего ставить на рабочее место.
 * TODO: Как додаются скилы для рабочего?
 */

public class Skill extends LeyoutComponent {
    private String materialBlank;
    private int step;

    private Employee employee;
    private Condition condition;
    private Double productivity;

    private char[] chSkill;

    public Skill(Employee sender, String materialBlank, int step, double productivity) {
        this.step = step;
        this.employee = sender;
        this.materialBlank = materialBlank;
        this.productivity = productivity;
        chSkill = materialBlank.toCharArray();
    }

    public String getMaterialBlank() {
        return materialBlank;
    }

    public Double getProductivity() {
        return productivity;
    }

    public void setProductivity(Double productivity) {
        this.productivity = productivity;
    }

    public int getStep(){
        return step;
    }
    // Використовується в CompositMenuCatdController при логуванні працівника.
    // При нажатті кнопки
    public Employee getEmployee(){
        return employee;
    }

    public boolean isLike(String title, int step) {
        if (this.step != step) return false;
        if (title == null) return false;
        if (chSkill == null) return false;
        if (title.length() != chSkill.length) return false;

        char[] chTitle = title.toCharArray();
        Boolean result = true;
        for (int i = chTitle.length; i > 0; i--) {
            if ((chTitle[i - 1] == chSkill[i - 1] || chTitle[i - 1] == '*' || chSkill[i - 1] == '*') && (result == true)) {
            } else {
                result = false;
                break;
            }
        }


        return result;
    }

    @Override
    public String toString() {
        return null;
    }


}
