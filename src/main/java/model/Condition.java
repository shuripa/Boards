package model;



public class Condition {
//TODO выбрать оптимальный вариант хранения позже. Оставить только один.
    private String condition;
    private char[] chCond;

    public Condition(String condition){
        this.condition = condition;
        if (condition != null) {
            this.chCond = condition.toCharArray();
        }
//        SetComponentControllers.getInstance();
    }

    public boolean isSuited (Skill skill){
        if (skill == null) return false;
        if (chCond == null) return false;
        if (skill.getMaterialBlank().length() != chCond.length) return false;

        char[] chSkill = skill.getMaterialBlank().toCharArray();
        Boolean b = true;
        for (int i = chSkill.length; i > 0; i--) {
            if ((chSkill[i - 1] == chCond[i - 1] || chSkill[i - 1] == '*' || chCond[i - 1] == '*') && (b == true)) {
            } else {
                b = false;
                break;
            }
        }
        return b;
    }

    public String toString(){
        return chCond.toString();
    }
}
