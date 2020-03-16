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
 *
 * Расширение условия. Условие должно делать проверку на:
 * - проект; закрепленный проект
 * - строку; шаблон изделия или изделие; MFC1841034***
 * - рабочий шаг; одно и то же изделие делается в несколько этапов (шагов) 100, 120
 * - вид деятельности; или професия. Вязальник, Тестувальник, Конторський.
 * - закрепление за рабочим местом.
 * Приоритет при автоматическом распределении
 * - закрепленное место.
 * Приоритет при ручном распределении
 * - Проект
 * - Закрепленное рабочее место - отделено сверху сепаратором.
 * - совпадение строки, шага и деятельности - сильное выделение.
 * - совпадение строки и шага - слабое выделение.
 */

//  TODO: не совсем понятно так ли Skill концептуально отличается от Condition. Нельзя ли объединить оба класса в один.
//  TODO: Скил может содержать условие (Condition) и продуктивность

public class Condition {
//TODO выбрать оптимальный вариант хранения позже. Оставить только один.
    private String condition;
    private char[] chCond;
    private int step;

    public Condition(String condition, int step){
        this.step = step;
        this.condition = condition;
        if (condition != null) {
            this.chCond = condition.toCharArray();
        }
//        SetCompositControllers.getInstance();
    }

    // TODO: Переименовать в Like
    public boolean Like (Skill skill){
        if (skill == null) return false;
        if (step != skill.getStep()) return false;
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
        if (chCond == null) return false;
        if (step != condition.getStep()) return false;
            if (condition == null) return false;
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

    public boolean Like (String title, int step) {
        if (this.step != step) return false;
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

    public String getConditionString(){
        return condition;
    }

    public int getStep() {
        return step;
    }

    public String toString(){
        return chCond.toString();
    }
}
