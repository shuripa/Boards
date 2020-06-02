package graphics.leyout.components;

import inout.CompositBuilder;
import model.Condition;
import org.junit.Test;

import static org.junit.Assert.*;

/** Board - Tool
 * TЗ На дошці здійснюється переробка матеріалу в продукцію.
 * Дошка має:
 * (1+) id-номер:String іd
 * (2+) назву:String. (Взагалі то id-номер числовий, в загальному випадку не всі
 * id-номера будуть виключно числовими). Якщо говорити про інструмент-tool, то можливо
 * буде йти мова про тип інструменту.
 * (3) Дошка містить умову. Може бути реалізовано як набір умов, або складна умова. В даний час
 * реалізовано як складна умова з одним спеціальним символом *, будь-який 1 сивол.
 * (3.1*) Реалізувати парсінг рядка з спеціальними символами
 * - * - один символ - () - першочергова операція - | - або
 * (4) Модуль що формується на час формування приєднується до дошки.
 * (?5)"Дошка знає шлях до системи МАО"
 * Замовлення які задовільняють цим умовам можуть робитись на цій дошці.
 * (6) Дошку можна розглядати як основну і допоміжну.
 * (7) Має бути можливість розміщення двох робочих місць.Працівника і Учня,
 * або ж Працівника і Помічника.
 * (8) Не всі дошки розміщені на лейауті деякі стоять складені. Потрібен об’єк BoardStore.
 * (9*) Дошки мають допуск до виконання, готовність.
 * (10+) В тестовому режимі використовується builder. Потрібно адаптувати тест.
 * (11) Чому умова відсутня як властивість?
 */

public class BoardTest {

    Board b;
    Condition c;

    public BoardTest(){
        b = new Board();
        c = new Condition("MFC1847034***", 110);
    }

    @Test
    public void building(){
        CompositBuilder builder = new CompositBuilder(1212, "KM 035Cb", "CompositBoard")
                .employer(12713).condition("MFC1847034***");
        b.building(builder);
        assertEquals("Board:\nID = 1212;\nTitle = KM 035Cb;\nCondition = MFC1847034***.", (b.toString()));
    }

    @Test
    public void Id() {
        b.setId("4417");
        assertEquals("4417", (b.getId()));
    }

    @Test
    public void idProperty() {
    }

    @Test
    public void Title() {
        b.setTitle("CP-12");
        assertEquals("CP-12", (b.getTitle()));
    }

    @Test
    public void titleProperty() {
    }

    @Test
    public void Condition() {
        b.setCondition("MFC1847087***", 110);
        assertTrue(b.getCondition().isLike("MFC1847087A0B", 110));
        assertTrue(b.getCondition().isLike("*FC1847087A0B", 110));

        b.setCondition(c);
        assertTrue(b.getCondition().isLike("MFC1847034AOB", 110));
        assertFalse(b.getCondition().isLike("MFC1847034AOB", 100));
        assertFalse(b.getCondition().isLike("1FC1847034AOB", 110));
    }

    @Test
    public void testToString() {
        assertEquals("Board:", (b.toString()));

        b.setId("1010");
        assertEquals("Board:\nID = 1010", b.toString());

        b.setTitle("CbL087");
        assertEquals("Board:\nID = 1010;\nTitle = CbL087",(b.toString()));

        b.setCondition(c);
        assertEquals("Board:\nID = 1010;\nTitle = CbL087;\nCondition = MFC1847034***.",(b.toString()));
    }
}