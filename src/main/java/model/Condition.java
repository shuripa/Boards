package model;


/**
 * Condition - условие вида "MFC1841034***"
 * Устанавливается для Board, передается из Leyout через CompositBoard как String.
 * В Board создается новый екземляр Condition и добавляется в массив addCondition(new Condition(condition));
 * Сам массив описывается в суперклассе LeyoutComponent private ArrayList<Condition> conditions;
 *
 * Проверяет Skill на соответсвие условию.
 * Skill содержит
 * - строку вида MFC184108200A или MFC184700**** или любого другого.
 * - владельца
 * - и продуктивность
 */

// TODO: не совсем понятно так ли Skill концептуально отличается от Condition. Нельзя ли объединить оба класса в один.

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

    public boolean Like (Condition condition) {
        if (condition == null) return false;
        if (chCond == null) return false;
        if (condition.length() != chCond.length) return false;

        char[] chCondition = condition.getCharCondition();
        Boolean result = true;
        for (int i = chCondition.length; i > 0; i--) {
            if ((chCondition[i - 1] == chCond[i - 1] || chCondition[i - 1] == '*' || chCond[i - 1] == '*') && (result == true)) {
            } else {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean Like (String title) {
        if (title == null) return false;
        if (chCond == null) return false;
        if (title.length() != chCond.length) return false;

        char[] chTitle = title.toCharArray();
        Boolean result = true;
        for (int i = chTitle.length; i > 0; i--) {
            if ((chTitle[i - 1] == chCond[i - 1] || chTitle[i - 1] == '*' || chCond[i - 1] == '*') && (result == true)) {
            } else {
                result = false;
                break;
            }
        }
        return result;
    }

    public int length(){
        return chCond.length;
    }

    public char[] getCharCondition(){
        return chCond;
    }

    public String toString(){
        return chCond.toString();
    }
}
