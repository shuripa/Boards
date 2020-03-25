package model;

import org.junit.Test;

import java.util.OptionalInt;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

    /**
     * Condition складається з рядка шаблону і робочого кроку.
     * Рядок-шаблон має вигляди "MFC1841034***", робочий крок - 110.
     *
     * Condition пов’язаний з інструментом(Tools), працівником і замовленнями,
     * визначає які замовлення можуть робитись на інструменті а які ні, працівник
     * з якими скілами може бути задіяний на робочому місці.
     *
     * Проверяет Skill на соответсвие условию. Skill содержит:
     * - строку вида MFC184108200A или MFC184700**** или любого другого.
     * - власника
     * - і продуктивність
     *
     * Розширення умови. Умова повинна робити перевірку на проект:
     * - MFC - це проект B9, a MFD - проект C8; крім того на закріпленний проект
     * - рядок; шаблон виробу, або виріб; MFC1841034***
     * - рабочий крок; одно и то же изделие делается в несколько этапов (шагов)
     * 100, 120- вид деятельности; или професия. Вязальник, Тестувальник,
     * Конторський.
     *
     * - закріплення за робочим місцем.
     * Пріоритет при автоматичному розподіленні - закріплене робоче місце.
     * Пріоритети при ручному розподіленні
     * - Проект,
     * - Закріплене робоче місце - відділене зверху сепаратором.
     * - співпадіння рядка, кроку і професії - сильне виділення.
     * - співпадіння рядка, кроку - слабке виділення.
     *
     * Спеціальні символи для парсингу
     *  "?" - одиничний символ
     *  "*" - будь яка кількість символів
     *  "|" - або
     *  "()" - групування, позачерговість
     */

public class ConditionTest {
    Condition c;

    public ConditionTest (){
        c  = new Condition("MFC1847164***", 110);
    }

    @Test
    public void isLikeToStringOnly(){
        assertTrue(c.isLike("MFC1847164***"));      //Результат OptionalInt.empty
        assertTrue(c.isLike("MFC1847164**1"));      //Результат OptionalInt.empty
        assertFalse(c.isLike("MFC1847165***"));     //Результат OptionalInt[10]
        assertFalse(c.isLike("MFC1847175***"));     //Результат OptionalInt[9]
//        Есть всего два варианта findFirst() и findAny(). findAny() ищет любое вхождение но тоже одно.
    }

    @Test
    public void isLikeToString() {
        String s = null;
        Condition c0 = new Condition(s, 110);
//        Символьный массив, содержащий условие может быть null, если условие при создании было равно null
        assertTrue(c0.getConditionAsChar() == null);
//        Передаваемое значение тоже может быть null
        assertFalse(c0.isLike(s, 110));
//        Это из оперы отсеять то что проще
        assertFalse(c.isLike("MFC1847161***", 120));
//        Равное количество символов не объязательно, если будет использоваться парсинг
        assertTrue(c.isLike("MFC1847164***", 110));
        assertTrue(c.isLike("MFC1847164**1", 110));
        assertTrue(c.isLike("MFC1847164*1*", 110));
        assertTrue(c.isLike("MFC18471641**", 110));
        assertFalse(c.isLike("MFC1847165***", 110));
    }

    @Test
    public void isLikeToSkill() {
        Employee e = new Employee("12700", "Shuripa Oleksandr", "096-089-10-20", "C", Profession.BINDER, "B9");
        Skill s = new Skill(e, "MFC1847164A0B", 110, 75.0);
        assertTrue(c.isLike(s));
        Skill s1 = new Skill(e, "MFC1847164A0B", 120, 75.0);
        assertFalse(c.isLike(s1));
        Skill s2 = new Skill(e, "MFC1847165A0B", 110, 75.0);
        assertFalse(c.isLike(s1));

    }

    @Test
    public void isLikeToCondition() {
        Condition c1, c2, c3;
        c1 = new Condition("MFC1847164A0B", 110);
        assertTrue(c1.isLike(c));
        assertTrue(c.isLike(c1));

        c2 = new Condition("MFC1847165***", 110);
        c3 = new Condition("MFC1847164***", 120);
        assertFalse(c.isLike(c2));
        assertFalse(c.isLike(c3));
    }


    @Test
    public void getCharCondition() {
        char[] value = "MFC1847164***".toCharArray();
        assertTrue(OptionalInt.empty() == IntStream
                .range(0, value.length-1)
                .filter(i -> value[i] != c.getConditionAsChar()[i])
                .findAny());
    }

    @Test
    public void getConditionString() {
        assertEquals("MFC1847164***", c.getConditionAsString());
    }

    @Test
    public void getStep() {
        assertTrue(110 == c.getStep());
    }

    @Test
    public void testToString() {

    }

}