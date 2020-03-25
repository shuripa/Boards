package model;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Condition {

    private char[] chCond;
    private int step;

    public Condition(String condition, int step){
        this.step = step;
        if (condition != null) {
            this.chCond = condition.toCharArray();
        }
    }

    public boolean isLike(String value, int step) {
        if (this.step != step) return false;
        return isLike(value);
    }

    public boolean isLike(Skill skill){
        if (skill == null) return false;
        if (step != skill.getStep()) return false;
        return isLike(skill.getMaterialBlank());
    }

    public boolean isLike(Condition condition) {
        if (condition == null) return false;
        if (!(this.step == condition.getStep())) return false;
        return isLike(condition.getConditionAsString());
    }

    public boolean isLike(String value){
//        Символьный массив, содержащий условие может быть null, если условие при создании было равно null
        if (chCond == null) return false;

//        Передаваемое значение тоже может быть null
        if (value == null) return false;
        char[] chValue = value.toCharArray();

//        Равное количество символов не объязательно, если будет использоваться парсинг
        if (chValue.length != chCond.length) return false;

        return OptionalInt.empty() == IntStream
                        .range(0, chValue.length-1)
                        .filter(i -> chValue[i] != chCond[i])
                        .filter(i -> chValue[i] != '*')
                        .filter(i -> chCond[i] != '*')
                        .findAny();
    }

    public char[] getConditionAsChar(){
        return chCond;
    }

    public String getConditionAsString(){
        return new String (chCond);
    }

    public int getStep() {
        return step;
    }

    public String toString(){
        return getConditionAsString() + " : " + step;
    }
}
